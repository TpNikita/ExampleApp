package com.example.users.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.common.base.BaseViewModel
import com.example.model.User
import com.example.users.domain.UsersInteractor
import com.example.users.navigation.UsersRouter
import io.reactivex.android.schedulers.AndroidSchedulers

class UsersViewModel(
        private val interactor: UsersInteractor,
        private val router: UsersRouter
) : BaseViewModel() {

    private val _usersLiveData = MutableLiveData<List<User>>()
    val usersLiveData: LiveData<List<User>> = _usersLiveData

    fun userClicked(user: User) {
        router.openUser(user.id)
    }

    fun getUsers() {
        disposables.add(
            interactor.getUsers()
                .observeOn(AndroidSchedulers.mainThread(), true)
                .subscribe({
                    _usersLiveData.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }
}