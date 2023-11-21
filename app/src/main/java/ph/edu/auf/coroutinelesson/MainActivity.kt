package ph.edu.auf.coroutinelesson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ph.edu.auf.coroutinelesson.databinding.ActivityMainBinding
import ph.edu.auf.coroutinelesson.views.AwaitActivity
import ph.edu.auf.coroutinelesson.views.BasicActivity
import ph.edu.auf.coroutinelesson.views.ChildTaskActivity
import ph.edu.auf.coroutinelesson.views.TaskCancelActivity
import ph.edu.auf.coroutinelesson.views.ViewModelActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBasic.setOnClickListener(this)
        binding.btnAwait.setOnClickListener(this)
        binding.btnChildTask.setOnClickListener(this)
        binding.btnCancelTask.setOnClickListener(this)
        binding.btnViewModel.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            (R.id.btn_basic)->{
                val intent = Intent(this, BasicActivity::class.java)
                startActivity(intent)
            }
            (R.id.btn_await)->{
                val intent = Intent(this, AwaitActivity::class.java)
                startActivity(intent)
            }
            (R.id.btn_child_task)->{
                val intent = Intent(this, ChildTaskActivity::class.java)
                startActivity(intent)
            }
            (R.id.btn_cancel_task)->{
                val intent = Intent(this, TaskCancelActivity::class.java)
                startActivity(intent)
            }
            (R.id.btn_view_model)->{
                val intent = Intent(this, ViewModelActivity::class.java)
                startActivity(intent)
            }
        }
    }
}