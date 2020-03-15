package com.royaldreams.coronavirustracker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.royaldreams.coronavirustracker.Activity.MapActivity;
import com.royaldreams.coronavirustracker.GeocodingLocation;

import com.royaldreams.coronavirustracker.Modal.BaseViewHolder;
import com.royaldreams.coronavirustracker.Modal.Data;
import com.royaldreams.coronavirustracker.R;
import java.util.List;

public class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final String TAG = "BaseAdapter";
    private List<Data> datatList;
    private Context ctx;

    public BaseAdapter(Context context, List<Data> datatList) {
        this.datatList = datatList;
        this.ctx = context;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_mainlayout, parent, false);
        return new BaseViewHolder(itemView) {
            @Override
            protected void clear() {
            }
        };
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder: " + "true");
        final Data movie = datatList.get(position);
        holder.country_textView.setText(movie.getCountry());
        holder.t1_textView.setText(movie.getConfirmedcases());
        holder.t2_textView.setText(movie.getReporteddeaths());
        holder.map_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GeocodingLocation locationAddress = new GeocodingLocation();
                String latlng = locationAddress.getAddressFromLocation("United States",ctx);
                Intent intent = new Intent(ctx,MapActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("latitude",latlng.split("\n")[0]);
                bundle.putString("longitude",latlng.split("\n")[1]);
                bundle.putString("country",movie.getCountry());
                bundle.putString("case",movie.getConfirmedcases());
                bundle.putString("death",movie.getReporteddeaths());
                intent.putExtras(bundle);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datatList.size();
    }

    public void updateList(List<Data> list) {
        datatList = list;
        notifyDataSetChanged();
    }

    public void addDataList(Data d) {
        datatList.add(d);
        notifyDataSetChanged();
    }
}
