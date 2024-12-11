package com.example.myapplication.data

import com.example.myapplication.model.User
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import java.lang.Exception

interface AccountService {
    val currentUser : FirebaseUser?
    val currentUserId:String
    fun hasUser():Boolean

    suspend fun login(email:String, password:String):Resource<FirebaseUser>
    suspend fun signUp(name:String, email: String,password: String):Resource<FirebaseUser>
    fun signOut()


}
sealed class Resource<out R>{
    data class Success<out R>(val result:R): Resource<R>()
    data class Failure(val exception: Exception):Resource<Nothing>()
    data object Loading:Resource<Nothing>()
}