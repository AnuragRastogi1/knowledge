package com.example.loginui;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText editTextEmail;
    String strEmailAddress;
    RelativeLayout rellay;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay.setVisibility(View.VISIBLE);

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextEmail = findViewById(R.id.editTextEmail);


        rellay = (RelativeLayout) findViewById(R.id.rellay);

        handler.postDelayed(runnable,2000);
    }


    String regEx = "(\\W|^)[\\w.+\\-]*@nineleaps\\.com(\\W|$)";




    public void btnValidateEmailAddress(View v)
    {
        strEmailAddress = editTextEmail.getText().toString().trim();

        Matcher matcherObj = Pattern.compile(regEx).matcher(strEmailAddress);

        if (matcherObj.matches()) {
            Toast.makeText(v.getContext(), strEmailAddress+" is valid", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(v.getContext(), strEmailAddress+" is InValid", Toast.LENGTH_SHORT).show();
        }
    }

}
