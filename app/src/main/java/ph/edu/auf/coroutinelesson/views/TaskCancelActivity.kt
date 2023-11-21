package ph.edu.auf.coroutinelesson.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ph.edu.auf.coroutinelesson.R
import ph.edu.auf.coroutinelesson.databinding.ActivityTaskCancelBinding

class TaskCancelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskCancelBinding
    private lateinit var job : Job
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskCancelBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRun.setOnClickListener{
            //TODO: COROUTINE HERE
            job = lifecycleScope.launch(Dispatchers.Main.immediate) {
                Log.d(TAG,"Starting task")
                val result = runCoroutine()
                binding.txtResult.text = result
            }
        }

        binding.btnCancel.setOnClickListener{
            if(job.isActive){
                Log.d(TAG,"Task is cancelling")
                job.cancel()
                Log.d(TAG,"Task is cancelled")
                binding.txtResult.text = "Coroutine cancelled"
            }
        }

    }

    private suspend fun runCoroutine(): String{
        Log.d(TAG,"Task is running")
        delay(5000)
        Log.d(TAG,"Task is Finished")
        return "HELLO THERE"
    }

    override fun onDestroy() {
        super.onDestroy()
        if(job.isActive){
            job.cancel()
        }
    }

    companion object{
        private val TAG = TaskCancelActivity::class.simpleName
    }
}