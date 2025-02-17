package es.iesjm.dam.mvvm_cientificas.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

// Anotación @Dao indica que esta interfaz es un Data Access Object para Room.
// Aquí se definen los métodos para acceder a la base de datos.
@Dao
interface CientificasDao {

    // La anotación @Query define la consulta SQL a ejecutar.
    // En este caso, se seleccionan todos los registros de la tabla "cientificas".
    // El método devuelve un Flow que emite una lista de objetos Cientificas,
    // permitiendo observar de forma reactiva los cambios en la base de datos.
    @Query("SELECT * FROM cientificas")
    fun getAll(): Flow<List<Cientificas>>
}
