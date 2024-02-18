package com.example.appbanhangnongsan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appbanhangnongsan.R;
import com.example.appbanhangnongsan.RegisterAndLogin.Login.FirebaseAccount;


public class LoginActivity extends AppCompatActivity {
    Button bt_login;
    TextView bt_signin;

    EditText edt_user, edt_pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseAccount firebaseAccount = new FirebaseAccount();

        anhxa();

        bt_login.setOnClickListener(view -> {
            String email = edt_user.getText().toString();
            String passWord = edt_pass.getText().toString();
            firebaseAccount.LoginWithEmailandPassword(email, passWord, LoginActivity.this);
       });

            bt_signin.setOnClickListener(view -> {
                Intent i = new Intent(LoginActivity.this, SignInActivity.class);
                startActivity(i);
            });
        }
        public void anhxa(){
            bt_login = (Button) findViewById(R.id.btnlogin);
            bt_signin = (TextView) findViewById(R.id.lnkRegister);
            edt_user = (EditText) findViewById(R.id.edtloginEmail);
            edt_pass = (EditText) findViewById(R.id.edtloginPwd);
        }
}

