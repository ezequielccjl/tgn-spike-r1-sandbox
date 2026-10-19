package com.tgn.spike.pc

import android.util.Log
import io.realm.Realm

/**
 * Copia de SpikeSchemaDump.kt de la rama spike/r1-realm-library (parte A), para la parte B.
 * Cambios: package, sin writeTestOnce (no se escribe en la copia de la base) y un callback
 * para mostrar el resumen en pantalla. Los mensajes de log son los mismos (diff contra schema-before.txt).
 * Imprime el esquema de Realm de forma determinista para comparar con diff
 * antes y despues de mover los modelos a :pc-legacy:
 *   adb logcat -d -s RealmSchemaDump:I
 */
object SpikeSchemaDump {
  private const val TAG = "RealmSchemaDump"

  fun dump(summary: (String) -> Unit = {}) {
    try {
      Realm.getDefaultInstance().use { realm ->
        Log.i(TAG, "BEGIN fileSchemaVersion=${realm.version} configSchemaVersion=${realm.configuration.schemaVersion}")
        realm.schema.all.sortedBy { it.className }.forEach { cls ->
          Log.i(TAG, "class ${cls.className} embedded=${cls.isEmbedded}")
          cls.fieldNames.sorted().forEach { field ->
            Log.i(
              TAG,
              "  ${cls.className}.$field type=${cls.getFieldType(field)}" +
                " required=${cls.isRequired(field)}" +
                " pk=${cls.isPrimaryKey(field)}" +
                " index=${cls.hasIndex(field)}"
            )
          }
        }
        Log.i(TAG, "END classes=${realm.schema.all.size}")
        summary("esquema: fileSchemaVersion=${realm.version} clases=${realm.schema.all.size}")
      }
      dumpPmpGtoStates(summary)
    } catch (e: Throwable) {
      Log.e(TAG, "ERROR abriendo Realm: ${e.javaClass.name}: ${e.message}", e)
      summary("ERROR abriendo Realm: ${e.javaClass.name}: ${e.message}")
    }
  }

  /**
   * Cuenta PmpGto por estado de dos formas:
   * - DynamicRealm: lee la columna "State" directo, sin las clases de los modelos (la verdad del archivo).
   * - Tipado + getState(): el camino que usa la app (proxies generados en :pc-legacy).
   * Si difieren, la lectura a traves de los proxies esta mal.
   */
  private fun dumpPmpGtoStates(summary: (String) -> Unit) {
    val tag = "PmpGtoStates"
    try {
      io.realm.DynamicRealm.getInstance(Realm.getDefaultConfiguration()!!).use { dyn ->
        val all = dyn.where("PmpGto").findAll()
        val byState = all.groupingBy { it.getShort("State") }.eachCount().toSortedMap()
        Log.i(tag, "dynamic total=${all.size} porEstado=$byState")
        summary("dynamic total=${all.size} porEstado=$byState")
        all.filter { it.getShort("State").toInt() != 0 }
          .sortedBy { it.getString("Id") }
          .forEach { Log.i(tag, "  dynamic Id=${it.getString("Id")} orden=${it.getString("orden")} State=${it.getShort("State")} lat=${it.getString("latitud")} lon=${it.getString("longitud")}") }
        val coords = all.map { "${it.getString("latitud")},${it.getString("longitud")}" }
        Log.i(tag, "dynamic coords distintas=${coords.toSet().size} cero/vacias=${coords.count { c -> c.split(",").all { v -> v == "null" || v.isBlank() || v.toDoubleOrNull() == 0.0 } }} ejemplo=${coords.take(3)}")
      }
      Realm.getDefaultInstance().use { realm ->
        val all = realm.where(com.tgn.tgnmovil.ui.main.medicion.gto.models.PmpGto::class.java).findAll()
        val byState = all.groupingBy { it.state }.eachCount().toSortedMap()
        Log.i(tag, "typed total=${all.size} porEstado=$byState")
        summary("typed total=${all.size} porEstado=$byState")
        all.filter { it.state.toInt() != 0 }
          .sortedBy { it.id }
          .forEach { Log.i(tag, "  typed Id=${it.id} orden=${it.orden} State=${it.state} lat=${it.latitud} lon=${it.longitud}") }
        val coords = all.map { "${it.latitud},${it.longitud}" }
        Log.i(tag, "typed coords distintas=${coords.toSet().size} cero/vacias=${coords.count { c -> c.split(",").all { v -> v == "null" || v.isBlank() || v.toDoubleOrNull() == 0.0 } }} ejemplo=${coords.take(3)}")
      }
    } catch (e: Throwable) {
      Log.e(tag, "ERROR contando PmpGto: ${e.javaClass.name}: ${e.message}", e)
    }
  }
}
