package com.example.coronavirustracker.Activity;

import android.app.FragmentManager;
import android.os.Bundle;

import com.example.coronavirustracker.Fragment.FirstFragment;
import com.example.coronavirustracker.Fragment.MainLayoutFragment;
import com.example.coronavirustracker.Fragment.SecondFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.coronavirustracker.R;

public class FragmentActivity extends AppCompatActivity {
    private int subscreensOnTheStack = 0;
    private FragmentManager fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.title_activity_fragment);
        int cases = getIntent().getIntExtra("case", 0);
        switch (cases) {
            case 0:
                setFragmentCases(0);
                break;
            case 1:
                setFragmentCases(1);
                break;
            default:
                break;
        }

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    private void setFragmentCases(int cases) {
        Fragment fragment;

        switch (cases) {
            case 0:
                fragment = new MainLayoutFragment();
                addSubscreen(fragment);
                break;
            case 1:
                fragment = new FirstFragment();
                addSubscreen(fragment);
                break;
            case 2:
                fragment = new SecondFragment();
                addSubscreen(fragment);
                break;
            default:
                fragment = new FirstFragment();
                addSubscreen(fragment);
                break;
        }
    }

    public void addSubscreen(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(null)
                .commit();
        subscreensOnTheStack++;
    }


    public void popOffSubscreens() {
        while (subscreensOnTheStack > 0) {
            fragments.popBackStackImmediate();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        popOffSubscreens();
    }
}
