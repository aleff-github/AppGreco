package com.example.grecosapp.activity_manager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.grecosapp.R;
import com.google.android.material.navigation.NavigationView;

public class CreditsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);

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

    public void openGitHubAccount(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/NoNameoN-A"));
        startActivity(browserIntent);
    }

    public void openPersonalWebSite(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.autistici.org/nonameon/"));
        startActivity(browserIntent);
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
                 intent = new Intent(CreditsActivity.this, HomeActivity.class);
                break;
            case R.id.nav_google_maps:
                intent = new Intent(CreditsActivity.this, GoogleMaps.class);
                break;
            case R.id.nav_credits:
                break;
            case R.id.whois_ip:
                intent = new Intent(CreditsActivity.this, WhoisIPActivity.class);
                break;
            case R.id.nav_profile:
                intent = new Intent(CreditsActivity.this, ProfileActivity.class);
                break;
            case R.id.nav_logout:
                intent = new Intent(CreditsActivity.this, LogoutActivity.class);
                break;
            case R.id.nav_share:
                intent = new Intent(CreditsActivity.this, ShareActivity.class);
                break;
            case R.id.nav_rate:
                intent = new Intent(CreditsActivity.this, RateActivity.class);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        startActivity(intent);
        return true;
    }

}