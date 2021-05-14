package com.example.grecosapp.activity_manager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grecosapp.R;
import com.example.grecosapp.data.IP_METHODS;
import com.google.android.material.navigation.NavigationView;

public class TorCheckActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private Handler handler = new Handler();
    private int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tor_check);

        /**********Hooks***********/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar_home);

        /**********Tool Bar***********/
        setSupportActionBar(toolbar);

        /**********Navigation Drawer Menu***********/
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
    }

    public void checkTor(View view) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        TextView editText = (TextView)findViewById(R.id.text_get_tor);
        IP_METHODS.WAIT_A_SECOND();
        ImageView imageView = (ImageView)findViewById(R.id.shield5);
        if(IP_METHODS.CHECK_TOR()) {
            editText.setText("TOR DETECTED!");
            imageView.setImageResource(R.drawable.safe);
        } else {
            editText.setText("TOR NOT DETECTED!");
            imageView.setImageResource(R.drawable.unsafe);
        }
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
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.nav_home:
                intent = new Intent(TorCheckActivity.this, HomeActivity.class);
                break;
            case R.id.nav_google_maps:
                intent = new Intent(TorCheckActivity.this, GoogleMaps.class);
                break;
            case R.id.nav_credits:
                intent = new Intent(TorCheckActivity.this, CreditsActivity.class);
                break;
            case R.id.whois_ip:
                intent = new Intent(TorCheckActivity.this, WhoisIPActivity.class);
                break;
            case R.id.nav_profile:
                intent = new Intent(TorCheckActivity.this, ProfileActivity.class);
                break;
            case R.id.nav_logout:
                intent = new Intent(TorCheckActivity.this, LogoutActivity.class);
                break;
            case R.id.nav_share:
                intent = new Intent(TorCheckActivity.this, ShareActivity.class);
                break;
            case R.id.nav_rate:
                intent = new Intent(TorCheckActivity.this, RateActivity.class);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        startActivity(intent);
        return true;
    }

}