package com.compalk.parseapplicationserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

public class WelcomeActivity extends AppCompatActivity {

    private Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView txtViewWelcome = findViewById(R.id.txtViewWelcome);
        btnLogout = findViewById(R.id.btnLogout);


        txtViewWelcome.setText("Welcome" + ParseUser.getCurrentUser().getUsername());

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logOut();
                finish();

            }
        });


    }
}
