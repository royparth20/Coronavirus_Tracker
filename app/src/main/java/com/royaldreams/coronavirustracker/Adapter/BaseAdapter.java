package com.royaldreams.coronavirustracker.Adapter;

import android.content.Context;
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
        Data movie = datatList.get(position);
        holder.country_textView.setText(movie.getCountry());
        holder.t1_textView.setText(movie.getConfirmedcases());
        holder.t2_textView.setText(movie.getReporteddeaths());
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
