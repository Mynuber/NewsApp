package xyz.markswebsite.newsapp.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 20/08/2017.
 */

public class SourcesResponse {

    String status;
    List<Source> sources;

    public SourcesResponse() {
        sources = new ArrayList<>();
    }

    public static SourcesResponse parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        SourcesResponse sourcesResponse = gson.fromJson(response, SourcesResponse.class);
        return sourcesResponse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}
