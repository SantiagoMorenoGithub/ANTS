package com.ants;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ants.Network.ResponseAction;
import com.ants.Network.ServerController;
import com.ants.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button registerButton = (Button) findViewById(R.id.btnLinkToRegisterScreen);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SignUpPage.class);
                startActivity(i);
            }
        });
    }

    private void login(String username, String password) {

        ResponseAction loginAction = new ResponseAction() {
            @Override
            public void Success(final String data, Context context) {
            }
        };
        ServerController.loginUser(this, loginAction, username, password);
    }

}
