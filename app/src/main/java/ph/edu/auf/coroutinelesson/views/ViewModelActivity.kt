package ph.edu.auf.coroutinelesson.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ph.edu.auf.coroutinelesson.R
import ph.edu.auf.coroutinelesson.adapters.SampleAdapter
import ph.edu.auf.coroutinelesson.databinding.ActivityViewModelBinding
import ph.edu.auf.coroutinelesson.models.UserModel

class ViewModelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewModelBinding
    private lateinit var adapter: SampleAdapter
    private lateinit var userList: ArrayList<UserModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userList = arrayListOf()
        adapter = SampleAdapter(userList)

        val layoutManager = LinearLayoutManager(this)
        binding.rvSampleUsers.layoutManager = layoutManager
        binding.rvSampleUsers.adapter = adapter

        binding.btnAddUsers.setOnClickListener{
        }

    }
}