package ivan.diaz.dominguez.castingapp

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ivan.diaz.dominguez.castingapp.model.api.Post
import ivan.diaz.dominguez.castingapp.model.service.ApiService
import ivan.diaz.dominguez.castingapp.ui.ActorListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SeleccionCandidatosViewModel : ViewModel() {

    var pelicula:String = ""
    var fechaRodaje:String = ""
    var lugarRodaje:String = ""


    private val retrofit = Retrofit.Builder()
        .baseUrl("https://ghibliapi.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val pokemonList = MutableLiveData<List<Post>>()
    private val service: ApiService = retrofit.create(ApiService::class.java)

    fun getActors(){
        service.getAllPosts().enqueue (object:Callback<List<Post>>{
            override fun onResponse(
                call: Call<List<Post>>?, response: Response<List<Post>>?
            ){
                val posts = response?.body()
                for (post in posts!!){
                    post.id = post.id.subSequence(0,6).toString()
                }
                pokemonList.value = posts!!

            }
            override fun onFailure (call: Call<List<Post>>?, t: Throwable?){
                t?.printStackTrace ()
            }
        })
    }
    fun countChecks(adapter: ActorListAdapter): Bundle {
        var checkedActors: MutableSet<String> = mutableSetOf()
        var list :List<Post> = adapter.actorList!!
        var i = 0
        var paquete : Bundle = Bundle()

        for(actor in list){
            if(actor.checked){
                checkedActors.add(actor.id)
            }
        }

        paquete.putString("fechaRodaje",fechaRodaje)
        paquete.putString("lugarRodaje",lugarRodaje)
        paquete.putString("pelicula",pelicula)
        paquete.putStringArray("actores",checkedActors.toTypedArray())
        return paquete
    }
}