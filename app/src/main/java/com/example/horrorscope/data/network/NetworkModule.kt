package com.example.horrorscope.data.network

import com.example.horrorscope.BuildConfig.BASE_URL
import com.example.horrorscope.data.network.core.interceptors.AuthInterceptor
import com.example.horrorscope.domain.model.repositories.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(HttpLoggingInterceptor()
                             .setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit): HorosocopeAPIService {
        return retrofit.create(HorosocopeAPIService::class.java)
    }


    @Provides
    fun provideRepository(apiService: HorosocopeAPIService): Repository =
        RepositoryImpl(apiService)
}