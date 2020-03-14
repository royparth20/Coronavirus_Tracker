package com.example.coronavirustracker.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.coronavirustracker.Adapter.BaseAdapter;
import com.example.coronavirustracker.Modal.Data;
import com.example.coronavirustracker.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "NainActivity";
    private List<Data> dataList;
    private BaseAdapter adapter;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        NavigationView navigationView = findViewById(R.id.navigation);

        FloatingActionButton f_btn = findViewById(R.id.fab);
        f_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FragmentActivity.class).putExtra("case", 0));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_navigation_items, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sypmtoms:
                Log.e(TAG, "onOptionsItemSelected: sypmtoms" );
                startActivity(new Intent(MainActivity.this, FragmentActivity.class).putExtra("case", 1));
                return true;
            case R.id.tracker:
                startActivity(new Intent(MainActivity.this, FragmentActivity.class).putExtra("case", 0));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
