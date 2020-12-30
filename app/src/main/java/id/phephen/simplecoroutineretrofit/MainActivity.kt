package id.phephen.simplecoroutineretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import id.phephen.simplecoroutineretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tvHello: TextView
    private lateinit var btnReq: Button
    private lateinit var btnViewModel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        tvHello = binding.txt
        btnReq = binding.btnReq
        btnViewModel = binding.btnViewmodel
    }
}