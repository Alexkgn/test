package com.alexkgn.listapp.data;

import com.alexkgn.listapp.data.pojo.GoogleResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Alex on 27.07.2017.
 */

public interface GoogleApi {

    //@GET("customsearch/v1?key=AIzaSyCHnYD7arc0kFLqf-MqlHWEH4JsssakXSs&cx=017576662512468239146:omuauf_lfve")
    @GET("customsearch/v1?key=AIzaSyBynXw3urXU42s0QkzKvCcXPZ9rczhRWeM&cx=000407756714463934297:m3yz6ipkk7e")
    Single<GoogleResponse> getPicture(@Query("q") String query);

}
