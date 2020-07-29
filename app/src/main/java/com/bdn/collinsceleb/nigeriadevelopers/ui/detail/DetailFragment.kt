package com.bdn.collinsceleb.nigeriadevelopers.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bdn.collinsceleb.nigeriadevelopers.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {


    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: DetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailFragmentBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.detailViewModel = viewModel
        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
//        // Use the ViewModel
//    }

}