package es.iesjm.dam.mvvm_cientificas.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CientificasDao {

    @Query("SELECT * FROM cientificas")
    fun getAll(): Flow<List<Cientificas>>
}