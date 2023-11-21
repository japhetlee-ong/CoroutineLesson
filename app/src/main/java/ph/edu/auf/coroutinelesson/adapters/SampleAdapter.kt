package ph.edu.auf.coroutinelesson.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ph.edu.auf.coroutinelesson.databinding.ContentSampleRvBinding
import ph.edu.auf.coroutinelesson.models.UserModel

class SampleAdapter (private var nameList: ArrayList<UserModel>) : RecyclerView.Adapter<SampleAdapter.SampleViewHolder>() {

    inner class SampleViewHolder(val binding: ContentSampleRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        val binding =
            ContentSampleRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SampleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        with(holder) {
            with(nameList[position]) {
                binding.txtEmail.text = this.email
                binding.txtName.text = this.name
                binding.txtUsername.text = this.username

            }
        }
    }
}