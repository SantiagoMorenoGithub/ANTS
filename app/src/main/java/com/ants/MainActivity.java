package com.ants;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ants.Network.ResponseAction;
import com.ants.Network.ServerController;
import com.ants.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void login(String username, String password) {

        ResponseAction loginAction = new ResponseAction() {
            @Override
            public void Success(final String data, Context context) {
            }
        };
        ServerController.loginUser(this, loginAction, username, password);
    }
    public void login(View view){

    }
}
