package xyz.markswebsite.newsapp.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mark on 20/08/2017.
 */

public class Source {
    String id;
    String name;
    String description;
    String url;
    String category;
    String language;
    String country;
    Set<SortedOrder> sortsByAvailable;

    public Source() {
        sortsByAvailable = new HashSet<>();
    }

    public static Source parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        Source source = gson.fromJson(response, Source.class);
        return source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<SortedOrder> getSortsByAvailable() {
        return sortsByAvailable;
    }

    public void setSortsByAvailable(Set<SortedOrder> sortsByAvailable) {
        this.sortsByAvailable = sortsByAvailable;
    }
}
