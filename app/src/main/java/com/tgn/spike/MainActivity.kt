package com.tgn.spike

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus

/** Base sin Realm: instala :pc a demanda y abre SpikeActivity por nombre (sin referenciar la clase). */
class MainActivity : Activity() {
  private val tag = "SpikeBase"
  private val module = "pc"
  private val spikeActivity = "com.tgn.spike.pc.SpikeActivity"
  private lateinit var status: TextView
  private val manager by lazy { SplitInstallManagerFactory.create(this) }

  private val listener = SplitInstallStateUpdatedListener { state ->
    val name = statusName(state.status())
    Log.i(tag, "session=${state.sessionId()} status=$name modules=${state.moduleNames()} bytes=${state.bytesDownloaded()}/${state.totalBytesToDownload()} error=${state.errorCode()}")
    status.text = "Estado: $name"
    if (state.status() == SplitInstallSessionStatus.INSTALLED) openPc()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    status = TextView(this)
    val button = Button(this).apply { text = "Abrir PC"; setOnClickListener { installAndOpen() } }
    setContentView(LinearLayout(this).apply {
      orientation = LinearLayout.VERTICAL
      setPadding(48, 48, 48, 48)
      addView(button); addView(status)
    })
    status.text = "Instalados: ${manager.installedModules}"
    Log.i(tag, "onCreate installedModules=${manager.installedModules} realmEnBase=${classExists("io.realm.Realm")}")
    if (intent.getBooleanExtra("autoOpen", false)) installAndOpen()
  }

  override fun onResume() { super.onResume(); manager.registerListener(listener) }
  override fun onPause() { manager.unregisterListener(listener); super.onPause() }

  private fun installAndOpen() {
    if (manager.installedModules.contains(module)) {
      Log.i(tag, "modulo $module ya instalado")
      openPc(); return
    }
    Log.i(tag, "instalando $module")
    manager.startInstall(SplitInstallRequest.newBuilder().addModule(module).build())
      .addOnSuccessListener { Log.i(tag, "startInstall ok session=$it") }
      .addOnFailureListener { Log.e(tag, "startInstall fallo: $it", it) }
  }

  private fun openPc() {
    Log.i(tag, "abriendo $spikeActivity")
    // Reenvia los extras (loadLibrary, writeTest) a SpikeActivity, que no es exportada
    startActivity(Intent().setClassName(packageName, spikeActivity).putExtras(intent))
  }

  private fun classExists(name: String) = try { Class.forName(name); true } catch (e: ClassNotFoundException) { false }

  private fun statusName(s: Int) = when (s) {
    SplitInstallSessionStatus.PENDING -> "PENDING"
    SplitInstallSessionStatus.DOWNLOADING -> "DOWNLOADING"
    SplitInstallSessionStatus.DOWNLOADED -> "DOWNLOADED"
    SplitInstallSessionStatus.INSTALLING -> "INSTALLING"
    SplitInstallSessionStatus.INSTALLED -> "INSTALLED"
    SplitInstallSessionStatus.FAILED -> "FAILED"
    SplitInstallSessionStatus.CANCELED -> "CANCELED"
    SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> "REQUIRES_USER_CONFIRMATION"
    else -> "status=$s"
  }
}
