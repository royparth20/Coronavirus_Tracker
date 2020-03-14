package com.example.coronavirustracker.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronavirustracker.Activity.VolleyDataRetrive;
import com.example.coronavirustracker.Adapter.BaseAdapter;
import com.example.coronavirustracker.Adapter.SypmtomBaseAdapter;
import com.example.coronavirustracker.Modal.SypmtomsData;
import com.example.coronavirustracker.R;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    private String TAG = "FirstFragment";
    private Activity activity;
    private List<SypmtomsData> dataList;
    private SypmtomBaseAdapter adapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        activity = getActivity();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_fragment_first);
        Log.e(TAG, "onCreate: " + getResources().getString(R.string.firebase_url) + "/getSymptons");

        VolleyDataRetrive dataRetrive = new VolleyDataRetrive(activity.getApplication(), getResources().getString(R.string.firebase_url) + "/getSymptons");
        dataList = new ArrayList<>();
        adapter = new SypmtomBaseAdapter(activity.getApplicationContext(), dataList);
        dataRetrive.setSypmtomBaseAdapter(adapter);
        dataList = dataRetrive.getSymptomsData();
        adapter.notifyDataSetChanged();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(activity.getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
