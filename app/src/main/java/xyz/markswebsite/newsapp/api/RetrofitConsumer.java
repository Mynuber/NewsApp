package xyz.markswebsite.newsapp.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mark on 12/09/2017.
 */

public class RetrofitConsumer {

    private static RetrofitConsumer instance = null;

    private NewsApi newsApi;

    public RetrofitConsumer() {
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


        newsApi = retrofit.create(NewsApi.class);
    }

    public static RetrofitConsumer getInstance() {
        if (instance == null) {
            instance = new RetrofitConsumer();
        }
        return instance;
    }

    public NewsApi getNewsApi() {
        return newsApi;
    }


    /*


//        Call<ArticlesResponse> call = newsApi.getArticles("the-next-web" , "");
//
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
