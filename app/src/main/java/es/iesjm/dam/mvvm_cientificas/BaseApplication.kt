package es.iesjm.dam.mvvm_cientificas

import android.app.Application
import es.iesjm.dam.mvvm_cientificas.data.CientificasDatabase

// Clase base de la aplicación que extiende de Application.
// Se utiliza para inicializar recursos globales, en este caso la base de datos.
class BaseApplication : Application() {
    // Propiedad 'database' que se inicializa de forma perezosa (lazy).
    // Se obtiene la instancia singleton de la base de datos utilizando el contexto de la aplicación.
    val database: CientificasDatabase by lazy { CientificasDatabase.getDatabase(this) }
}
