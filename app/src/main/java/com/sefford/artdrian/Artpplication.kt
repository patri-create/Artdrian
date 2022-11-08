package com.sefford.artdrian

import android.app.Application
import com.sefford.artdrian.di.ApplicationModule
import com.sefford.artdrian.di.CoreModule
import com.sefford.artdrian.di.DaggerApplicationComponent

class Artpplication : Application() {

    val graph = DaggerApplicationComponent.builder()
        .applicationModule(ApplicationModule(this))
        .coreModule(CoreModule(Endpoints.ENDPOINT))
        .build()

    override fun onCreate() {
        super.onCreate()
        graph.inject(this)
    }
}
