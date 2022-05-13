package ivan.diaz.dominguez.castingapp.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ivan.diaz.dominguez.castingapp.database.dao.CastingDao
import ivan.diaz.dominguez.castingapp.database.entities.CastingModel

@Database(entities = [CastingModel::class], version = 1)
abstract class CastingDatabase : RoomDatabase() {
    abstract fun castingDao(): CastingDao

    companion object {
        @Volatile
        private var INSTANCE: CastingDatabase? = null
        fun getDatabase(
            context: Context
        ): CastingDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    CastingDatabase::class.java,
                    "app_database"
                )
                    .createFromAsset("database/sqliteP.db")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}