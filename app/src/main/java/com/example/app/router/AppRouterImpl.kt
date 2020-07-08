package com.example.app.router

import android.os.Bundle
import androidx.navigation.NavController
import com.example.app.R
import com.example.user.presentation.UserFragment
import javax.inject.Inject

class AppRouterImpl @Inject constructor(private val navController: NavController) : AppRouter {

    override fun openUser(userId: Int) {
        val bundle = UserFragment.createBundle(userId)
        navigateTo(R.id.action_usersFragment_to_userFragment, bundle)
    }

    override fun openUsers() {
        navigateTo(R.id.action_splashFragment_to_usersFragment)
    }

    private fun navigateTo(actionId: Int, bundle: Bundle? = null) {
        navController.navigate(actionId, bundle)
    }
}
