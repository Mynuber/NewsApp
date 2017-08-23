package xyz.markswebsite.newsapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import xyz.markswebsite.newsapp.models.ArticlesResponse;
import xyz.markswebsite.newsapp.models.SourcesResponse;

/**
 * Created by Mark on 20/08/2017.
 */


/*
    https://newsapi.org/ for more information on the calls
 */

public interface NewsApi {

    /**
     * This endpoint gets a list of articles from a source
     * @param source REQUIRED: The UID for the news source
     * @param sortBy optional SortedOrder.printableName
     * @return an ArticlesResponse object which contains a list of articles as specified
     */
    @GET("articles")
    Call<ArticlesResponse> getArticles(@Query("source") String source, @Query("sortBy") String sortBy);

    /**
     * Get a list of sources that are available and their UID for use in the getArticles endpoint
     * @param category optional
     * @param language optional
     * @param country optional
     * @return a SourcesResponse object with a list of sources and some basic information about them
     */
    @GET("sources")
    Call<SourcesResponse> getAllSources(@Query("category") String category, @Query("language") String language, @Query("country") String country);



}
