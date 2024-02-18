package com.example.appbanhangnongsan.RegisterAndLogin.Login;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.appbanhangnongsan.Activity.trangchu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseAccount {
    public void LoginWithEmailandPassword(String email, String passWord, Activity activity){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email,passWord).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(activity, "Login is Successfully", Toast.LENGTH_SHORT).show();
                if(FirebaseAuth.getInstance().getCurrentUser().isEmailVerified()==false){
                    Toast.makeText(activity, "Please confirm your Email!", Toast.LENGTH_SHORT).show();
                }else{
                    //
                }
            }else{
                Toast.makeText(activity, "Failed to Login", Toast.LENGTH_SHORT).show();}
        });
    }

    public void CreateAccountwithEmailandPassword(String email, String passWord, Activity activity){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email,passWord).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
               firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(task1 -> {
                   Toast.makeText(activity, "Welcome to !", Toast.LENGTH_SHORT).show();
               });
            }else{
                Toast.makeText(activity, "Register failed!", Toast.LENGTH_SHORT).show();}
        });
    }
}
