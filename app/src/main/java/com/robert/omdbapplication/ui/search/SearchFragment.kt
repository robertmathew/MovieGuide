package com.robert.omdbapplication.ui.search

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.robert.omdbapplication.R
import com.robert.omdbapplication.data.model.SearchResponse
import com.robert.omdbapplication.databinding.FragmentDetailViewBinding
import com.robert.omdbapplication.databinding.FragmentSearchBinding
import com.robert.omdbapplication.ui.MainActivity
import com.robert.omdbapplication.ui.list.MovieListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSearchBinding.bind(view)


        binding.buttonSearch.setOnClickListener {

            val movieName = view.findViewById<TextInputEditText>(R.id.textInputEditTextMovieName).text.toString()

            viewModel.getMovieDetail(movieName)
        }


        viewModel.movieListLiveData.observe(viewLifecycleOwner) {
            val bundle = bundleOf("DATA" to Gson().toJson(it))

            findNavController().navigate(R.id.action_searchFragment_to_movieListFragment, bundle)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}