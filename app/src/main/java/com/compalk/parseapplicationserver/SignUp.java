package com.compalk.parseapplicationserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.compalk.parseapplicationserver.R;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private Button btnSave;
    private EditText edtName, edtPunchPower, edtPunchSpeed, edtKickPower;
    private TextView txtFromServer;
    private Button btnAllObjects;
    private String getStringFromtheServer;
    private Button btnTransition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(SignUp.this);
        edtPunchPower = findViewById(R.id.edtPunchPower);
        edtName = findViewById(R.id.edtName);
        edtPunchSpeed = findViewById(R.id.edtPunchSpeed);
        edtKickPower = findViewById(R.id.edtKickPower);
        txtFromServer = findViewById(R.id.txtFromServer);
        btnAllObjects = findViewById(R.id.btnAllObjects);
        btnTransition = findViewById(R.id.btnNextActivity);


        btnAllObjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseQuery<ParseObject> queryAll = ParseQuery.getQuery("KickBoxer");
                queryAll.whereGreaterThanOrEqualTo("punch_speed", 100);
                queryAll.setLimit(1);
                queryAll.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        getStringFromtheServer = "";
                        if (e == null) {
                            if (objects.size() > 0) {

                                for (ParseObject kickBoxer : objects) {
                                    getStringFromtheServer = getStringFromtheServer + kickBoxer.get("punch_speed") + "\n";

                                }


                                Toast.makeText(SignUp.this, getStringFromtheServer, Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(SignUp.this, e.getMessage() + "", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });


            }
        });


        txtFromServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("KickBoxer");
                parseQuery.getInBackground("a29PCf1A92", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {

                        if (object != null && e == null) {
                            txtFromServer.setText(object.get("kick_speed") + "");
                        }


                    }
                });


            }
        });

        btnTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SignUp.this,
                        SignUpLoginActivity.class);
                startActivity(intent);

            }
        });


    }



    @Override
    public void onClick(View view) {

        final ParseObject kickBoxer = new ParseObject("kickBoxer");
        kickBoxer.put("name ", edtName.getText().toString());
        kickBoxer.put("punch_power ", edtPunchPower.getText().toString());
        kickBoxer.put("punch_speed ", edtPunchSpeed.getText().toString());
        kickBoxer.put("kick_power ", edtKickPower.getText().toString());
        kickBoxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(SignUp.this, kickBoxer.get("punch_power") + " is Saved to server ", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}

