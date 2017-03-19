package com.panachai.priceshare;


import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BackgroundWorker extends AsyncTask<String, Void, String> { //ค่า parameter ที่ 3 คือค่า return

    Context context;
    AlertDialog alertDialog;

    BackgroundWorker(Context ctx) {
        context = ctx;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];

        /*
        final String _url = "https://api.github.com/markdown/raw";
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(_url).build();

            Response response = client.newCall(request).execute();
            Log.i("OKhttp", response.body().string());

            return "" + response.body().string();
        } catch (Exception e) {

        }
        */

        OkHttpClient okHttpClient = new OkHttpClient();

        Request.Builder builder = new Request.Builder();
        Request request = builder.url("http://date.jsontest.com/").build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                return "Not Success - code : " + response.code();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error - " + e.getMessage();
        }

    }


    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}
