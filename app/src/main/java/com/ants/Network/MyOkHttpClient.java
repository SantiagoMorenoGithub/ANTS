package com.ants.Network;

import okhttp3.OkHttpClient;

/**
 * Singleton for accessing an OkHttpClient
 * Created by andre on 6/5/2016.
 */
public class MyOkHttpClient {

    private static OkHttpClient client;

    private  MyOkHttpClient() {
        // Prevents creating an instance
    }

    public static OkHttpClient client() {
        if (client == null)
            client = new OkHttpClient();
        return client;
    }
}
