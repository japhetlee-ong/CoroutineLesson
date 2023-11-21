package ph.edu.auf.coroutinelesson.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ph.edu.auf.coroutinelesson.R
import ph.edu.auf.coroutinelesson.databinding.ActivityAwaitBinding

class AwaitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAwaitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAwaitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRun.setOnClickListener{
           //TODO: COROUTINE HERE
            binding.txtResult.text = "Starting coroutine"
            lifecycleScope.launch {
                val resultOne = async { awaitLongFunctionOne() }
                val resultTwo = async { awaitLongFunctionTwo() }
                val resOne = resultOne.await()
                val resTwo = resultTwo.await()
                withContext(Dispatchers.Main.immediate){
                    binding.txtResult.text = (resOne + resTwo).toString()
                }
            }
        }

    }

    private suspend fun awaitLongFunctionOne(): Int {
        delay(5000)
        Log.d(AwaitActivity::class.simpleName,"Task 1 done")
        return 20
    }

    private suspend fun awaitLongFunctionTwo(): Int {
        delay(2000)
        Log.d(AwaitActivity::class.simpleName,"Task 2 done")
        return 20
    }

}