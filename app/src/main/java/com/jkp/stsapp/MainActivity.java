package com.jkp.stsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpSender sender = new TestHttpSender();
        sender.setBodyContents("TEST SERVER I CAT IT !!");
        sender.send();

    }//onCreate end
}//MmainActivity end
