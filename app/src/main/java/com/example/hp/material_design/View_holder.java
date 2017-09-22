package com.example.hp.material_design;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
  * Creating a class and extends with  RecyclerView.Adapter<> .
  * RecyclerView.Adapter is Base class for an Adapter.
  * Adapters provide a binding from an app-specific data set to views that are displayed
     within a RecyclerView.
*/
public class View_holder extends RecyclerView.Adapter<View_holder.ViewHolder> {

    private String[] versions;

    /*
      RecyclerView.ViewHolder describes an item view and metadata about its place
        within the RecyclerView.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Data item is in the form of String
        public TextView textView; // Creating object

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.version_name); // Initializing object by ID.
        }
    }

    // Provide a suitable constructor
    public View_holder(String[] androidVersions) {
        versions = androidVersions;
    }


    @Override
    // Creating new views invoked by the layout manager
    public View_holder.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.version_textview, parent, false);

        ViewHolder viewHolder = new ViewHolder(v); // Creating object
        return viewHolder; // Return Statement
    }


    @Override
    /*
     onBindViewHolder () will update the RecyclerView.ViewHolder contents with the item at
     the given position and also sets up some private fields to be used by RecyclerView.
    */
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(versions[position]);

    }

    @Override
    public int getItemCount() {
        return versions.length; // Return the size of dataset
    }

}


