package com.example.coronavirustracker.Modal;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronavirustracker.R;
import com.google.android.material.textview.MaterialTextView;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    private int mCurrentPosition;
    public MaterialTextView country_textView, t1_textView, t2_textView;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        country_textView = (itemView).findViewById(R.id.country_textView);
        t1_textView = (itemView).findViewById(R.id.t1_textView);
        t2_textView = (itemView).findViewById(R.id.t2_textView);
    }

    public void onBind(int position) {
        mCurrentPosition = position;
    }

    public int getCurrentPosition() {
        return mCurrentPosition;
    }

    protected abstract void clear();
}
