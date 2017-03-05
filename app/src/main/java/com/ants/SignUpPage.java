package com.ants;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_sign_up_page);
        Button signButton = (Button) findViewById(R.id.btnLogin);

        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText emailText = (EditText) findViewById(R.id.enter_email_address);
                EditText passwordText = (EditText) findViewById(R.id.enter_password);
                EditText firstNameText = (EditText) findViewById(R.id.enter_first_name);
                EditText lastNameText = (EditText) findViewById(R.id.enter_last_name);
                EditText dateOfBirthText = (EditText) findViewById(R.id.enter_dob);
                EditText locationText = (EditText) findViewById(R.id.enter_loc);
                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();
                String firstName = firstNameText.getText().toString();
                String lastName = lastNameText.getText().toString();
                String dateOfBirth = dateOfBirthText.getText().toString();
                String location = locationText.getText().toString();
                //register();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
    }

}
