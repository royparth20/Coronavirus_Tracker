package com.example.coronavirustracker.Adapter;

import android.view.View;
import android.widget.TextView;

import com.example.coronavirustracker.Modal.BaseViewHolder;
import com.example.coronavirustracker.R;

class EmptyViewHolder extends BaseViewHolder {
//    @BindView(R.id.tv_message)
    TextView messageTextView;
//    @BindView(R.id.buttonRetry)
    TextView buttonRetry;
    EmptyViewHolder(View itemView) {
        super(itemView);
//        ButterKnife.bind(this, itemView);
//        buttonRetry.setOnClickListener(v -> mCallback.onEmptyViewRetryClick());
    }
    @Override
    protected void clear() {
    }

}
