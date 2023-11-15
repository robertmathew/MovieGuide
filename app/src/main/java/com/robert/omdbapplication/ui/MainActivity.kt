package com.robert.omdbapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.robert.omdbapplication.R
import com.robert.omdbapplication.ui.detailview.DetailViewFragment
import com.robert.omdbapplication.ui.list.MovieListFragment
import com.robert.omdbapplication.ui.search.SearchFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, SearchFragment::class.java, null).commit()
    }

    fun launchList(bundle: Bundle) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, MovieListFragment::class.java, bundle).commit()
    }

    fun launchDetailView(bundle: Bundle) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, DetailViewFragment::class.java, bundle).commit()
    }
}