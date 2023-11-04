package com.example.newsportal;

import com.example.newsportal.Models.NewsHeadlines;

import java.util.List;

public interface OneFetchDataListener<NewsApiResponse> {
    void oneFetchData(List<NewsHeadlines> list, String message);
    void onError(String message);
}
