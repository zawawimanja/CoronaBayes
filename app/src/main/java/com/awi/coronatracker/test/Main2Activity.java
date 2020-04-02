package com.awi.coronatracker.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.awi.coronatracker.MainActivity;
import com.awi.coronatracker.R;
import com.awi.coronatracker.notes.NotesFragment;
import com.awi.coronatracker.settings.SettingsFragment;

public class Main2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TestFragment autocompleteFragment = new TestFragment();
        Test2Fragment autocompleteFragment1 = new Test2Fragment();
        SettingsFragment autocompleteFragment12 = new SettingsFragment();
        NotesFragment notes= new NotesFragment();


        //get the intent in the target activity
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String user_id = extras.getString("FragmentChoose");

        if(user_id.contains("A")){

            loadFragment(autocompleteFragment);
        }
        else if(user_id.contains("A")){

            loadFragment(autocompleteFragment12);
        }


        else if (user_id.contains("Notes") ){

                loadFragment(notes);

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
