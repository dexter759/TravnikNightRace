package com.example.incubator3.travniknightrace.activities;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import com.example.incubator3.travniknightrace.MainActivity;
        import com.example.incubator3.travniknightrace.R;
        import com.example.incubator3.travniknightrace.controllers.UserController;
        import com.example.incubator3.travniknightrace.interfaces.TokenCallBack;
        import com.example.incubator3.travniknightrace.login.TokenCredentials;

public class LoginActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    Button bt_learn;
    Button bt_register;
    Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_password = findViewById(R.id.et_password);
        et_username = findViewById(R.id.et_username);

        bt_learn = findViewById(R.id.bt_learn);
        bt_register = findViewById(R.id.bt_register);
        bt_login = findViewById(R.id.bt_login);





    }

    public void learnMore(View view) {
        Intent intent = new Intent(getApplicationContext(), WebActivity.class);
        startActivity(intent);
    }

    public void login(View view) {
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();

        UserController userController = new UserController();
        userController.authenticateUser(username, password, new TokenCallBack() {
            @Override
            public void onSuccess(TokenCredentials value) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("token",value.getTokenId());
                startActivity(intent);

            }

            @Override
            public void onError() {
                Log.d("EA", "Failed ");

            }
        });

    }

    public void register(View view) {

        Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(intent);

    }
}
