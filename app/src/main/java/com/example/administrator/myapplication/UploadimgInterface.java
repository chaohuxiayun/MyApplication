package com.example.administrator.myapplication;



import com.squareup.okhttp.RequestBody;

import retrofit.Call;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;

/**
 * Created by Administrator on 2016/6/12.
 */
public interface UploadimgInterface {
  @Multipart
  @POST("/Test/fileUpload.do")
  Call<Message> uploadStudentInfo(@Part("_id") String _id, @Part("sname") String sname, @Part("sbirth") String sbirth, @Part("fileName") String fileName, @Part("file\"; filename=\"image.png\"") RequestBody imgs);

}
