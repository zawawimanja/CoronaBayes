package com.awi.coronatracker;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.awi.ViewPagerAdapter;
import com.awi.coronatracker.QR.QuestionFragment;
import com.awi.coronatracker.news.NewsFragment;
import com.awi.coronatracker.retrofit.MovieFragment;
import com.awi.coronatracker.webview.BotFragment;
import com.awi.coronatracker.webview.MapFragment;

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

    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);


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

                        int id = menuItem.getItemId();

                        if (id == R.id.bot) {
                            fragment = new BotFragment();
                           // loadFragment(fragment);
                         //   viewPager.setCurrentItem(2);
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
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NewsFragment(), "News");
        adapter.addFragment(new MapFragment(), "Map");
        adapter.addFragment(new QuestionFragment(),"QR");
        adapter.addFragment(new BotFragment(),"Bot");

        adapter.addFragment(new MovieFragment(), "Hospital");
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
            return true;
        } else if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }


//    private void loadFragment(Fragment fragment) {
//        // load fragment
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.viewPager, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }




}
