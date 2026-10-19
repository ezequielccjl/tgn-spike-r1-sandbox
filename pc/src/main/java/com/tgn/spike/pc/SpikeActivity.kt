package com.tgn.spike.pc

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ScrollView
import android.widget.TextView
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitinstall.SplitInstallHelper
import com.tgn.tgnmovil.pclegacy.PcRealmModule
import com.tgn.tgnmovil.ui.main.medicion.gto.models.PmpGto
import com.tgn.tgnmovil.ui.main.medicion.gto.models.PmpGtoState
import io.realm.Realm
import io.realm.RealmConfiguration
import java.io.File

/**
 * Vive en el split :pc. Realm.init aca (equivale a R3: nada de Realm en Application de la base).
 * Extra "loadLibrary"=true: SplitInstallHelper.loadLibrary(ctx, "realm-jni") antes de Realm.init
 * (escalon 2 del plan, solo si el camino normal falla).
 * Extra "writeTest"=true: setState(ERROR) sobre el primer PmpGto en estado 0 (solo la copia del sandbox).
 */
class SpikeActivity : Activity() {
  private val tag = "SpikePc"

  override fun attachBaseContext(newBase: Context) {
    super.attachBaseContext(newBase)
    SplitCompat.installActivity(this)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val out = StringBuilder()
    fun log(msg: String) { Log.i(tag, msg); out.append(msg).append('\n') }

    log("SpikeActivity en split; sourceDir=${applicationInfo.sourceDir}")
    log("splitSourceDirs=${applicationInfo.splitSourceDirs?.toList()}")
    log("nativeLibraryDir=${applicationInfo.nativeLibraryDir}")
    log("realm-jni mapeada antes de init: ${realmJniMaps()}")
    try {
      if (intent.getBooleanExtra("loadLibrary", false)) {
        log("SplitInstallHelper.loadLibrary(realm-jni)")
        SplitInstallHelper.loadLibrary(this, "realm-jni")
      }
      Realm.init(this)
      log("Realm.init OK")
      log("realm-jni mapeada despues de init: ${realmJniMaps()}")
      // Misma configuracion que TGN (MainApplication.kt) + el modulo de :pc-legacy
      val config = RealmConfiguration.Builder()
        .modules(PcRealmModule())
        .allowWritesOnUiThread(true)
        .build()
      Realm.setDefaultConfiguration(config)
      log("config path=${config.path} existe=${File(config.path).exists()} bytes=${File(config.path).length()}")
      if (intent.getBooleanExtra("writeTest", false)) writeTest(::log)
      SpikeSchemaDump.dump { log(it) }
    } catch (e: Throwable) {
      Log.e(tag, "ERROR: ${e.javaClass.name}: ${e.message}", e)
      out.append("ERROR: ${e.javaClass.name}: ${e.message}\n")
    }
    setContentView(ScrollView(this).apply {
      addView(TextView(this@SpikeActivity).apply { text = out; setPadding(32, 32, 32, 32) })
    })
  }

  /** Escritura a traves de los proxies cargados desde el split. Verificar en el arranque siguiente. */
  private fun writeTest(log: (String) -> Unit) {
    Realm.getDefaultInstance().use { realm ->
      val target = realm.where(PmpGto::class.java).equalTo("State", 0.toShort()).sort("Id").findFirst()
      if (target == null) { log("writeTest: no hay PmpGto en estado 0"); return }
      val id = target.id
      realm.executeTransaction { target.setState(PmpGtoState.ERROR) }
      log("writeTest: WRITE Id=$id State 0 -> ${PmpGtoState.ERROR}")
    }
  }

  /**
   * Archivos mapeados ejecutables que pueden ser la .so de Realm: si se extrajo aparece la ruta de
   * librealm-jni.so; si se carga sin extraer desde el APK aparece el .apk (split_pc.apk o el de SplitCompat).
   */
  private fun realmJniMaps(): List<String> = try {
    File("/proc/self/maps").readLines()
      .filter { it.contains("r-xp") || it.contains("r--p") }
      .map { it.substringAfterLast(' ') }
      .filter { it.contains("realm") || it.contains("split") || it.contains("com.tgn.spike") }
      .distinct()
  } catch (e: Exception) { listOf("no se pudo leer maps: $e") }
}
