package com.twan.base.api;

import com.twan.base.entity.Bean;
import com.twan.base.entity.Good;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by twan on 2017/11/9.
 */

public interface ApiService {

    @GET("room/findAllRooms")
    Call<Result<List<Good>>> getRooms();

    @GET("xiandu/categories")
    Flowable<Bean> getBlogs();
}
