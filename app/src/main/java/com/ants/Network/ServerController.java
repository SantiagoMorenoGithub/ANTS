package com.ants.Network;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import com.ants.Globals;
import com.ants.MainActivity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by col_s on 3/4/2017.
 */

public class ServerController {

    private static final String APIURL = "api.flipdapp.co";
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final String JSONDATA = "JsonData";

    private static String AuthHeader() {
        byte[] data = new byte[0];
        try {
            data = (Globals.username + ":" + Globals.password).getBytes("UTF-8");
        } catch (Exception ex) {
        }
        String base64Authorization = Base64.encodeToString(data, Base64.NO_WRAP);
        return "Basic " + base64Authorization.trim();
    }

    private static String VersionHeader() {
        return "Android-" + BuildConfig.VERSION_CODE;
    }

    private static boolean HandleCommonErrors(Response response, final Context context) {
        Handler mainHandler = new Handler(context.getMainLooper());
        Runnable myRunnable;

        if (response.code() == 401) { // Unauthorized
            myRunnable = new Runnable() {
                @Override
                public void run() {
                    Globals.name = "";
                    Globals.username = "";
                    Globals.password = "";
                    Globals.loggedIn = false;

                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("name", Globals.name);
                    editor.putString("username", Globals.username);
                    editor.putString("password", Globals.password);
                    editor.apply();

                    try {
                        Intent i = new Intent(context, MainActivity.class);
                        context.startActivity(i);
                    }
                    catch (Exception ex) {
                        // Do nothing if it crashes since that means the app was not open
                        // crashes because it does mot have the FLAG_ACTIVITY_NEW_TASK flag
                    }
                }
            };
            mainHandler.post(myRunnable);
            return true;
        } else if (response.code() == 406) { // Need a new version of the app
            myRunnable = new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, context.getString(R.string.updateFlipd), Toast.LENGTH_SHORT).show();
                }
            };
            mainHandler.post(myRunnable);
            return true;
        }
        return false;
    }

    private enum RequestTypes {GET, POST, DELETE, PUT}

    private static void MakeRequest(final Context context, HashMap<String, String> params, String url, finalResponseAction action, RequestTypes requestType, boolean isJson, boolean isUrlParams) {
        HttpUrl.Builder urlBuilder = new HttpUrl.Builder()
                .scheme("https")
                .host(APIURL)
                .addPathSegment("api");
        for (String path : url.split("/")) {
            urlBuilder.addPathSegment(path);
        }

        // Add url parameters for GET Requests when it is not json data
        if ((requestType == RequestTypes.GET || isUrlParams) && !isJson) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                urlBuilder.addEncodedQueryParameter(entry.getKey(), entry.getValue());
            }
        }

        Request.Builder request = new Request.Builder()
                .url(urlBuilder.build())
                .addHeader("Authorization", AuthHeader())
                .addHeader("User-Agent", VersionHeader());

        // Add parameters for POST, PUT, and DELETE Requests
        if (requestType != RequestTypes.GET) {
            RequestBody body;
            if (isJson) {
                if (params.containsKey(JSONDATA))
                    body = RequestBody.create(JSON, params.get(JSONDATA));
                else
                    body = RequestBody.create(JSON, "");
            } else {
                FormBody.Builder formBodyBuilder = new FormBody.Builder();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    formBodyBuilder.addEncoded(entry.getKey(), entry.getValue());
                }
                body = formBodyBuilder.build();
            }

            if (requestType == RequestTypes.POST)
                request.post(body);
            else if (requestType == RequestTypes.PUT)
                request.put(body);
            else if (requestType == RequestTypes.DELETE)
                request.delete(body);
        }

        // Handler to allow running on UI Thread
        final Handler mainHandler = new Handler(context.getMainLooper());

        // Make the request
        MyOkHttpClient.client().newCall(request.build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Error connecting to the server
                Runnable myRunnable = new Runnable() {
                    @Override
                    public void run() {
                        action.NetworkError(context);
                    }
                };
                mainHandler.post(myRunnable);
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                final String body = response.body().string();
                final int code = response.code();

                if (HandleCommonErrors(response, context))
                    return;

                if (!response.isSuccessful()) {
                    Runnable myRunnable = new Runnable() {
                        @Override
                        public void run() {
                            try {
                                action.Failure(code, body, context);
                            } catch (Exception ex) {
                                action.Failure(0, "", context);
                            }
                        }
                    };
                    mainHandler.post(myRunnable);
                    return;
                }

                Runnable myRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            action.Success(body, context);
                        } catch (Exception ex) {
                            action.Failure(0, "", context);
                        }
                    }
                };
                mainHandler.post(myRunnable);
            }
        });
    }

}
