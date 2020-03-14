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
import com.example.coronavirustracker.Modal.Data;
import com.example.coronavirustracker.R;

import java.util.ArrayList;
import java.util.List;

public class MainLayoutFragment extends Fragment {
    String TAG = "MainLayoutFragment";
    private List<Data> dataList;
    private BaseAdapter adapter;
    Activity activity;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_layout, container, false);
        // Inflate the layout for this fragment
        activity = getActivity();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_main_layout);
        {
            VolleyDataRetrive dataRetrive = new VolleyDataRetrive(activity.getApplication(), getResources().getString(R.string.url_link));
//            Log.e(TAG, "onCreate: " + VolleyDataRetrive.dataList.size());
            setDataList(VolleyDataRetrive.dataList);
            adapter = new BaseAdapter(activity.getApplicationContext(), dataList);

            dataRetrive.setAdapter(adapter);
            dataRetrive.getDataStringRequest();

            adapter.notifyDataSetChanged();
            {
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(activity.getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
            }
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    public void updateListData(List<Data> newdatatList) {
        ArrayList<Data> filterdNames = new ArrayList<>(newdatatList);
        Log.e(TAG, "updateListData: " + filterdNames.size());
        adapter.updateList(filterdNames);
    }
}
