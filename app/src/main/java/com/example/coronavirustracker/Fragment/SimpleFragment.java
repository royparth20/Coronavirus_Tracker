package com.example.coronavirustracker.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coronavirustracker.R;
import com.google.android.material.card.MaterialCardView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SimpleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SimpleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static String TAG = "Fragment.SimpleFragment";
    // TODO: Rename and change types of parameters
    private int mParam1;
    private String mParam2;
    private MaterialCardView materialCardView;

    public SimpleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SimpleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SimpleFragment newInstance(int param1, String param2) {
        SimpleFragment fragment = new SimpleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple, container, false);
        // Inflate the layout for this fragment
        Log.e(TAG, "onCreateView: " + mParam1);
        switch (mParam1) {
            case 1:
                materialCardView = view.findViewById(R.id.card_item1);
                materialCardView.setVisibility(View.VISIBLE);
                break;
            case 2:
                materialCardView = view.findViewById(R.id.card_item2);
                materialCardView.setVisibility(View.VISIBLE);
                break;
            case 3:
                materialCardView = view.findViewById(R.id.card_item3);
                materialCardView.setVisibility(View.VISIBLE);
                break;
        }
        return view;
    }
}
