package com.bdn.collinsceleb.nigeriadevelopers.ui.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bdn.collinsceleb.nigeriadevelopers.databinding.OverviewFragmentBinding

class OverviewFragment : Fragment() {


    private lateinit var viewModel: OverviewViewModel
    private lateinit var binding: OverviewFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OverviewFragmentBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(OverviewViewModel::class.java)
        binding.overviewViewModel = viewModel
        binding.recycler.adapter = OverviewAdapter()
        binding.lifecycleOwner = this
        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(OverviewViewModel::class.java)
//        // Use the ViewModel
//    }

}