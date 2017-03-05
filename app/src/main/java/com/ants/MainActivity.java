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
import com.ants.Network.ServerModels;
import com.ants.User.Patient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        Button registerButton = (Button) findViewById(R.id.btnLinkToRegisterScreen);
        Button loginButton = (Button) findViewById(R.id.btnLogin);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SignUpPage.class);
                startActivity(i);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText getUsername = (EditText)findViewById(R.id.email);
                EditText getPassword = (EditText)findViewById(R.id.password);

                login(getUsername.getText().toString(),getPassword.getText().toString());
            }
        });
    }

    private void login(final String username, final String password) {

        ResponseAction loginAction = new ResponseAction() {
            @Override
            public void Success(final String data, Context context) {
                //TODO
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
                Type userType = new TypeToken<ServerModels.GetUserResult>() {}.getType();
                ServerModels.GetUserResult user = gson.fromJson(data, userType);

                Globals.firstName = user.first_name;
                Globals.lastName = user.last_name;
                Globals.userType = user.user_type;
                Globals.loggedIn = true;
                Globals.username = username;
                Globals.password = password;

                if (user.user_type.equals("patient")) {
                    Intent intentDementia = new Intent(getBaseContext(), DementiaPage.class);
                    startActivity(intentDementia);
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

