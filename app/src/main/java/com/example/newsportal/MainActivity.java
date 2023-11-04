package com.example.newsportal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsportal.Models.NewsApiResponse;
import com.example.newsportal.Models.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RequestManager manager= new RequestManager(this);
        manager.getNewsHeadlines(listener, "general", null);

    }
    private final OneFetchDataListener<NewsApiResponse> listener= new OneFetchDataListener<NewsApiResponse>() {
        @Override
        public void oneFetchData(List<NewsHeadlines> list, String message) {
         showNews(list);
        }

        @Override
        public void onError(String message) {

        }
    };

    private void showNews(List<NewsHeadlines> list) {
    recyclerView = findViewById(R.id.recycler_main);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    adapter = new CustomAdapter(this , list);
    recyclerView.setAdapter(adapter);


    }
}