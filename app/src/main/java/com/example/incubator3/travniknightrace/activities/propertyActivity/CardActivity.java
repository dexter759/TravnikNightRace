package com.example.incubator3.travniknightrace.activities.propertyActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.incubator3.travniknightrace.R;
import com.example.incubator3.travniknightrace.entities.Property;

import customfonts.MyTextView;

public class CardActivity extends AppCompatActivity {

    ImageView iv_image;
    ImageView iv_broj;
    ImageView iv_email;
    ImageView iv_lokacija;
    ImageView iv_share;
    TextView tv_name;
    TextView tv_besplatno;
    TextView tv_location;
    MyTextView myTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        iv_image = findViewById(R.id.iv_image);
        iv_broj = findViewById(R.id.iv_broj);
        iv_email = findViewById(R.id.iv_email);
        iv_lokacija = findViewById(R.id.iv_lokacija);
        iv_share = findViewById(R.id.iv_share);
        tv_name = findViewById(R.id.tv_name);
        tv_location = findViewById(R.id.tv_location);
        tv_besplatno = findViewById(R.id.tv_besplatno);
        myTextView = findViewById(R.id.mtv_text);


        final Property property = new Property(getIntent().getStringExtra("IME"),
                getIntent().getStringExtra("LOKACIJA"), getIntent().getStringExtra("TEXT"),
                getIntent().getStringExtra("BROJ"), getIntent().getStringExtra("EMAIL"),
                getIntent().getStringExtra("LONLAT"), getIntent().getStringExtra("BESPLATNO"),
                getIntent().getIntExtra("IMAGE", 0));


        iv_image.setImageResource(property.getImage());
        myTextView.setText(property.getText());
        tv_name.setText(property.getName());
        tv_location.setText(property.getLocation());
        tv_besplatno.setText(property.getBesplatno());

        iv_lokacija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("geo:" + property.getLonLat() + "?q=" +
                        property.getLonLat() + "(" + property.getName() + " " + property.getLocation() + ")");

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                startActivity(mapIntent);
            }
        });

        iv_broj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + property.getBroj()));
                startActivity(intent);
            }
        });

        iv_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"+property.getEmail()));
                startActivity(emailIntent);
            }
        });

        iv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, property.getText()+" Saznaj vise i skini Aplikaciju Travnicke nočne utrke");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }

}
