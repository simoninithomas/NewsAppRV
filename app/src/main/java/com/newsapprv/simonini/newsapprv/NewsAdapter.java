package com.newsapprv.simonini.newsapprv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter< NewsAdapter.NewsViewHolder> {

    List<News> mNews;


    // ViewHolders cache the references to the views that will be modified in the adapter.
    // We create a class called NewsViewHolder that extends Recycler.ViewHolder
    public class NewsViewHolder extends RecyclerView.ViewHolder {


        // Create a TextView variable called listItemNumberView
        TextView listItemNumberView = (TextView) itemView.findViewById(R.id.tv_title);


        // Create a constructor for NewsViewHolder that accepts a View called itemView as a parameter

        public NewsViewHolder(View itemView) {
            super(itemView);
            listItemNumberView = (TextView) itemView.findViewById(R.id.tv_title);
        }

    }

    /*
        ADAPTER
     */
// Specify how many views adapter hold
    private int mNumberItems;

    private Context context;

// Store a member variable for the titles


    // Populate that var in the constructor
    public NewsAdapter(Context context, int numberOfItems, ArrayList<News> news) {
        mNumberItems = numberOfItems;
        mNews = news;
        this.context = context;

    }

    // Override our 3 functions
    // onCreateViewHolder()
    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Log.v("onCreateViewHolder", "onCreateViewHolder is called !");
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.item;

        // Inflate our new item view using a LayoutInflater. It takes the ID of layout in xml.
        // Then --> inflates or converts this collection of view groups and views.
        LayoutInflater inflater = LayoutInflater.from(context);


        // Set to false, so that the inflated layout will not be
        // immediately attached to its parent viewgroup.
        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        NewsViewHolder viewHolder = new NewsViewHolder(view);

        return viewHolder;

    }


    //onBindViewHolder()
    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

        // Get the data model based on position

        News news = mNews.get(position);
        // Set item views based on your views and data model
        TextView textView = holder.listItemNumberView;
        textView.setText(news.getNewsTitle());

    }

    //getItemCount() : returns the mNumberItems var
    @Override
    public int getItemCount() {
        mNumberItems = mNews.size();
        return mNumberItems;
    }

}

