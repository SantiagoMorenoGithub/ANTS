package com.ants.Network;

import android.content.Context;
import android.widget.Toast;

import com.example.venkada.ants.R;

public abstract class ResponseAction {

    public abstract void Success(String message, Context context);

    public void Failure(int errorCode, String message, Context context) {
        DisplayStandardError(context);
    }

    public void NetworkError(Context context) {
        Failure(0, "", context);
    }

    public void DisplayStandardError(Context context) {
        Toast.makeText(context, R.string.networkError, Toast.LENGTH_SHORT).show();
    }
}
