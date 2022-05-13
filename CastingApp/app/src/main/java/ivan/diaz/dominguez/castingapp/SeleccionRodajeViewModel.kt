package ivan.diaz.dominguez.castingapp

import android.os.Bundle
import androidx.lifecycle.ViewModel
import java.util.*

class SeleccionRodajeViewModel : ViewModel() {
    val peliculas = arrayOf("John Wick", "Matrix", "Rambo")
    var peliculaSeleccionada = peliculas[0]

    fun getDataBundle(fechaRodaje: String,lugarRodaje:String):Bundle{
        var paquete : Bundle = Bundle()

        paquete.putString("fechaRodaje",fechaRodaje)

        paquete.putString("lugarRodaje",lugarRodaje)

        paquete.putString("pelicula",peliculaSeleccionada)

        return paquete
    }
}