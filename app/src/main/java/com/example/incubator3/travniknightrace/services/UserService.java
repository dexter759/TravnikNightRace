package com.example.incubator3.travniknightrace.services;

import com.example.incubator3.travniknightrace.entities.User;
import com.example.incubator3.travniknightrace.entities.UserExtra;
import com.example.incubator3.travniknightrace.login.ResponseAuthentication;
import com.example.incubator3.travniknightrace.login.UserCredentials;
import com.example.incubator3.travniknightrace.login.UserRegister;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @Headers({"Accept:application/json",
            "Content-Type: application/json"})
    @POST("/api/authenticate")
    Call<ResponseAuthentication> authenticate(@Body UserCredentials userCredentials);

    @Headers({"Accept:application/json",
            "Content-Type: application/json"})
    @GET("/api/user-extras/{id}")
    Call<UserExtra> getUserExtra(@Path("id") String id, @Header("Authorization") String authorization);


    @Headers({"Accept:application/json",
            "Content-Type: application/json"})
    @POST("/api/user-extras/")
    Call<UserExtra> postUserExtra(@Body UserExtra userExtra, @Header("Authorization") String authorization);

    @Headers({"Accept:application/json",
            "Content-Type: application/json"})
    @GET("/api/account")
    Call<User> getUser(@Header("Authorization") String authorization);

    @Headers({"Accept:application/json",
            "Content-Type: application/json"})
    @POST("/api/register")
    Call<String> registerUser(@Body UserRegister userRegister);

    @Headers({"Accept:application/json",
            "Content-Type: application/json"})
    @PUT("/api/user-extras/")
    Call<UserExtra> putUserExtra(@Body UserExtra userExtra, @Header("Authorization") String authorization);

}
