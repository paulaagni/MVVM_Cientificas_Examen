package es.iesjm.dam.mvvm_cientificas

import android.app.Application
import es.iesjm.dam.mvvm_cientificas.data.CientificasDatabase

class BaseApplication : Application() {
    val database: CientificasDatabase by lazy { CientificasDatabase.getDatabase(this) }
}