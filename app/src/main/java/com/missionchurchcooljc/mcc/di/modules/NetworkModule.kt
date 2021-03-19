/*
 * Copyright (c) 2021 Kevin Phillips, Mission Church of Our Lord Jesus Christ
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.missionchurchcooljc.mcc.di.modules

//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ApplicationComponent
import com.google.gson.Gson
import com.missionchurchcooljc.data_android.WebsiteHighlightDAO
import com.missionchurchcooljc.mcc.network.api.ChurchWebsiteRepository
import com.missionchurchcooljc.mcc.network.api.ChurchWebsiteService
import com.raywenderlich.kotlin.coroutines.contextProvider.CoroutineContextProviderImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

private const val BASE_URL_GW = "http://god.works"

//@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {


    val httpLoggingInterceptor: HttpLoggingInterceptor
        @Provides
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return httpLoggingInterceptor
        }

    @Provides
    fun provideHighlightsRepository(
        churchWebsiteService: ChurchWebsiteService,
//                                    coroutineContextProviderImpl: CoroutineContextProviderImpl,
        websiteHighlightDAO: WebsiteHighlightDAO
    ): ChurchWebsiteRepository {
        return ChurchWebsiteRepository(churchWebsiteService, websiteHighlightDAO)
//        return ChurchWebsiteRepository(churchWebsiteService, coroutineContextProviderImpl, websiteHighlightDAO)
    }

    @Provides
    fun provideCoroutineContextProviderImpl(context: CoroutineContext): CoroutineContextProviderImpl {
        return CoroutineContextProviderImpl(context)
    }


    @Provides
    fun provideHighlightsApiService(retrofit: Retrofit): ChurchWebsiteService {
        return retrofit.create(ChurchWebsiteService::class.java)
    }


    @Provides
    @Singleton
    fun providesRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL_GW)
            .addConverterFactory(gsonConverterFactory)
//            .addCallAdapterFactory(CoroutineCallAdapterFactory()) // for Deferred return type
            .client(okHttpClient)
            .build()
    }


    @Provides
    @Singleton
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            //  .cache(cache)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

//    private fun isNetworkConnected(): Boolean {
//        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager //1
//        val networkInfo = connectivityManager.activeNetworkInfo //2
//        return networkInfo != null && networkInfo.isConnected //3
//    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

}