package com.navi.assignment.app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.navi.assignment.app.R
import com.navi.assignment.app.di.Injector
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.navi.assignment.app.common.ViewModelProviderFactory
import com.navi.assignment.app.databinding.FragmentBaseBinding
import javax.inject.Inject

class BaseFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private lateinit var binding: FragmentBaseBinding
    private lateinit var viewModel: BaseViewModel
    private var gitHubAdapter: GithubListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Injector.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_base, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(BaseViewModel::class.java)
        setObservers()
        setAdapters()
        viewModel.getPullRequestList()
    }

    private fun setObservers() {
        viewModel.list.observe(viewLifecycleOwner, {
            gitHubAdapter?.updateList(it)
        })
    }

    private fun setAdapters() {
        gitHubAdapter = GithubListAdapter()
        binding.recyclerView.apply {
            adapter = gitHubAdapter
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        }
    }
}