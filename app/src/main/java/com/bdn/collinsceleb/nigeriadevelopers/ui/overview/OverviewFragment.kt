package com.bdn.collinsceleb.nigeriadevelopers.ui.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
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

        // Add dividers between recyclerview's row items
        val decoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        binding.recycler.addItemDecoration(decoration)
        binding.lifecycleOwner = this
        return binding.root
    }

}