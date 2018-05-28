package com.example.incubator3.travniknightrace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity {

    TextView tv_id,tv_amount, tv_status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        tv_id = findViewById(R.id.tv_id);
        tv_amount = findViewById(R.id.tv_amount);
        tv_status = findViewById(R.id.tv_status);

        //Get Intent
        Intent intent = getIntent();

        try {

            JSONObject jsonObject = new JSONObject(intent.getStringExtra("PaymentDetails"));
            showDetails(jsonObject.getJSONObject("response"),intent.getStringExtra("PaymentAmount"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void showDetails(JSONObject response, String paymentAmount) {
        try {
            tv_id.setText(response.getString("id"));
            tv_status.setText(response.getString("state"));
            tv_amount.setText(response.getString(String.format("$%s",paymentAmount)));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
