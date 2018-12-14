package com.compalk.parseapplicationserver;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpLoginActivity extends AppCompatActivity {

    private EditText edtSignUpUsername, edtSignUpPassword;
    private EditText edtLoginUsername, edtLoginPassword;
    private Button btnSignUp;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup_login_activity);
        // Edit text for Login and Sign up.
        edtSignUpPassword = findViewById(R.id.edtSignUpPassword);
        edtSignUpUsername = findViewById(R.id.edtSignUpUsername);
        edtLoginPassword = findViewById(R.id.edtLoginPassword);
        edtLoginUsername = findViewById(R.id.edtLoginUsername);

        // Button initializing for Login  and Sign up.
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);

        // Button for Login and Sign up.
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ParseUser.logInInBackground(edtLoginUsername.getText().toString(), edtLoginPassword.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null && e == null) {
                            Toast.makeText(SignUpLoginActivity.this, " Login Successfully", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SignUpLoginActivity.this, WelcomeActivity.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(SignUpLoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ParseUser parseUser = new ParseUser();
                parseUser.setUsername(edtSignUpUsername.getText().toString());
                parseUser.setPassword(edtSignUpPassword.getText().toString());

                parseUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(SignUpLoginActivity.this, parseUser.getUsername() + " signed up successfully ", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SignUpLoginActivity.this, WelcomeActivity.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(SignUpLoginActivity.this, e.getMessage() + "", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });


    }


}
