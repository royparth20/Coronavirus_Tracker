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
import com.example.coronavirustracker.Adapter.SypmtomBaseAdapter;
import com.example.coronavirustracker.Modal.SypmtomsData;
import com.example.coronavirustracker.Modal.SypmtomsGetData;
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
    private SypmtomsGetData sData;
    public static List<com.example.coronavirustracker.Modal.Data> dataList = new ArrayList<>();
    private RequestQueue requestQueue;
    private BaseAdapter adapter;
    private SypmtomBaseAdapter sypmtomBaseAdapter;

    public void setBaseAdapter(BaseAdapter adapter) {
        this.adapter = (BaseAdapter) adapter;
    }

    public void setSypmtomBaseAdapter(SypmtomBaseAdapter adapter) {
        this.sypmtomBaseAdapter = (SypmtomBaseAdapter) adapter;
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
                        if (data.getFeed().getEntry().get(i).getGsx$reporteddeaths().get$t().equals("")) {
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

    public List<SypmtomsData> getSymptomsData() {
        final List<SypmtomsData> dataListSym = new ArrayList<>();
        Log.e(TAG, "getSymptomsData: ");
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = gsonBuilder.create();
                    Log.e(TAG, "onResponse: " + response);

                    sData = gson.fromJson(response, SypmtomsGetData.class);
                    Log.e("status", sData.getWarning());
                    Log.e(TAG, "onResponse: " + sData.getSymptomArray().size());
                    for (int i = 0; i < sData.getSymptomArray().size(); i++) {
                        SypmtomsData d = new SypmtomsData();
                        d.setDiscrpiption(sData.getSymptomArray().get(i).getDiscription());
                        d.setImg_url(sData.getSymptomArray().get(i).getImgUrl());
                        d.setTitle(sData.getSymptomArray().get(i).getTitle());
                        dataListSym.add(d);
                        sypmtomBaseAdapter.addDataList(d);
                    }

                } catch (Exception e) {
                    if (BuildConfig.DEBUG)
                        e.printStackTrace();
                    Toast.makeText(ctx.getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                    Log.e(TAG, "onResponse: " + e.getMessage());
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
                Log.e(TAG, "onErrorResponse: " + message);

            }
        });
        this.requestQueue.add(stringRequest);
        return dataListSym;
    }
}

