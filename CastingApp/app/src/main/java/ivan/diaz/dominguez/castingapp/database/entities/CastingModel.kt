package ivan.diaz.dominguez.castingapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
@Entity(tableName = "tabla_casting")
data class CastingModel (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val idCasting : Int = 0,
    @ColumnInfo(name = "pelicula")
    val nombrePelicula:String,
    @ColumnInfo(name = "fecha")
    val fecha: Date,
    @ColumnInfo(name = "lugar")
    val lugarGrabacion: String,
    @ColumnInfo(name = "candidato")
    val idCandidato: String
    )