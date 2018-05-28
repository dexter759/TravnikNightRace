package com.example.incubator3.travniknightrace.interfaces;


import com.example.incubator3.travniknightrace.login.TokenCredentials;

public interface TokenCallBack {
    void onSuccess(TokenCredentials value);
    void onError();
}
