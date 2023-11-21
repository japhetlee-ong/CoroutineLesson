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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskCancelBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRun.setOnClickListener{
            //TODO: COROUTINE HERE
        }

        binding.btnCancel.setOnClickListener{
            //TODO: COROUTINE HERE
        }

    }

    companion object{
        private val TAG = TaskCancelActivity::class.simpleName
    }
}