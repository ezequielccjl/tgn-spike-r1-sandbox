# Sandbox spike R1 parte B (TGN Movil, PoC Play Feature Delivery)

Pregunta que responde: Realm (`librealm-jni.so` + proxies generados en una android library) funciona
desde un split de dynamic feature instalado a demanda, sin que la base tenga Realm.
Resultado (16/10/2026): si, sin `loadLibrary` ni reinicio. Detalle completo en el repo de TGN:
`docs/poc/spike-r1-plan.md` (Resultados, Parte B) y `docs/poc/spike-r1/parte-b-logcat.txt`.

## Modulos

- `:app` (base, `com.tgn.spike`): sin Realm. `SplitCompat.install` en la Application; boton "Abrir PC"
  que instala `pc` con `SplitInstallManager` y abre `com.tgn.spike.pc.SpikeActivity` por nombre.
- `:pc-legacy`: copia de `android/pc-legacy` de la rama `spike/r1-realm-library` de TGN
  (17 modelos + 3 clases de apoyo + `PcRealmModule`, plugin `realm-android`).
- `:pc` (dynamic feature, onDemand): depende de `:app`, `:pc-legacy` y `realm-android-library`
  (sin el plugin). `SpikeActivity` hace `Realm.init`, abre `files/default.realm` y loguea esquema y conteos.
  Extras: `writeTest` (escribe un PmpGto, solo en una copia) y `loadLibrary` (fallback, no hizo falta).

Versiones = TGN: AGP 8.12.0, Gradle 9.3.1, Kotlin 2.1.20, Realm 10.19.0, compileSdk/targetSdk 36, minSdk 26, JDK 21.

## Correrlo (Git Bash)

```bash
echo "sdk.dir=C\:/ruta/al/Android/Sdk" > local.properties   # o abrir en Android Studio
./gradlew :app:bundleDebug
BT="java -jar <ruta>/bundletool-all-1.18.3.jar"; DEV=emulator-5554
mkdir -p build/apks
$BT build-apks --bundle=app/build/outputs/bundle/debug/app-debug.aab --output=build/apks/local-testing.apks \
  --local-testing --connected-device --device-id=$DEV --overwrite
$BT build-apks --bundle=app/build/outputs/bundle/debug/app-debug.aab --output=build/apks/all.apks --overwrite
$BT install-apks --apks=build/apks/local-testing.apks --device-id=$DEV   # base sola; pc queda en local_testing/

# Datos: abrir la app una vez (crea files/) y copiar el respaldo de Realm (NO esta en este repo)
export MSYS_NO_PATHCONV=1; ADB="adb -s $DEV"
$ADB shell am start -W -n com.tgn.spike/.MainActivity; $ADB shell am force-stop com.tgn.spike
$ADB push "C:/ruta/default.realm.2026-10-16" /data/local/tmp/spike-default.realm
$ADB shell run-as com.tgn.spike cp /data/local/tmp/spike-default.realm files/default.realm
$ADB shell rm /data/local/tmp/spike-default.realm

# Prueba: instala pc a demanda y abre PC
$ADB logcat -c; $ADB shell am start -n com.tgn.spike/.MainActivity --ez autoOpen true
$ADB logcat -d | grep -E "SpikeBase|SpikePc|nativeloader.*realm|RealmMigration|FATAL"
$ADB logcat -d -v raw -s RealmSchemaDump:I > schema.txt   # diff contra docs/poc/spike-r1/schema-before.txt de TGN

# Split instalado por PackageManager (sin emulacion)
$BT install-apks --apks=build/apks/all.apks --modules=_ALL_ --device-id=$DEV

# Peso (get-size --modules=pc incluye la base: restar la base)
$BT get-size total --apks=build/apks/all.apks --dimensions=ABI --modules=base
$BT get-size total --apks=build/apks/all.apks --dimensions=ABI --modules=pc
```

Esperado con el respaldo del 16/10: `dynamic = typed total=631 porEstado={0=609, 1=4, 2=18}`, esquema identico.
Con dos equipos conectados, siempre `adb -s` y `--device-id`.
