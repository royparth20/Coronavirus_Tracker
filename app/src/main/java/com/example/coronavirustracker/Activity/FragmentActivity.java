package com.example.coronavirustracker.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.coronavirustracker.Fragment.FirstFragment;
import com.example.coronavirustracker.Fragment.MainLayoutFragment;
import com.example.coronavirustracker.Fragment.SecondFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.coronavirustracker.Fragment.SimpleFragment;
import com.example.coronavirustracker.R;

import java.util.Objects;
import java.util.Stack;

public class FragmentActivity extends AppCompatActivity {
    private static final String TAG = "com.example.coronavirustracker.Activity.FragmentActivity";
    private Stack<Fragment> stack = new Stack<>();

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.title_activity_fragment);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popFragment();
            }
        });
        int cases = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            cases = Objects.requireNonNull(getIntent().getExtras()).getInt("case", 0);
        }
        Log.e(TAG, "onCreate: "+cases );
        switch (cases) {
            case 0:
                setFragmentCases(0);
                toolbar.setTitle("Live Coronavirus Tracking");
                break;
            case 1:
                setFragmentCases(1);
                toolbar.setTitle("Symptoms");
                break;
            case 2:
                setFragmentCases(2);
                toolbar.setTitle("CORONAVIRUS SPREADS ");
                break;
            case 3:
                setFragmentCases(3);
                toolbar.setTitle("CORONAVIRUS PREVENTION");
                break;
            case 4:
                setFragmentCases(4);
                toolbar.setTitle("CORONAVIRUS TREATMENTS");
                break;
            default:
                break;
        }
    }

    private void setFragmentCases(int cases) {
        Fragment fragment;

        switch (cases) {
            case 0:
                fragment = new MainLayoutFragment();
                addSubscreen(fragment, true);
                break;
            case 1:
                fragment = new FirstFragment();
                addSubscreen(fragment, true);
                break;
            case 2:
                fragment = SimpleFragment.newInstance(1,TAG);
                addSubscreen(fragment, true);
                break;
            case 3:
                fragment = SimpleFragment.newInstance(2,TAG);
                addSubscreen(fragment, true);
                break;
            case 4:
                fragment = SimpleFragment.newInstance(3,TAG);
                addSubscreen(fragment, true);
                break;
            default:
//                fragment = new MainLayoutFragment();
//                addSubscreen(fragment, true);
                break;
        }
    }

    public void addSubscreen(Fragment fragment, boolean flag) {
        FragmentTransaction transation = getSupportFragmentManager()
                .beginTransaction();
        if (flag) {
            stack.push(fragment);
        }
        transation.replace(R.id.nav_host_fragment, fragment);
        transation.commit();

    }


    @SuppressLint("LongLogTag")
    public void popFragment() {

        if (!stack.isEmpty()) {
            Log.e(TAG, "popFragment: " + stack.size());
            if (stack.size() != 1) {
                Fragment f = stack.elementAt(stack.size() - 2);
                stack.pop();
                addSubscreen(f, false);
            } else {
                FragmentActivity.this.finish();
            }
        } else {
            FragmentActivity.this.finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        popFragment();
    }
}
