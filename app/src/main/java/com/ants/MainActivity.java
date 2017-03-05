package com.ants;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ants.Network.ResponseAction;
import com.ants.Network.ServerController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();


    }

    private void login(String username, String password) {

        ResponseAction loginAction = new ResponseAction() {
            @Override
            public void Success(final String data, Context context) {
            }
        };
        ServerController.loginUser(this, loginAction, username, password);
        Intent intentDementia = new Intent(this, DementiaPage.class);
        //Intent intentCaregiver = new Intent(this, CareGiver.class);
    }

    public void register (View view) {
        Intent intent = new Intent(this, SignUpPage.class);
        startActivity(intent);
    }
}
