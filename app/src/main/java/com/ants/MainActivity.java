package com.ants;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ants.Network.ResponseAction;
import com.ants.Network.ServerController;
import com.ants.User.Patient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        Button registerButton = (Button) findViewById(R.id.btnLinkToRegisterScreen);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SignUpPage.class);
                startActivity(i);
            }
        });
        Button loginButton = (Button) findViewById(R.id.btnLogin);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText getUsername = (EditText)findViewById(R.id.email);
                EditText getPassword = (EditText)findViewById(R.id.password);

                login(getUsername.getText().toString(),getPassword.getText().toString());
            }
        });
    }

    private void login(String username, String password) {

        ResponseAction loginAction = new ResponseAction() {
            @Override
            public void Success(final String data, Context context) {
                //TODO
                String userType = ;
                if (userType.equals("Patient")) {
                    Intent intentDementia = new Intent(getBaseContext(), DementiaPage.class);
                }
                else{
                        //Intent intentDementia = new Intent(getBaseContext(), CareGiver.class);
                    }


                }
            }
            ;
            ServerController.loginUser(this,loginAction,username,password);
    }
}

