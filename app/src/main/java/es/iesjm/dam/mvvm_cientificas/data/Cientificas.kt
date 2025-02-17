package es.iesjm.dam.mvvm_cientificas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="cientificas")
data class Cientificas (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val nombre: String,
    val logros: String,
    val biografia: String
)