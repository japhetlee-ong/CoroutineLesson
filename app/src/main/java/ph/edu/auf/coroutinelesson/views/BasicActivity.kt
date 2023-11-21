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
            lifecycleScope.launch {
                val result = runLongTask()
                withContext(Dispatchers.Main.immediate){
                    binding.txtResult.text = result
                }
            }
//            binding.txtResult.text = runLongTaskNotAsync()
        }

        binding.btnClickMe.setOnClickListener{
            //TODO: COROUTINE HERE
            counter += 1
            binding.txtClickMe.text = counter.toString()
        }
    }

    private suspend fun runLongTask(): String{
        delay(2000)
        return "Hello there"
    }

    private fun runLongTaskNotAsync(): String{
        Thread.sleep(2000)
        return "Hello there"
    }

}