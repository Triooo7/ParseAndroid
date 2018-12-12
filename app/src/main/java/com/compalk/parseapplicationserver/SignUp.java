package com.compalk.parseapplicationserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.compalk.parseapplicationserver.R;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void helloWorldTapped(View view){

        ParseObject boxer = new ParseObject("Boxer");
        boxer.put("punch_speed",200);
        boxer.saveInBackground(new SaveCallback() {  // Doesn't freeze the operations for the activity in app
            @Override
            public void done(ParseException e) {

                if (e == null){
                    Toast.makeText(SignUp.this,"The boxer object is saved successfully",Toast.LENGTH_LONG).show();
                }
            }
        });




    }
}
