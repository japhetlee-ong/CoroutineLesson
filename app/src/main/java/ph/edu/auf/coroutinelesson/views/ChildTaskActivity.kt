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
import ph.edu.auf.coroutinelesson.databinding.ActivityChildTaskBinding

class ChildTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChildTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChildTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRun.setOnClickListener{
            //TODO: COROUTINE DISCUSSION HERE
            //parentTask()
            parentTaskWithRes()
        }

    }

    private fun parentTask(){
        Log.d(TAG,"Parent Task starting")

        lifecycleScope.launch(Dispatchers.Main) {
            Log.d(TAG,"Running Parent Task")
            //TODO: CREATE CHILD FUNC
            childTask(coroutineContext[Job]!!)
            Log.d(TAG,"End of Parent task")
        }

    }

    private fun parentTaskWithRes(){
        Log.d(TAG,"Parent Task starting")

        lifecycleScope.launch(Dispatchers.Main.immediate) {
            Log.d(TAG,"Running Parent Task")
            //TODO: CREATE CHILD FUNC
            val res = childTaskWithRes(coroutineContext[Job]!!)
            binding.txtResultTwo.text = res
            Log.d(TAG,"End of Parent task")
        }

    }

    private suspend fun childTask(parent: Job){
        withContext(Dispatchers.Default){
            Log.d(TAG,"Child task starting")
            parent.cancel()
            Log.d(TAG,"Child task parent cancelled")

            delay(2000)
            Log.d(TAG,"Child task end")
        }
    }

    private suspend fun childTaskWithRes(parent: Job): String{
        return withContext(Dispatchers.Default){
            Log.d(TAG,"Child task start")
            delay(2000)
            Log.d(TAG,"Child task finished")
            return@withContext "Hello there"
        }
    }

    companion object{
        private val TAG = ChildTaskActivity::class.java.simpleName
    }

}