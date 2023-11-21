package ph.edu.auf.coroutinelesson.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ph.edu.auf.coroutinelesson.database.UserRepository
import ph.edu.auf.coroutinelesson.models.UserModel

class UserViewModel : ViewModel() {

    private var _userList = MutableLiveData<ArrayList<UserModel>>()
    private var _isLoading = MutableLiveData(false)

    private val userRepo: UserRepository = UserRepository()
    //TODO: REPOSITORY CLASS CALL

    val userList : LiveData<ArrayList<UserModel>> get() = _userList
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun getUsers(){
        _isLoading.value = true
        viewModelScope.launch {
            //TODO: REPOSITORY RESPONSE
            _userList.value = userRepo.getUsers()
            _isLoading.value = false
        }
    }

}