package com.jkp.stsapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public abstract class HttpSender {

    private static final String TAG = "HTTPSender";
    private static final String URL = "http://172.30.8.118:7070/";

    protected String apiName;
    protected RequestBody body;


    public abstract void setBodyContents(Object... Params);

    public void send() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {

                OkHttpClient client = new OkHttpClient.Builder()
                        .connectTimeout(10, TimeUnit.SECONDS)
//                        .writeTimeout(10, TimeUnit.SECONDS)
//                        .readTimeout(30, TimeUnit.SECONDS)
                        .build();
                //client.connectTimeoutMillis(10, TimeUnit.SECONDS);

               Request request = new Request.Builder().url(URL+apiName).post(body).build();

                try{
                    Response response = client.newCall(request).execute();
                    String result = response.body().string();
                    Log.e(TAG , "Result ==>" + result);
                }catch (IOException e){
                    Log.e(TAG, "doInBackground : error");
                }
                return null;
            }

        }.execute();
    }

}//HttpSender end
