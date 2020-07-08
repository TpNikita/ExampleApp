package com.example.splash.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.common.utils.EventObserver
import com.example.common.utils.findComponentDependencies
import com.example.common.utils.findRouterDependencies
import com.example.splash.R
import com.example.splash.di.SplashComponent
import javax.inject.Inject

class SplashFragment : Fragment() {

    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        SplashComponent.init(this, findComponentDependencies(), findRouterDependencies())
            .inject(this)

        splashViewModel.openScannerEvent.observe(this, EventObserver {
            splashViewModel.openScanner()
        })
    }
}