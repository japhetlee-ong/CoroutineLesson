package ph.edu.auf.coroutinelesson.database

import kotlinx.coroutines.delay
import ph.edu.auf.coroutinelesson.models.UserModel
import kotlin.random.Random

class UserRepository {
    private val usernameList : ArrayList<String> = arrayListOf("alice_123", "bobSmith", "charlieBrown", "david_w", "eva_d")
    private val emailList : ArrayList<String> = arrayListOf("alice@example.com", "bob@example.com", "charlie@example.com", "david@example.com", "eva@example.com")
    private val nameList: ArrayList<String> = arrayListOf("Alice Johnson", "Bob Smith", "Charlie Brown", "David Williams", "Eva Davis")


    suspend fun getUsers(): ArrayList<UserModel>{
        delay(5000)
        return generateUsers()
    }

    private fun generateUsers(): ArrayList<UserModel>{
        val userModel : ArrayList<UserModel> = arrayListOf()
        for( x in 1..5){
            userModel.add(
                UserModel(
                    name = nameList[Random.nextInt(0,nameList.size - 1)],
                    email = emailList[Random.nextInt(0,emailList.size - 1)],
                    username = usernameList[Random.nextInt(0,usernameList.size - 1)]
                )
            )
        }
        return userModel
    }
}