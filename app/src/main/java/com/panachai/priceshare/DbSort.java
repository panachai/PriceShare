package com.panachai.priceshare;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Map;


/**
 * Created by KILLERCON on 3/20/2017.
 */

public class DbSort extends AsyncTask<String, Void, String> {


    private Context context;
    private AlertDialog alertDialog;
    private Gson gson = new Gson();

    private final OkHttpClient okHttpClient = new OkHttpClient();


    public DbSort(Context ctx) {
        context = ctx;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");

    }

    @Override
    protected String doInBackground(String... params) {

        postHttp http = new postHttp();
        RequestBody formBody = new FormEncodingBuilder()
                .add("sName", "Weerachai")
                .add("sLastName", "Nukitram")
                .build();

        String response = null;
        try {
            response = http.run("http://10.0.2.2/Webservice/postString.php",formBody);
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

        return response;
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

    public class postHttp {
        String run(String url, RequestBody body) throws IOException {
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();

            Response response = okHttpClient.newCall(request).execute();

            return response.body().string();
        }
    }
}


