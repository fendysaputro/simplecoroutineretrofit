package id.phephen.simplecoroutineretrofit.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.phephen.simplecoroutineretrofit.data.model.Todo
import id.phephen.simplecoroutineretrofit.data.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

/**
 * Created by phephen on 28,December,2020
 * https://github.com/fendysaputro
 */
class DemoViewModel : ViewModel (){

    private var repo = TodoRepository()

    var _todo = MutableLiveData<Todo>()
    var _error = MutableLiveData<String>()

    fun getTodo(id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = repo.getTodo(id)
                    _todo.postValue(result)
                } catch (throwable: Throwable) {
                    when(throwable) {
                        is IOException -> {
                            _error.postValue("Network Error")
                        }
                        is HttpException -> {
                            val code = throwable.code()
                            val errorResponse = throwable.message()
                            _error.postValue("Error $code $errorResponse")
                        }
                        else -> {
                            _error.postValue("Unknown Error")
                        }
                    }
                }
            }
        }
    }
}