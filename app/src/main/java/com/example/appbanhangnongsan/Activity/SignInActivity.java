package com.example.appbanhangnongsan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appbanhangnongsan.RegisterAndLogin.Login.FirebaseAccount;
import com.example.appbanhangnongsan.R;
import com.example.appbanhangnongsan.RegisterAndLogin.Login.FirebaseAccount;

public class SignInActivity extends AppCompatActivity {
    EditText edt_email_signin,edt_pass_signin,edt_name_signin;
    Button create_account_signin;

    TextView txt_login_resgiter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FirebaseAccount firebaseAccount = new FirebaseAccount();

        anhxa();

        create_account_signin.setOnClickListener(view -> {
            String user = edt_email_signin.getText().toString();
            String pass = edt_pass_signin.getText().toString();
            firebaseAccount.CreateAccountwithEmailandPassword(user,pass,SignInActivity.this);
        });

        txt_login_resgiter.setOnClickListener(view -> {
            Intent i = new Intent(SignInActivity.this,LoginActivity.class);
            startActivity(i);
        });
    }

    public void anhxa(){
        edt_pass_signin = (EditText) findViewById(R.id.edt_pass_register);
        edt_email_signin = (EditText) findViewById(R.id.edt_Email_resigter);
        edt_name_signin = (EditText) findViewById(R.id.edt_name_resigter);
        create_account_signin = (Button) findViewById(R.id.btndk);
        txt_login_resgiter = (TextView) findViewById(R.id.txt_Login_resgiter);

    }
}
