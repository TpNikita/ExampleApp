package com.example.users.presentation

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.base.BaseFragment
import com.example.common.utils.findComponentDependencies
import com.example.common.utils.findRouterDependencies
import com.example.users.R
import com.example.users.di.UsersComponent
import kotlinx.android.synthetic.main.fragment_users.*

class UsersFragment : BaseFragment<UsersViewModel>() {

    override fun inject() {
        UsersComponent.init(this, findComponentDependencies(), findRouterDependencies())
            .inject(this)
    }

    override fun layoutResource(): Int {
        return R.layout.fragment_users
    }

    override fun initViews() {
        toolbar.setTitle(getString(R.string.users_title))

        usersRv.layoutManager = LinearLayoutManager(context)
        usersRv.setHasFixedSize(true)
    }

    override fun subscribe(viewModel: UsersViewModel) {
        viewModel.usersLiveData.observe(this, Observer {
            if (usersRv.adapter == null) {
                usersRv.adapter = UsersAdapter { user -> viewModel.userClicked(user) }
            }
            (usersRv.adapter as UsersAdapter).submitList(it)
        })

        viewModel.getUsers()
    }
}