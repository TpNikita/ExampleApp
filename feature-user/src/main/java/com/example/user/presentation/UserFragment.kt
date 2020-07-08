package com.example.user.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.example.common.base.BaseFragment
import com.example.common.utils.findComponentDependencies
import com.example.user.R
import com.example.user.di.UserComponent
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : BaseFragment<UserViewModel>() {

    companion object {
        private const val KEY_USER_ID = "user_id"

        fun createBundle(userId: Int) = Bundle()
            .also { it.putInt(KEY_USER_ID, userId) }
    }

    override fun inject() {
        val userId = arguments?.getInt(KEY_USER_ID, 0) ?: 0

        UserComponent.init(this, userId, findComponentDependencies())
            .inject(this)
    }

    override fun layoutResource(): Int {
        return R.layout.fragment_user
    }

    override fun initViews() {
        toolbar.setTitle(getString(R.string.user_title))
        toolbar.setHomeButtonListener { finish() }
        toolbar.showHomeButton()
    }

    override fun subscribe(viewModel: UserViewModel) {
        viewModel.userLiveData.observe(this, Observer {
            firstNameTv.text = it.firstName
            lastNameTv.text = it.lastName
        })
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(menuItem)
    }
}
