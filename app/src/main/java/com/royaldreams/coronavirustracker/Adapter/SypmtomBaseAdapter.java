package com.royaldreams.coronavirustracker.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.royaldreams.coronavirustracker.Modal.SypmtomsData;
import com.royaldreams.coronavirustracker.R;
import com.google.android.material.textview.MaterialTextView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SypmtomBaseAdapter extends RecyclerView.Adapter<SypmtomBaseViewHolder> {

    private static final String TAG = "SypmtomBaseAdapter";
    private List<SypmtomsData> datatList;
    private Context ctx;

    public SypmtomBaseAdapter(Context context, List<SypmtomsData> datatList) {
        this.datatList = datatList;
        this.ctx = context;
    }

    @NonNull
    @Override
    public SypmtomBaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sypmtoms, parent, false);
        return new SypmtomBaseViewHolder(itemView) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull SypmtomBaseViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder: ");
        SypmtomsData movie = datatList.get(position);
        if (!movie.getImg_url().isEmpty())
            Picasso.with(ctx.getApplicationContext()).load(movie.getImg_url()).into(holder.appCompatImageView);
//        holder.appCompatImageView.setImageURI(Uri.parse(movie.getImg_url()));
        holder.t1_textView.setText(movie.getTitle());
//        holder.t2_textView.setText(movie.getReporteddeaths());
    }

    @Override
    public int getItemCount() {
        return datatList.size();
    }

    public void updateList(List<SypmtomsData> list) {
        datatList = list;
        notifyDataSetChanged();
    }

    public void addDataList(SypmtomsData d) {
        datatList.add(d);
        notifyDataSetChanged();
    }
}

class SypmtomBaseViewHolder extends RecyclerView.ViewHolder {
    public MaterialTextView t1_textView, t2_textView;
    AppCompatImageView appCompatImageView;

    public SypmtomBaseViewHolder(@NonNull View itemView) {
        super(itemView);
        appCompatImageView = (itemView).findViewById(R.id.img_item_sysmptoms);
        t1_textView = (itemView).findViewById(R.id.txt_item_sysptoms);
//        t2_textView = (itemView).findViewById(R.id.t2_textView);
    }
}

