package com.navi.assignment.app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.navi.assignment.app.R
import com.navi.assignment.app.di.Injector
import androidx.lifecycle.ViewModelProviders
import com.navi.assignment.app.common.ViewModelProviderFactory
import javax.inject.Inject

class BaseFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private lateinit var viewModel : BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Injector.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= ViewModelProviders.of(this, viewModelFactory).get(BaseViewModel::class.java)
        viewModel.getPullRequestList()
    }
}