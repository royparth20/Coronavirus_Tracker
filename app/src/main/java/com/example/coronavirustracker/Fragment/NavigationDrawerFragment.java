package com.example.coronavirustracker.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import com.example.coronavirustracker.Activity.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.coronavirustracker.R;
import com.google.android.material.navigation.NavigationView;


public class NavigationDrawerFragment extends BottomSheetDialogFragment {
    public static NavigationDrawerFragment newInstance() {
        Bundle args = new Bundle();
        NavigationDrawerFragment fragment = new NavigationDrawerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("ResourceAsColor")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer_list_dialog, container, false);
        NavigationView navigationView = view.findViewById(R.id.navigationView);
        navigationView.setBackgroundColor(android.R.attr.colorBackground);
//        navigationView.setAnimation();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.sypmtoms:
                        startActivity(new Intent(getActivity(), FragmentActivity.class).putExtra("case", 1));
                        return true;
                    case R.id.tracker:
                        startActivity(new Intent(getActivity(), FragmentActivity.class).putExtra("case", 0));
                        return true;
                    default:
                        return true;
                }
            }
        });
        return view;
    }

}
