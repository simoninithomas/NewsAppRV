package com.newsapprv.simonini.newsapprv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public int NUM_ITEMS = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create fake News
        ArrayList<News> data = new ArrayList<>();

        data.add(new News("13 reasons why Rotterdam may be Europe's new capital of cool"));
        data.add(new News("Protests after Netherlands bars Turkish official's plane from landing"));
        data.add(new News("Abuja airport shutdown 'hugely embarrassing'"));
        data.add(new News("Somalia: 'People are dying of hunger'"));
        data.add(new News("Concern over yellow fever outbreak"));
        data.add(new News("Detained DREAMer files petition to go free"));
        data.add(new News("Mexico opens immigrant defense centers"));
        data.add(new News(" Canada: 'Point to prove' after funds cut"));
        data.add(new News("Mark Zuckerberg, Priscilla Chan expecting second baby girl"));
        data.add(new News("Tinder's Sean Rad: App has made 250,000 transgender matches"));
        data.add(new News("California officially embraces the self-driving car"));
        data.add(new News("Cory Booker: We need to love each other"));
        data.add(new News("H-4 visa holder: Working 'changed my life'"));
        data.add(new News("Testing earbuds that translate in real-time"));
        data.add(new News("Experts: 'Vault 7' leak describes common hacks"));
        data.add(new News("Musk offers to fix Australia's energy crisis in 100 days"));







        // Get a reference of our RecyclerView from xml
        // It allows us the do things like set the Adapter of the RecyclerView and toggle the
        // visibility
        RecyclerView mNewsList = (RecyclerView) findViewById(R.id.rv_news);

        // GridLayoutManager is responsible for measuring and positioning item views within a RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNewsList.setLayoutManager(layoutManager);

        // Don't change the size of the content
        mNewsList.setHasFixedSize(true);

        NewsAdapter adapter = new NewsAdapter(getApplicationContext(), NUM_ITEMS, data);

        mNewsList.setAdapter(adapter);

    }
}
