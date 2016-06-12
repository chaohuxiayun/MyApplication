
package com.example.administrator.myapplication;


import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Query;

public interface GetGuPiaoInterface {
    @GET("/apistore/stockservice/hkstock")
    Call<GuPiao> getgupiao(@Header("apikey") String apikey, @Query("stockid") String stockid, @Query("list") String list);
}

