package com.twopibd.location;


import com.google.gson.JsonElement;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mkl on 8/5/2019.
 */

public interface ApiInterface {


    @FormUrlEncoded
    @POST("postAddress")
    Call<StatusMessage> submitLocation(@Field("latitude") String latitude,
                                      @Field("longitude") String longitude
    );

}