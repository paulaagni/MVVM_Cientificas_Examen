package es.iesjm.dam.mvvm_cientificas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Anotación @Database: Define que esta clase es una base de datos Room.
// - entities: Lista de entidades (tablas) que componen la base de datos.
// - version: Número de versión de la base de datos, útil para manejar migraciones.
@Database(entities = [Cientificas::class], version = 1)
abstract class CientificasDatabase : RoomDatabase() {

    // Función abstracta que devuelve el DAO (Data Access Object) para la entidad Cientificas.
    abstract fun cientificasDao(): CientificasDao

    companion object {
        // La variable INSTANCE es volátil para asegurar que los cambios sean visibles entre hilos.
        @Volatile
        private var INSTANCE: CientificasDatabase? = null

        // Función para obtener la instancia singleton de la base de datos.
        // Se asegura de que solo exista una instancia de la base de datos en toda la aplicación.
        fun getDatabase(context: Context): CientificasDatabase {
            // Si ya existe una instancia, se retorna; de lo contrario, se sincroniza la creación.
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    CientificasDatabase::class.java,
                    "cientificas_database" // Nombre de la base de datos.
                )
                    // Crea la base de datos a partir de un asset preexistente, en este caso "database/cientificas.db".
                    .createFromAsset("database/cientificas.db")
                    // En caso de migración sin definir, destruye la base de datos y la reconstruye.
                    .fallbackToDestructiveMigration()
                    // Construye la base de datos.
                    .build()
                    .also {
                        // Asigna la nueva instancia a INSTANCE.
                        INSTANCE = it
                    }
            }
        }
    }
}
