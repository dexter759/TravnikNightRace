package com.example.incubator3.travniknightrace.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.incubator3.travniknightrace.PaymentDetails;
import com.example.incubator3.travniknightrace.R;
import com.example.incubator3.travniknightrace.config.Config;
import com.example.incubator3.travniknightrace.controllers.UserController;
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

import customfonts.MyTextView;

public class OnlineOfflineActivity extends AppCompatActivity {

    public static final int PAYPAL_REQUEST_CODE = 7171;

    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(Config.PAYPAL_CLIENT_ID);

    Button bt_paypall, bt_uplatnica;
    MyTextView mtv_uplata;

    String amount = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_offline);

        bt_paypall = findViewById(R.id.bt_paypal);
        bt_uplatnica = findViewById(R.id.bt_uplatnica);
        mtv_uplata = findViewById(R.id.mtv_uplata);

        bt_paypall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processPayment();
            }
        });

        //Start PayPal Service
        Intent intent = new Intent(this,PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        startService(intent);



    }

    private void processPayment() {
        amount = "6.65";
        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(String.valueOf(amount)),"USD","Uplati Utrku",PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
        startActivityForResult(intent, PAYPAL_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PAYPAL_REQUEST_CODE){
            if(resultCode == RESULT_OK){

                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if(confirmation != null){
                    try {

                        String token = getIntent().getStringExtra("token");
                        TokenCredentials tokenCredentials = new TokenCredentials();
                        tokenCredentials.setTokenId(token);
                        Log.d("PAYPAL",token);

                        final UserController userController = new UserController();
                        userController.getUser(tokenCredentials, new UserCallBack() {
                            @Override
                            public void onSuccess(User value, TokenCredentials token) {
                                Log.d("PAYPAL",value.toString());
                                userController.getUserExtra(value.getId(), token, new UserExtraCallBack() {
                                    @Override
                                    public void onSuccess(UserExtra value, TokenCredentials token) {
                                        Log.d("PAYPAL",value.toString());
                                        UserExtra userExtra;
                                        userExtra=value;
                                        userExtra.setPrijavljen(true);
                                        userController.putUserExtra(userExtra,token.toString());
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


                        String paymentDetails = confirmation.toJSONObject().toString(4);
                        startActivity(new Intent(this,PaymentDetails.class)
                                .putExtra("PaymentDetails",paymentDetails)
                                .putExtra("PaymentAmount",amount));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
            else if(resultCode == Activity.RESULT_CANCELED)
                Toast.makeText(this,"Cancle",Toast.LENGTH_LONG).show();
        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID){
            Toast.makeText(this,"Invalid ",Toast.LENGTH_LONG).show();
        }
    }
}
