package com.jason.marks.sampleapp.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.jason.marks.sampleapp.R;
import com.jason.marks.sampleapp.base.BaseActivity;

/**
 * Created by Jason Marks on 7/21/2018.
 *
 *  An activity that contains a {@link android.support.v4.app.Fragment} that will display cards
 *  of data that contain relevant information for the end user.  This activity uses
 *  a left {@link NavigationView}.
 */

public class MainActivity extends BaseActivity implements
        MainContract.MainActivityView, NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up the toolbar in BaseActivity
        Toolbar toolbar = setUpToolbar();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FrameLayout mainContent = findViewById(R.id.content_frame);

        if (mainContent != null) {

            // if recreating reset callbacks
            if (savedInstanceState != null) {
                MainFragment loadedFragment = (MainFragment) getSupportFragmentManager()
                        .findFragmentByTag(MainFragment.MAIN_FRAGMENT_TAG);
                loadedFragment.setActivityViewCallback(this);
                return;
            }

            MainFragment mainFragment = new MainFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_frame, mainFragment, MainFragment.MAIN_FRAGMENT_TAG).commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer != null) {
            drawer.closeDrawer(GravityCompat.START);
        }

        return true;
    }
}
