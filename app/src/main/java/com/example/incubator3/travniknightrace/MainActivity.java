package com.example.incubator3.travniknightrace;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.incubator3.travniknightrace.activities.adapters.AdapterMain;
import com.example.incubator3.travniknightrace.activities.adapters.listViewAdapter;
import com.example.incubator3.travniknightrace.activities.mapActivity.MapActivity;
import com.example.incubator3.travniknightrace.activities.propertyActivity.PropertyActivity;
import com.example.incubator3.travniknightrace.config.Config;
import com.example.incubator3.travniknightrace.controllers.UserController;
import com.example.incubator3.travniknightrace.entities.BeanClass;
import com.example.incubator3.travniknightrace.entities.Property;
import com.example.incubator3.travniknightrace.entities.User;
import com.example.incubator3.travniknightrace.entities.UserExtra;
import com.example.incubator3.travniknightrace.interfaces.UserCallBack;
import com.example.incubator3.travniknightrace.interfaces.UserExtraCallBack;
import com.example.incubator3.travniknightrace.login.TokenCredentials;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.iwgang.countdownview.CountdownView;

public class MainActivity extends AppCompatActivity {

    private ListView listview;

    int number = 1;


    private int image;
    private String title;
    private String description;
    private String price;


    public int[] IMAGE = {R.drawable.supermarket, R.drawable.shop, R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.shop};
    public String[] TITLE = {"Prijavi se", "Mapa", "Program",
            "Lista Rezultata", "Znamenitosti"};
    public String[] DESCRIPTION = {"", "", "", "", "", ""};


    private ArrayList<BeanClass> beanClassArrayList;
    private listViewAdapter listViewAdapter;

    //////
    CountdownView countdownView;
    String raceDay = "2018-09-01 12:00:00";
    SimpleDateFormat dateFormat;



    @Override
    protected void onDestroy() {
        startService(new Intent(this,PayPalService.class));
        super.onDestroy();
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);
        beanClassArrayList = new ArrayList<BeanClass>();


        for (int i = 0; i < TITLE.length; i++) {

            BeanClass beanClass = new BeanClass(IMAGE[i], TITLE[i], DESCRIPTION[i]);
            beanClassArrayList.add(beanClass);

        }
        listViewAdapter = new listViewAdapter(MainActivity.this, beanClassArrayList);
        listview.setAdapter(listViewAdapter);

        countdownView = findViewById(R.id.cv_countdownViewTest21);

        dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");

        try {
            Date raceDate = dateFormat.parse(raceDay);
            System.out.print(raceDate);

            Date currentDate = new Date();

            long diff =raceDate.getTime()-currentDate.getTime();
            countdownView.start(diff);
            System.out.print(diff);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        String token = getIntent().getStringExtra("token");
        TokenCredentials tokenCredentials = new TokenCredentials();
        tokenCredentials.setTokenId(token);
        Log.d("EA",token);

        final UserController userController = new UserController();
        userController.getUser(tokenCredentials, new UserCallBack() {
                @Override
                public void onSuccess(User value, TokenCredentials token) {
                    Log.d("EA",value.toString());
                    userController.getUserExtra(value.getId(), token, new UserExtraCallBack() {
                        @Override
                        public void onSuccess(UserExtra value, TokenCredentials token) {
                            Log.d("EA",value.toString());
                        }

                        @Override
                        public void onError() {

                        }
                    });
                }

            @Override
            public void onError() {

            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if (position==0){
                   Intent intent = new Intent(getApplicationContext(),UserExtraRegistrationActivity.class);
                   startActivity(intent);
               }else if (position==1){
                   Intent intent = new Intent(getApplicationContext(),MapActivity.class);
                   startActivity(intent);
               }else if (position==4){
                   Intent intent = new Intent(getApplicationContext(),PropertyActivity.class);
                   startActivity(intent);
               }
            }
        });

    }




}
