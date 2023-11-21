package ph.edu.auf.coroutinelesson.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import ph.edu.auf.coroutinelesson.R
import ph.edu.auf.coroutinelesson.adapters.SampleAdapter
import ph.edu.auf.coroutinelesson.databinding.ActivityViewModelBinding
import ph.edu.auf.coroutinelesson.models.UserModel
import ph.edu.auf.coroutinelesson.viewmodels.UserViewModel

class ViewModelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewModelBinding
    private lateinit var adapter: SampleAdapter
    private lateinit var userList: ArrayList<UserModel>
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        userList = arrayListOf()
        adapter = SampleAdapter(userList)

        val layoutManager = LinearLayoutManager(this)
        binding.rvSampleUsers.layoutManager = layoutManager
        binding.rvSampleUsers.adapter = adapter

        binding.btnAddUsers.setOnClickListener{
            viewModel.getUsers()
        }

        viewModel.userList.observe(this){
            userList.addAll(it)
            adapter.notifyItemInserted(userList.size - 1)
        }

        viewModel.isLoading.observe(this){
            binding.btnAddUsers.isEnabled = !it
            binding.indLoading.visibility = if(it) View.VISIBLE else View.GONE
        }

    }

}