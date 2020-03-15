package com.royaldreams.coronavirustracker.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.royaldreams.coronavirustracker.R;
import com.squareup.picasso.Picasso;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        AppCompatImageView img=findViewById(R.id.img_splash);
//        Picasso.with(getApplicationContext()).load(R.drawable.background_banner_2).into(img);
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
