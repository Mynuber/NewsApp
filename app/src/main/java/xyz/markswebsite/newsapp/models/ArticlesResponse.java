package xyz.markswebsite.newsapp.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 19/08/2017.
 */

public class ArticlesResponse {

    String status;
    String source;
    SortedOrder sortBy;
    List<Article> articles;


    public ArticlesResponse() {
        articles = new ArrayList<>();
    }

    public static ArticlesResponse parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        ArticlesResponse articlesResponse = gson.fromJson(response, ArticlesResponse.class);
        return articlesResponse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public SortedOrder getSortBy() {
        return sortBy;
    }

    public void setSortBy(SortedOrder sortBy) {
        this.sortBy = sortBy;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
