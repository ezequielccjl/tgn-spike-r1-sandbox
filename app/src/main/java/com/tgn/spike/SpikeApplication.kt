package com.tgn.spike

import android.app.Application
import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat

class SpikeApplication : Application() {
  override fun attachBaseContext(base: Context) {
    super.attachBaseContext(base)
    // Necesario para cargar splits instalados en esta misma ejecucion (y en --local-testing)
    SplitCompat.install(this)
  }
}
