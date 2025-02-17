package es.iesjm.dam.mvvm_cientificas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Anotación que indica que esta clase representa una entidad en la base de datos Room.
// La tabla se llamará "cientificas".
@Entity(tableName = "cientificas")
data class Cientificas (
    // Propiedad 'id' que sirve como clave primaria de la tabla.
    // 'autoGenerate = true' indica que su valor se asignará automáticamente (incrementalmente) al insertar nuevos registros.
    @PrimaryKey(autoGenerate = true) val id: Int,

    // Propiedad que almacena el nombre de la científica.
    val nombre: String,

    // Propiedad que contiene una descripción de los logros alcanzados por la científica.
    val logros: String,

    // Propiedad que guarda una breve biografía de la científica.
    val biografia: String
)
