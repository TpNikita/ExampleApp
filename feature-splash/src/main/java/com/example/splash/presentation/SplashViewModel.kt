package com.example.splash.presentation

import androidx.lifecycle.MutableLiveData
import com.example.common.base.BaseViewModel
import com.example.common.utils.Event
import com.example.splash.navigation.SplashRouter

class SplashViewModel(
    private val router: SplashRouter
) : BaseViewModel() {

    val openScannerEvent = MutableLiveData<Event<Unit>>()

    init {
        openScannerEvent.value = Event(Unit)
    }

    fun openScanner() {
        router.openUsers()
    }
}