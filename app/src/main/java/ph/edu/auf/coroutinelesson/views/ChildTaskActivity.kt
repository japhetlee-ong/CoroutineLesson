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
        }

    }

}