package com.example.coronavirustracker.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.coronavirustracker.Adapter.BaseAdapter;
import com.example.coronavirustracker.Fragment.NavigationDrawerFragment;
import com.example.coronavirustracker.Modal.Data;
import com.example.coronavirustracker.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "com.example.coronavirustracker.Activity.MainActivity";
    private List<Data> dataList;
    private BaseAdapter adapter;
    private BottomAppBar bar;

    @SuppressLint({"WrongConstant", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        NavigationView navigationView = findViewById(R.id.navigation);
        bar = findViewById(R.id.bar);
        bar.setTitle(R.string.app_name);
        bar.setTitleTextColor(R.color.colorAccent);
//        setSupportActionBar(bar);
        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                NavigationDrawerFragment navigationView = NavigationDrawerFragment.newInstance();
                navigationView.show(getSupportFragmentManager(), TAG);
//navigationView.showNow(getSupportFragmentManager(),TAG);
                Log.e(TAG, "onClick: " + "hi");
            }
        });
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

    @SuppressLint("LongLogTag")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sypmtoms:
                Log.e(TAG, "onOptionsItemSelected: sypmtoms");
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
