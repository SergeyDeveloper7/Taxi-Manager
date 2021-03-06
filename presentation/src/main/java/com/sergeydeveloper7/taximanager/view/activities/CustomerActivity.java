package com.sergeydeveloper7.taximanager.view.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sergeydeveloper7.data.models.UserModel;
import com.sergeydeveloper7.taximanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView          navHeaderMainTitleTextView;
    private TextView          navHeaderSecondaryTitleTextView;
    private UserModel         userModel;
    private SharedPreferences sharedPreferences;

    @BindView(R.id.toolbar)       Toolbar toolbar;
    @BindView(R.id.fab)           FloatingActionButton fab;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.nav_view)      NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        userModel = new Gson().fromJson(sharedPreferences.getString("user", null), UserModel.class);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        fab.setOnClickListener((View view) -> {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navHeaderMainTitleTextView = navigationView.getHeaderView(0).findViewById(R.id.navHeaderMainTitleTextView);
        navHeaderSecondaryTitleTextView = navigationView.getHeaderView(0).findViewById(R.id.navHeaderSecondaryTitleTextView);

        navHeaderMainTitleTextView.setText(userModel.getUserName());
        navHeaderSecondaryTitleTextView.setText(userModel.getEmail());
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.customer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
