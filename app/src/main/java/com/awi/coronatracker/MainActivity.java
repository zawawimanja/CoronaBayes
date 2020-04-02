package com.awi.coronatracker;

import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.awi.coronatracker.auth.SignInActivity;
import com.awi.coronatracker.test.Main2Activity;
import com.awi.coronatracker.test.Test2Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.FragmentTransaction;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.awi.ViewPagerAdapter;
import com.awi.coronatracker.QR.QuestionFragment;
import com.awi.coronatracker.nestedtab.MapFragment;
import com.awi.coronatracker.notification.retrofit.NotificationFragment;
import com.awi.coronatracker.profile.retrofit.ProfileFragment;




public class MainActivity extends AppCompatActivity  {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.mipmap.corona_news,
            R.mipmap.global_corona_impact_round,
            R.mipmap.india_corona_impact_round,
            R.mipmap.self_diagnosis
    };

    String NameHolder;
    TextView Name;
    Button LogOUT ;

    private DrawerLayout mDrawerLayout;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);

        Intent intent = getIntent();

        // Receiving User Email Send By MainActivity.
        NameHolder = intent.getStringExtra(SignInActivity.userName);

        // Setting up received email to TextView.
       // Name.setText(Name.getText().toString()+ NameHolder);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());




        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager);

        //create tab
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        // Create Navigation drawer and inlfate layout
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        //create drawer
        mDrawerLayout  = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();



//        tabLayout.getTabAt(0).setIcon(tabIcons[0]);





        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            VectorDrawableCompat indicator
                    = VectorDrawableCompat.create(getResources(), R.drawable.ic_menu, getTheme());
            indicator.setTint(ResourcesCompat.getColor(getResources(),R.color.white,getTheme()));
            supportActionBar.setHomeAsUpIndicator(indicator);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }


        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    // This method will trigger on item Click of navigation menu

                    //creating fragment object
                    Fragment fragment = null;
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        Test2Fragment fragment=new Test2Fragment();
                        int id = menuItem.getItemId();

                        if (id == R.id.bot) {

                           viewPager.setCurrentItem(2);
                        }
                       else if (id == R.id.test) {
                           Intent mainIntent = new Intent(MainActivity.this, Main2Activity.class);
                           mainIntent.putExtra("FragmentChoose","A");
                          startActivity(mainIntent);
                        }
                        else if (id == R.id.test1) {
                            Intent mainIntent = new Intent(MainActivity.this, Main2Activity.class);
                            mainIntent.putExtra("FragmentChoose","B");
                            startActivity(mainIntent);

//                            Intent mainIntent = new Intent(MainActivity.this, SettingsActivity.class);
//                            startActivity(mainIntent);

                        }


                        // Set item in checked state
                        menuItem.setChecked(true);

                        // TODO: handle navigation


                        // Closing drawer on item click
                        mDrawerLayout.closeDrawers();
                        return true;
                    }



                });




    }
    private void setupViewPager(ViewPager viewPager) {

        //in sequence
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new QuestionFragment(),"Home");
        adapter.addFragment(new MapFragment(), "Web");
        adapter.addFragment(new NotificationFragment(), "Notification");
        adapter.addFragment(new ProfileFragment(), "Profile");
        viewPager.setAdapter(adapter);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent mainIntent = new Intent(MainActivity.this, Main2Activity.class);
            mainIntent.putExtra("FragmentChoose","Settings");
            startActivity(mainIntent);
            return true;
        } else if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.test, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_shop:
                  //  toolbar.setTitle("Shop");
                    viewPager.setCurrentItem(0);

                    return true;
                case R.id.navigation_gifts:
                   // toolbar.setTitle("My Gifts");
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_cart:
                   // toolbar.setTitle("Cart");
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_profile:
                    //toolbar.setTitle("Profile");
                    viewPager.setCurrentItem(3);

                    return true;
            }

            return false;
        }
    };




}
