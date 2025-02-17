package es.iesjm.dam.mvvm_cientificas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cientificas::class], version = 1)
abstract class CientificasDatabase : RoomDatabase() {
    abstract fun cientificasDao(): CientificasDao

    companion object {
        @Volatile
        private var INSTANCE: CientificasDatabase? = null

        fun getDatabase(context: Context): CientificasDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    CientificasDatabase::class.java,
                    "cientificas_database"
                )
                    .createFromAsset("database/cientificas.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}
