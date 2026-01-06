package data.model.repository

import data.model.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserRepository {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    fun login(email: String) {
        _user.value = User(email);
    }

    fun logout() {
        _user.value = null
    }
}