package com.compalk.parseapplicationserver;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("owxdeyZkZfPQxCmVzRHPT7IFuEOh367AF4E4wDD3")
                // if defined
                .clientKey("PB5hlxpQlmyXJ2s1Y1DZQ7OaIn0rBups7ersLnSu")
                .server("https://parseapi.back4app.com/")
                .build()
        );




    }
}
