package com.tgn.tgnmovil.pclegacy;

import io.realm.annotations.RealmModule;

/**
 * Modulo Realm explicito de PC. Reemplaza al DefaultRealmModule implicito de :app.
 * allClasses = true incluye los 17 modelos de esta library.
 */
@RealmModule(library = true, allClasses = true)
public class PcRealmModule {
}
