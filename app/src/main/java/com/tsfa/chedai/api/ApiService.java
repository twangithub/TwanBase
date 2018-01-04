package com.tsfa.chedai.api;

import com.tsfa.chedai.entity.Room;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by twan on 2017/11/9.
 */

public interface ApiService {

    @GET("room/findAllRooms")
    Call<Result<List<Room>>> getRooms();
    //Observable<Result<String>> getBlogs(@Query("page") int page);
}
