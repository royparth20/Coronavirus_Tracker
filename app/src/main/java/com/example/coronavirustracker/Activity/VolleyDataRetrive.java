package com.example.coronavirustracker.Activity;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.BuildConfig;
import com.android.volley.NetworkError;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.coronavirustracker.Adapter.BaseAdapter;
import com.example.coronavirustracker.helper.Data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class VolleyDataRetrive {
    private Context ctx;
    private String url;
    private String TAG = "com.example.coronavirustracker.Activity.VollyDataRetriver";
    private Data data;
    public static List<com.example.coronavirustracker.Modal.Data> dataList = new ArrayList<>();
    private RequestQueue requestQueue;
    private BaseAdapter adapter;

    public void setAdapter(BaseAdapter adapter) {
        this.adapter = adapter;
    }

    public VolleyDataRetrive(Context ctx, String url) {
        this.ctx = ctx;
        this.url = url;
        Log.e(TAG, "VolleyDataRetrive: " + this.url);
        this.requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
    }

    public void getDataStringRequest() {
        dataList = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = gsonBuilder.create();
                    data = gson.fromJson(response, Data.class);
                    Log.e("size of array", String.valueOf(data.getFeed().getEntry().size()));

                    for (int i = 0; i < data.getFeed().getEntry().size(); i++) {
                        com.example.coronavirustracker.Modal.Data d = new com.example.coronavirustracker.Modal.Data();
                        d.setConfirmedcases(data.getFeed().getEntry().get(i).getGsx$confirmedcases().get$t());
                        d.setCountry(data.getFeed().getEntry().get(i).getGsx$country().get$t());
                        d.setReporteddeaths(data.getFeed().getEntry().get(i).getGsx$reporteddeaths().get$t());
                        if (data.getFeed().getEntry().get(i).getGsx$reporteddeaths().get$t().equals("")){
                            d.setReporteddeaths("0");
                        }
//                            Log.e("country name :", data.getFeed().getEntry().get(i).getGsx$country().get$t() + " " + data.getFeed().getEntry().get(i).getGsx$reporteddeaths().get$t());
//                        Log.e("confirmed cases :", data.getFeed().getEntry().get(i).getGsx$confirmedcases().get$t());
//                        Log.e("reported deaths :", data.getFeed().getEntry().get(i).getGsx$reporteddeaths().get$t());
//                        Log.e(TAG, "onResponse: " + dataList.size());
                        dataList.add(d);
                        adapter.addDataList(d);
                    }

                } catch (Exception e) {
                    if (BuildConfig.DEBUG)
                        e.printStackTrace();
                    Toast.makeText(ctx.getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message = null;
                if (error instanceof NetworkError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (error instanceof ServerError) {
                    message = "The server could not be found. Please try again after some time!!";
                } else if (error instanceof AuthFailureError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (error instanceof ParseError) {
                    message = "Parsing error! Please try again after some time!!";
                } else if (error instanceof TimeoutError) {
                    message = "Connection TimeOut! Please check your internet connection.";
                }
                Toast.makeText(ctx.getApplicationContext(), message + "no internet", Toast.LENGTH_LONG).show();

            }
        });

//        AppController.getInstance().addToRequestQueue(stringRequest, TAG, ctx);
        Log.e(TAG, "getDataStringRequest: " + dataList.size());
        this.requestQueue.add(stringRequest);
    }
}

