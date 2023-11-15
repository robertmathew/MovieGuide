package com.robert.omdbapplication.ui.search

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.robert.omdbapplication.R
import com.robert.omdbapplication.data.model.SearchResponse
import com.robert.omdbapplication.ui.MainActivity
import com.robert.omdbapplication.ui.list.MovieListAdapter

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private lateinit var viewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        viewModel.movieListLiveData.observe(viewLifecycleOwner) {
            val bundle = bundleOf("DATA" to Gson().toJson(it))

            findNavController().navigate(R.id.action_searchFragment_to_movieListFragment, bundle)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.buttonSearch).setOnClickListener {

            val movieName = view.findViewById<TextInputEditText>(R.id.textInputEditTextMovieName).text.toString()

            viewModel.searchMovie(movieName)
        }



    }

}