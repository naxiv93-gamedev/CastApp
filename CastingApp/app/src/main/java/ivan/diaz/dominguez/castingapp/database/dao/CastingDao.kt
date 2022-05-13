package ivan.diaz.dominguez.castingapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ivan.diaz.dominguez.castingapp.database.entities.CastingModel

@Dao
interface CastingDao {
    @Query("SELECT * FROM tabla_casting")
    suspend fun getAllCastings():List<CastingModel>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes:List<CastingModel>)
}