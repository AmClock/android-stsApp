package com.jkp.stsapp;

import okhttp3.FormBody;

public class TestHttpSender extends HttpSender {

    public TestHttpSender(){
        apiName = "test";
    }

    @Override
    public void setBodyContents(Object... Params) {
        body = new FormBody.Builder().add("name",(String)Params[0]).build();
    }

}//TestHttpSender end
