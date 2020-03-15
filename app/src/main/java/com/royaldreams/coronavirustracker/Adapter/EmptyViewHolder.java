package com.royaldreams.coronavirustracker.Adapter;

import android.view.View;
import android.widget.TextView;

import com.royaldreams.coronavirustracker.Modal.BaseViewHolder;

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
