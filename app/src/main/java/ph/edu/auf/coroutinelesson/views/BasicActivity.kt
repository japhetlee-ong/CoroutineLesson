package ph.edu.auf.coroutinelesson.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ph.edu.auf.coroutinelesson.R
import ph.edu.auf.coroutinelesson.databinding.ActivityBasicBinding

class BasicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBasicBinding
    private var counter: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBasicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRun.setOnClickListener{
            //TODO: COROUTINE HERE
        }

        binding.btnClickMe.setOnClickListener{
            //TODO: COROUTINE HERE

        }
    }

}