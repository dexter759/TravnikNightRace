package com.example.incubator3.travniknightrace;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.incubator3.travniknightrace.activities.OnlineOfflineActivity;
import com.example.incubator3.travniknightrace.controllers.UserController;
import com.example.incubator3.travniknightrace.entities.User;
import com.example.incubator3.travniknightrace.entities.UserExtra;
import com.example.incubator3.travniknightrace.interfaces.UserCallBack;
import com.example.incubator3.travniknightrace.login.TokenCredentials;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class UserExtraRegistrationActivity extends AppCompatActivity {


    EditText et_ime;
    EditText et_prezime;
    EditText et_osobaZaHitneSlucajeve;
    EditText et_brojZaHitneSlucajeve;
    EditText et_datumRodenja;
    EditText et_velicinaMajice;
    EditText et_brojTelefona;
    EditText et_vrijemeTrcanja;

    Button bt_signup;



    Calendar myCalendar =Calendar.getInstance();


    UserController userController = new UserController();



    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);



        et_datumRodenja.setText(sdf.format(myCalendar.getTime()));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_extra_registration);


        et_ime = findViewById(R.id.et_ime);
        et_prezime = findViewById(R.id.et_prezime);
        et_osobaZaHitneSlucajeve = findViewById(R.id.et_osobaZaHitneSlucajeve);
        et_brojZaHitneSlucajeve = findViewById(R.id.et_brojZaHitneSlucajeve);
        et_datumRodenja = findViewById(R.id.et_datumRodenja);
        et_velicinaMajice = findViewById(R.id.et_velicinaMajice);
        et_brojTelefona = findViewById(R.id.et_brojTelefona);
        et_vrijemeTrcanja = findViewById(R.id.et_vrijemeTrcanja);

        bt_signup = findViewById(R.id.btn_signUp);




     final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };


        et_datumRodenja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(UserExtraRegistrationActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token = getIntent().getStringExtra("TOKEN");
                TokenCredentials tokenCredentials = new TokenCredentials();
                tokenCredentials.setTokenId(token);
                userController.getUser(tokenCredentials, new UserCallBack() {
                    @Override
                    public void onSuccess(User value, TokenCredentials token) {
                        UserExtra userExtra = new UserExtra();
                        userExtra.setId(value.getId());
                        userExtra.setIme(et_ime.getText().toString());
                        userExtra.setPrezime(et_prezime.getText().toString());
                        userExtra.setOsobaZaHitnePozive(et_osobaZaHitneSlucajeve.getText().toString());
                        userExtra.setKontakOsobaZaHitnePozive(et_brojZaHitneSlucajeve.getText().toString());
                        userExtra.setDatumRodenja(et_datumRodenja.getText().toString());
                        userExtra.setVelicinaMajice(et_velicinaMajice.getText().toString());
                        userExtra.setBrojTelefona(et_brojTelefona.getText().toString());
                        userExtra.setLokacija(et_vrijemeTrcanja.getText().toString());
                        userExtra.setUser(value);


                        userController.postUserExtra(userExtra,token.getTokenId());

                        Intent intent = new Intent(getApplicationContext(), OnlineOfflineActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onError() {

                    }
                });




            }
        });
    }

}
