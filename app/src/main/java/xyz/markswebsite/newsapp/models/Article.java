package xyz.markswebsite.newsapp.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

/**
 * Created by Mark on 19/08/2017.
 */


public class Article {

    public static String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

    String author;
    String title;
    String description;
    String url;
    String urlToImage;
    Date publishedAt;


    public static Article parseJSON(String response) {
        Gson gson = new GsonBuilder().setDateFormat(ISO_FORMAT).create();
        Article article = gson.fromJson(response, Article.class);
        return article;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }
}
