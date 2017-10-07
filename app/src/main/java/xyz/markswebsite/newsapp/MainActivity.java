package xyz.markswebsite.newsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.markswebsite.newsapp.api.NewsApi;
import xyz.markswebsite.newsapp.api.RetrofitConsumer;
import xyz.markswebsite.newsapp.models.Article;
import xyz.markswebsite.newsapp.models.ArticlesResponse;
import xyz.markswebsite.newsapp.models.SortedOrder;
import xyz.markswebsite.newsapp.models.Source;
import xyz.markswebsite.newsapp.models.SourcesResponse;
import xyz.markswebsite.newsapp.onboarding.OnboardingPager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, OnboardingPager.class));
//
//        NewsApi newsApi = RetrofitConsumer.getInstance().getNewsApi();
//        Call<SourcesResponse> call = newsApi.getAllSources(null, null, null);
//        call.enqueue(new Callback<SourcesResponse>() {
//            @Override
//            public void onResponse(Call<SourcesResponse> call, Response<SourcesResponse> response) {
//                SourcesResponse sourcesResponse = response.body();
//                for (Source s : sourcesResponse.getSources()){
//                    Log.d("123", "onResponse: " + s.getName());
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<SourcesResponse> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Failed to get sources", Toast.LENGTH_SHORT).show();
//            }
//        });

    }


}
