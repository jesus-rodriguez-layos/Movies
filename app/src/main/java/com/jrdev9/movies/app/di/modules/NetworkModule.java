package com.jrdev9.movies.app.di.modules;


import com.google.gson.Gson;
import com.jrdev9.movies.BuildConfig;
import com.jrdev9.movies.app.data.api.ApiEndPoint;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(final HttpLoggingInterceptor loggingInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(loggingInterceptor);
        }
        return builder.build();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        logging.setLevel(level);
        return logging;
    }

    @Provides
    @Singleton
    @Named("EndPoint")
    String provideEndPoint() {
        return ApiEndPoint.BASE_URL.concat(ApiEndPoint.VERSION);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson,
                             OkHttpClient okHttpClient,
                             @Named("EndPoint") String endPoint) {

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(endPoint)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    ApiEndPoint provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiEndPoint.class);
    }
}
