package com.awi.coronatracker.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.awi.coronatracker.MainActivity;
import com.awi.coronatracker.R;
import com.awi.coronatracker.settings.SettingsFragment;

public class Main2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TestFragment autocompleteFragment = new TestFragment();
        Test2Fragment autocompleteFragment1 = new Test2Fragment();
        SettingsFragment autocompleteFragment12 = new SettingsFragment();


        //get the intent in the target activity
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Integer user_id = extras.getInt("FragmentChoose");

        if(user_id==1){

            loadFragment(autocompleteFragment);
        }
        else{

            loadFragment(autocompleteFragment12);


        }



    }

        private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.test, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            Intent mainIntent = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(mainIntent);
        }
    }


}
