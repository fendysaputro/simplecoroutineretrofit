package id.phephen.simplecoroutineretrofit.data.repository

import id.phephen.simplecoroutineretrofit.data.Webservices
import id.phephen.simplecoroutineretrofit.data.myApi

/**
 * Created by phephen on 28,December,2020
 * https://github.com/fendysaputro
 */
class TodoRepository {
    private var services: Webservices = myApi

    suspend fun getTodo(id: Int) = services.getTodo(id)
}