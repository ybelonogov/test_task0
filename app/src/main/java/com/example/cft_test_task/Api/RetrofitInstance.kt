package com.example.cft_test_task.Api

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    //    private val retrofit by lazy {
//        Retrofit.Builder().baseUrl("https://lookup.binlist.net/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//
//    val api: ApiService by lazy {
//        retrofit.create(ApiService::class.java)
//    }
    fun getInstance(): Retrofit {
//                var mHttpLoggingInterceptor = HttpLoggingInterceptor()
//            .setLevel(HttpLoggingInterceptor.Level.BODY)
//        mHttpLoggingInterceptor.redactHeader("m")
//        val httpClient = Builder()
//
//        httpClient.addInterceptor(Interceptor { chain ->
//            val request: Request =
//                chain.request().newBuilder().addHeader("parameter", "value").build()
//            chain.proceed(request)
//        })
        class HeaderInterceptor : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response = chain.run {
                proceed(
                    request()
                        .newBuilder()
                        .addHeader("Accept-Version", "3")
                        .build()
                )
            }
        }

//        val client = OkHttpClient()
//        client.interceptors.add(Interceptor { chain -> // How to add extra headers?
//            chain.proceed(chain.request())
//        })
        var mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(HeaderInterceptor())
            .build()

//        val gson = GsonBuilder()
//            .setLenient()
//            .create()
//        TODO чекнуть урок на ютубе 6 где был респонс и посмотреть на вид интерсептора
//        TODO поискать примеры с болеее похожим апи
        var retrofit: Retrofit = retrofit2.Retrofit.Builder()
            .baseUrl("https://lookup.binlist.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()
        return retrofit
    }

}