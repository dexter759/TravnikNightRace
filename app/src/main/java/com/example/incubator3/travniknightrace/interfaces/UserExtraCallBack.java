package com.example.incubator3.travniknightrace.interfaces;


import com.example.incubator3.travniknightrace.entities.UserExtra;
import com.example.incubator3.travniknightrace.login.TokenCredentials;

public interface UserExtraCallBack {
    void onSuccess(UserExtra value, TokenCredentials token);
    void onError();

}
