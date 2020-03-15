package com.royaldreams.coronavirustracker.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.royaldreams.coronavirustracker.Activity.VolleyDataRetrive;
import com.royaldreams.coronavirustracker.Adapter.BaseAdapter;
import com.royaldreams.coronavirustracker.Modal.Data;
import com.royaldreams.coronavirustracker.R;

import java.util.ArrayList;
import java.util.List;

public class MainLayoutFragment extends Fragment {
    String TAG = "MainLayoutFragment";
    public static List<Data> dataList = new ArrayList<>();
    private BaseAdapter adapter;
    Activity activity;

    public static List<Data> getDataList() {
        return dataList;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_layout, container, false);
        // Inflate the layout for this fragment
        activity = getActivity();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_main_layout);
        TextInputEditText editText_Search = view.findViewById(R.id.editText_Search);
        {
            VolleyDataRetrive dataRetrive = new VolleyDataRetrive(activity.getApplication(), getResources().getString(R.string.url_link));
//            Log.e(TAG, "onCreate: " + VolleyDataRetrive.dataList.size());
            //setDataList(VolleyDataRetrive.dataList);
            adapter = new BaseAdapter(activity.getApplicationContext(), dataList);

            dataRetrive.setBaseAdapter(adapter);
            dataRetrive.getDataStringRequest();

            adapter.notifyDataSetChanged();
            {
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(activity.getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
            }
            recyclerView.setAdapter(adapter);
            editText_Search.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!s.toString().trim().isEmpty()) {

                        Log.e(TAG, "updateList: " + s + "\n" + dataList.size());
                        List<Data> list = new ArrayList<>();
                        for (Data d : dataList) {
                            if (d.getCountry().toLowerCase().contains(s.toString().toLowerCase())) {
                                list.add(d);
                            }
                        }
                        adapter.updateList((ArrayList) list);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public static void setDataList(List<Data> dataList) {
        dataList = dataList;
    }

    public void setDataListItem(Data d) {
        dataList.add(d);
    }


}
