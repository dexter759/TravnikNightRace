package com.example.incubator3.travniknightrace.controllers;

import android.util.Log;

import com.example.incubator3.travniknightrace.entities.User;
import com.example.incubator3.travniknightrace.entities.UserExtra;
import com.example.incubator3.travniknightrace.interfaces.TokenCallBack;
import com.example.incubator3.travniknightrace.interfaces.UserCallBack;
import com.example.incubator3.travniknightrace.interfaces.UserExtraCallBack;
import com.example.incubator3.travniknightrace.login.ResponseAuthentication;
import com.example.incubator3.travniknightrace.login.TokenCredentials;
import com.example.incubator3.travniknightrace.login.UserCredentials;
import com.example.incubator3.travniknightrace.login.UserRegister;
import com.example.incubator3.travniknightrace.services.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserController {

    private UserService service;
    public Retrofit retrofit;
    private TokenCredentials token;


    public UserController() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://travnik-night-race.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        token = new TokenCredentials();

    }

    public void authenticateUser(String username, String password, final TokenCallBack callBack ) {
        service = retrofit.create(UserService.class);
        UserCredentials credentials = new UserCredentials();
        credentials.setUsername(username);
        credentials.setPassword(password);


        final Call<ResponseAuthentication> userCredentials = service.authenticate(credentials);

        try {
            userCredentials.enqueue(new Callback<ResponseAuthentication>() {
                @Override
                public void onResponse(Call<ResponseAuthentication> call, Response<ResponseAuthentication> response) {
                    if (response.isSuccessful()) {
                        Log.d("EA", "Sucess: " + response.body().toString());

                        String responseHeaders = response.headers().get("Authorization");
                        token.setTokenId(responseHeaders);
                        callBack.onSuccess(token);
//                        getUser(token.getTokenId());


                    }
                    else {
                        Log.d("EA", "Fail: ");
                        callBack.onError();
                    }

                }

                @Override
                public void onFailure(Call<ResponseAuthentication> call, Throwable t) {
                    callBack.onError();
                    Log.e("EA", "FAIL: " + t.toString());
                }
            });
        } catch (Exception e) {
            Log.e("EA", "Exception:" + e.toString());
        }
    }

    public void registerUser(String username, String password,String email) {
        service = retrofit.create(UserService.class);
        UserRegister userRegister = new UserRegister();
        userRegister.setUsername(username);
        userRegister.setEmail(email);
        userRegister.setPassword(password);

        Log.d("EA", "registerUser");
        Call<String> userCredentials = service.registerUser(userRegister);

        try {
            userCredentials.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        Log.d("EA", "Sucess");


                    }

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.e("EA", "FAIL: " + t.toString());
                }
            });
        } catch (Exception e) {
            Log.e("EA", "Exception:" + e.toString());
        }

    }



    public void getUser(final TokenCredentials token, final UserCallBack userCallBack) {
        service = retrofit.create(UserService.class);


        Call<User> userCredentials = service.getUser(token.getTokenId());

        try {
            userCredentials.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()) {
                        Log.d("EA", "Sucess: " + response.body().toString());

                        User user = response.body();

                        Log.d("EA",user.toString());
                        userCallBack.onSuccess(user,token);
                      //  getUserExtra(user.getId(),token);

                    }

                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.e("EA", "FAIL: " + t.toString());
                }
            });
        } catch (Exception e) {
            Log.e("EA", "Exception:" + e.toString());
        }

    }


    public void getUserExtra(String id, final TokenCredentials token, final UserExtraCallBack userExtraCallBack) {
        service = retrofit.create(UserService.class);

        Call<UserExtra> userCredentials = service.getUserExtra(id,token.getTokenId());

        try {
            userCredentials.enqueue(new Callback<UserExtra>() {
                @Override
                public void onResponse(Call<UserExtra> call, Response<UserExtra> response) {
                        if (response.isSuccessful()) {
                        Log.d("EA", "Sucess: " + response.body().toString());

                        UserExtra userExtra = response.body();
                        Log.d("EA",userExtra.toString());
                        userExtraCallBack.onSuccess(userExtra,token);

                      //  userExtra.setKontakOsobaZaHitnePozive("Damirovski");
                        // postUserExtra(userExtra,token);


                        //Posting user
//                        User userr = new User();
//                        userr.setId("1");
//
//                        UserExtra userExtraa = new UserExtra(userr.getId(),"Damir","Arnautovic","mama","+387603280123","1996-01-23T11:45:36.051Z","L","23:45","+387 61 328 0123",userr);
//                        postUserExtra(userExtraa,token);

                    }

                }

                @Override
                public void onFailure(Call<UserExtra> call, Throwable t) {
                    Log.e("EA", "FAIL: " + t.toString());
                }
            });
        } catch (Exception e) {
            Log.e("EA", "Exception:" + e.toString());
        }

    }

    public void postUserExtra(UserExtra userExtra, String token) {
        service = retrofit.create(UserService.class);
        String datum = "1996-01-23T13:07:28.180Z";
        userExtra.setDatumRodenja(datum);
        Call<UserExtra> userCredentials = service.postUserExtra(userExtra,token);

        try {
            userCredentials.enqueue(new Callback<UserExtra>() {
                @Override
                public void onResponse(Call<UserExtra> call, Response<UserExtra> response) {
                    if (response.isSuccessful()) {
                        Log.d("EA", "Sucess: " + response.body().toString());

                    }

                }

                @Override
                public void onFailure(Call<UserExtra> call, Throwable t) {
                    Log.e("EA", "FAIL: " + t.toString());
                }
            });
        } catch (Exception e) {
            Log.e("EA", "Exception:" + e.toString());
        }

    }

    public void putUserExtra(UserExtra userExtra, String token) {
        service = retrofit.create(UserService.class);

        Call<UserExtra> userCredentials = service.putUserExtra(userExtra,token);

        try {
            userCredentials.enqueue(new Callback<UserExtra>() {
                @Override
                public void onResponse(Call<UserExtra> call, Response<UserExtra> response) {
                    if (response.isSuccessful()) {
                        Log.d("EA", "Sucess: " + response.body().toString());

                    }

                }

                @Override
                public void onFailure(Call<UserExtra> call, Throwable t) {
                    Log.e("EA", "FAIL: " + t.toString());
                }
            });
        } catch (Exception e) {
            Log.e("EA", "Exception:" + e.toString());
        }

    }





}
