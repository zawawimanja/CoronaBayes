package com.awi.coronatracker.profile.retrofit;



import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.awi.coronatracker.R;


public class ProfileActivity extends AppCompatActivity {

    ImageView back, edit;

    ImageView profile_image;

    TextView profile_full_name, profile_ic_number, profile_phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Hide the Status Bar and the Navigation Bar

//        View overlay = findViewById(R.id.profile);
//
//        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        Toolbar toolbar = findViewById(R.id.profile_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        profile_image = (ImageView) findViewById(R.id.profile_image);

        profile_full_name = (TextView) findViewById(R.id.profile_full_name);
        profile_ic_number = (TextView) findViewById(R.id.profile_ic_number);
        profile_phone_number = (TextView) findViewById(R.id.profile_phone_number);

        back = findViewById(R.id.back);
        edit = findViewById(R.id.edit);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Intent menuIntent = new Intent(ProfileActivity.this, EditProfileActivity.class);
//                    startActivity(menuIntent);
            }
        });

//        // Set user information
//        profile_full_name.setText(Common.currentUser.getUserName());
//        profile_ic_number.setText(Common.currentUser.getUserIdentityCard());
//        profile_phone_number.setText(Common.currentUser.getUserPhone());
//
//        // Set image
//        Picasso.with(getBaseContext()).load(Common.currentUser.getUserImage()).into(profile_image);
    }
}
