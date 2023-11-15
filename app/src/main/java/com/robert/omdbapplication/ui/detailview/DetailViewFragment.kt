package com.robert.omdbapplication.ui.detailview

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.robert.omdbapplication.R
import com.robert.omdbapplication.databinding.FragmentDetailViewBinding

class DetailViewFragment : Fragment() {

    companion object {
        fun newInstance() = DetailViewFragment()
    }

    private var _binding: FragmentDetailViewBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DetailViewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewViewModel::class.java)

        val imdbId = arguments?.getString("ID")

        imdbId?.let { viewModel.movieDetail(it) }

        viewModel.movieDetailLiveData.observe(viewLifecycleOwner) {

            Glide
                .with(requireContext())
                .load(it.poster)
                .into(binding.imageViewPoster)

            binding.textViewTitle.text = it.title
            binding.textViewPlot.text = it.plot
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}