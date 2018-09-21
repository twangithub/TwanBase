package com.twan.base.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twan.base.BuildConfig;
import com.twan.base.app.Constants;
import com.twan.base.util.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by twan on 2017/11/9.
 */

public class Api {
    public static final String BASE_URL = "https://gank.io/api/";

    private static Retrofit mRetrofit;

    private static Retrofit getRetrofit() {
        if (mRetrofit == null) {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            //打印日志,发布设为NONE


            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);//

            File cacheFile = new File(Constants.PATH_CACHE);
            Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
            Interceptor cacheInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    if (!SystemUtil.isNetworkConnected()) {
                        request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
                    }
                    Response response = chain.proceed(request);
                    if (SystemUtil.isNetworkConnected()) {
                        int maxAge = 0;
                        // 有网络时, 不缓存, 最大保存时长为0
                        response.newBuilder()
                                .header("Cache-Control", "public, max-age=" + maxAge)
                                .removeHeader("Pragma")
                                .build();
                    } else {
                        // 无网络时，设置超时为4周
                        int maxStale = 60 * 60 * 24 * 28;
                        response.newBuilder()
                                .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                                .removeHeader("Pragma")
                                .build();
                    }
                    return response;
                }
            };
            //        Interceptor apikey = new Interceptor() {
            //            @Override
            //            public Response intercept(Chain chain) throws IOException {
            //                Request request = chain.request();
            //                request = request.newBuilder()
            //                        .addHeader("apikey",Constants.KEY_API)
            //                        .build();
            //                return chain.proceed(request);
            //            }
            //        }
            //        设置统一的请求头部参数
            //        builder.addInterceptor(apikey);
            //设置缓存
            //builder.addNetworkInterceptor(cacheInterceptor);
            //builder.addInterceptor(cacheInterceptor);
            builder.addInterceptor(logging);
            builder.cache(cache);
            //设置超时
            builder.connectTimeout(10000, TimeUnit.MILLISECONDS);
            builder.readTimeout(10000, TimeUnit.MILLISECONDS);
            builder.writeTimeout(10000, TimeUnit.MILLISECONDS);
            //错误重连
            builder.retryOnConnectionFailure(true);


            mRetrofit = new Retrofit.Builder()
                    .client(builder.build())
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return mRetrofit;
    }

    private static ApiService mService;

    public static ApiService getApiService() {
        if (mService == null) {
            mService = getRetrofit().create(ApiService.class);
        }
        return mService;
    }
}
