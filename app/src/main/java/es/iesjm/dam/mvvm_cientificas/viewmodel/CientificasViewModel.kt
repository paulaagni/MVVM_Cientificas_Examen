// Gestión de la lógica de negocio y exposición de datos para la vista.
package es.iesjm.dam.mvvm_cientificas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import es.iesjm.dam.mvvm_cientificas.BaseApplication
import es.iesjm.dam.mvvm_cientificas.data.Cientificas
import es.iesjm.dam.mvvm_cientificas.data.CientificasDao
import kotlinx.coroutines.flow.Flow

// ViewModel que gestiona los datos relacionados con "Cientificas".
class CientificasViewModel(private val cientificasDao: CientificasDao) : ViewModel() {

    // Función que retorna un Flow de lista de científicas.
    // Se delega la obtención de datos al DAO, permitiendo observar los cambios de forma reactiva.
    fun getCientificas(): Flow<List<Cientificas>> = cientificasDao.getAll()

    companion object {
        // Definición del Factory para crear instancias del ViewModel.
        // Se utiliza viewModelFactory para simplificar la creación y pasarle parámetros.
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                // Se obtiene la instancia de la aplicación y, a partir de ella, el DAO.
                val application = (this[APPLICATION_KEY] as BaseApplication)
                // Se crea el ViewModel con el DAO obtenido.
                CientificasViewModel(application.database.cientificasDao())
            }
        }
    }
}
