package com.example.jetpackcomposestarting.data.di

import com.example.jetpackcomposestarting.data.retrofit.network.ApiSerivice
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Singleton
    @Provides
    fun providesApiService(moshi: Moshi): ApiSerivice = Retrofit.Builder().run {
        baseUrl(ApiSerivice.BASE_URL).addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }.create(ApiSerivice::class.java)
}