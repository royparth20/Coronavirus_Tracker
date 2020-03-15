package com.example.coronavirustracker.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.coronavirustracker.Fragment.NavigationDrawerFragment;
import com.example.coronavirustracker.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "com.example.coronavirustracker.Activity.MainActivity";
    private BottomAppBar bar;

    @SuppressLint({"WrongConstant", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    @Override
    public void onBackPressed() {

//        new android.app.AlertDialog.Builder(this).setTitle("Exit App").setMessage("Do you want to exit app?").setPositiveButton("Yes", new ExitApp()).setNegativeButton("No", null).show();
        show_Exit();
    }

    private class ExitApp implements DialogInterface.OnClickListener {
        @SuppressLint("NewApi")
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onClick(DialogInterface dialog, int which) {
            finishAffinity();
            System.exit(0);
        }
    }
    private void show_Exit() {
        String positiveText = getString(android.R.string.ok);
        String negativeText = getString(android.R.string.cancel);
        new MaterialAlertDialogBuilder(this, R.style.CutShapeTheme)
                .setTitle(getString(R.string.label_exit_app))
                .setMessage(getString(R.string.description_sure_exit_app)).setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // dismiss alert dialog, update preferences with game score and restart play fragment
                        Log.d("myTag", "positive button clicked");
                        dialog.dismiss();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            finishAffinity();
                        }
                        System.exit(0);
                    }
                }).setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // dismiss dialog, start counter again
                        dialog.dismiss();
                        Log.d("myTag", "negative button clicked");
                    }
                }).create().show();
    }
}
