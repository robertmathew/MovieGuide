package com.robert.omdbapplication.ui.list

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.robert.omdbapplication.R
import com.robert.omdbapplication.data.model.SearchResponse


class MovieListAdapter(private val listener: AdapterClick, private val dataSet: List<SearchResponse.Search>) :
    RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.textView)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Log.d("TAG", "onBindViewHolder: ${dataSet[position].title}")
        viewHolder.textView.text = dataSet[position].title

        viewHolder.textView.setOnClickListener {
            listener.onListClick(dataSet[position].imdbID)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

interface AdapterClick {
    fun onListClick(imdbId: String)
}
