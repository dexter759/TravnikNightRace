package com.example.incubator3.travniknightrace.interfaces;

import com.example.incubator3.travniknightrace.entities.User;
import com.example.incubator3.travniknightrace.login.TokenCredentials;

public interface UserCallBack {
    void onSuccess(User value, TokenCredentials token);
    void onError();

}
