package id.phephen.simplecoroutineretrofit.data.viewmodel

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.phephen.simplecoroutineretrofit.R
import id.phephen.simplecoroutineretrofit.ShowDataActivity
import id.phephen.simplecoroutineretrofit.data.model.Todo
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by phephen on 28,December,2020
 * https://github.com/fendysaputro
 */
class DemoWithViewModel : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm = ViewModelProvider(this).get(DemoViewModel::class.java)

        vm._todo.observe(this, Observer { todo ->
            showResult(todo)
        })

        vm._error.observe(this, Observer { error ->
            if (error.isNotEmpty()) {
                showError(error)
            }
        })

        btnReq.setOnClickListener {
            val rnd = (1..66).random()
            vm.getTodo(rnd)
        }

        btnViewmodel.visibility = View.GONE
    }

    private fun showResult(result: Todo) {
        txt.text = result.title
        val intent = Intent(this, ShowDataActivity::class.java)
        intent.putExtra("id", result.id)
        intent.putExtra("title", result.title)
        startActivity(intent)
    }

    private fun showError(error: String?) {
        Toast.makeText(this, "Error $error", Toast.LENGTH_SHORT).show()
    }
}