package ivan.diaz.dominguez.castingapp.model.service

import ivan.diaz.dominguez.castingapp.model.api.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService{
    @GET("people")
    fun getAllPosts(): Call<List<Post>>

}