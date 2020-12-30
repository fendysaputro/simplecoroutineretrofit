package id.phephen.simplecoroutineretrofit

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import id.phephen.simplecoroutineretrofit.databinding.ActivityShowDataBinding

class ShowDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowDataBinding
    private lateinit var tvId: TextView
    private lateinit var tvIdTitle: TextView
    private lateinit var tvTitleTitle: TextView
    private lateinit var tvTitle: TextView
    private lateinit var id: String
    private lateinit var title: String
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentData()
        initView()
        showData()
        goBack()
    }

    private fun initView() {
        tvId = binding.tvId
        tvIdTitle = binding.tvIdTitle
        tvTitle = binding.tvTitle
        tvTitleTitle = binding.tvTitleTitle
        btnBack = binding.btnBack
    }

    private fun getIntentData() {
        val score = intent.getIntExtra("id", 0)
        id = score.toString()

        if (intent.hasExtra("title")) {
            val newTitle = intent.getStringExtra("title")
            newTitle?.let {
                title = it
            }
        }
    }

    private fun showData() {
        tvId.text = id
        tvTitle.text = title
    }

    private fun goBack() {
        btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}