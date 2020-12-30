package id.phephen.simplecoroutineretrofit.data

import id.phephen.simplecoroutineretrofit.data.model.Todo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by phephen on 28,December,2020
 * https://github.com/fendysaputro
 */

const val BASE_URL : String = "https://jsonplaceholder.typicode.com/"

interface Webservices {
    @GET("/todos/{id}")
    suspend fun getTodo(@Path("id") id: Int): Todo
}

val myApi: Webservices by lazy {
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Webservices::class.java)
}
