package com.programming_concept.senior_project;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container,
                    new ProfileFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_personal_info);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_personal_info:
                 getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container,
                         new ProfileFragment()).commit();
                break;
            case R.id.nav_health_alert:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container,
                        new HealthAlertFragment()).commit();
                break;
            case R.id.nav_pdf:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container,
                        new PDFFragment()).commit();
                break;
            case R.id.nav_questionnair:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container,
                        new QuestionnaireFagment()).commit();
                break;
        }

        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}