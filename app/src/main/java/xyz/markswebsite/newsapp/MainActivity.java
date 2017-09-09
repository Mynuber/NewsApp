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

        final TextView textView = (TextView) findViewById(R.id.temporaryid);

        startActivity(new Intent(this, OnboardingPager.class));

        /*
        // Define the interceptor, add authentication headers
        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder().addHeader("X-Api-Key", "39a7c950e9be4dcdbb0aa4d916a90906").build();
                return chain.proceed(newRequest);
            }
        };

        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        OkHttpClient client = builder.build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        NewsApi newsApi = retrofit.create(NewsApi.class);
//        Call<ArticlesResponse> call = newsApi.getArticles("the-next-web" , "");

//        call.enqueue(new Callback<ArticlesResponse>() {
//            @Override
//            public void onResponse(Call<ArticlesResponse> call, Response<ArticlesResponse> response) {
//                ArticlesResponse articleResponse = response.body();
//                textView.setText(articleResponse.getStatus());
//            }
//
//            @Override
//            public void onFailure(Call<ArticlesResponse> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "WTF", Toast.LENGTH_SHORT).show();
//            }
//        });

        Call<SourcesResponse> call = newsApi.getAllSources(null, null, null);

        call.enqueue(new Callback<SourcesResponse>() {
            @Override
            public void onResponse(Call<SourcesResponse> call, Response<SourcesResponse> response) {
                SourcesResponse sourcesResponse = response.body();
                textView.setText(sourcesResponse.getStatus());
            }

            @Override
            public void onFailure(Call<SourcesResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "WTF", Toast.LENGTH_SHORT).show();
            }
        });

        */


    }


}
