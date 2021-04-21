package com.programming_concept.senior_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawer;
    private GoogleSignInClient mGoogleSignInClient;
    GoogleApiClient mGoogleApiClient;
    private FirebaseAuth mAuth;


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
        switch (item.getItemId()) {
            case R.id.nav_personal_info:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container,
                        new ProfileFragment()).commit();
                break;

            case R.id.nav_health_alert:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container,
                        new HealthAlertActivity2()).commit();
                break;

            case R.id.nav_pdf:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container,
                        new PDFFragment()).commit();
                break;

            case R.id.nav_questionnair:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container,
                        new QuestionnaireFagment()).commit();
                break;

            case R.id.nav_covid_record:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container,
                        new CasesFragment()).commit();
                break;

            case R.id.nav_log_out:
                signOut();
                break;

            case R.id.nav_vaccination_record:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container,
                        new VaccinationTotalUSA()).commit();


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

    private void signOut() {

        GoogleSignIn.getClient(this, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()).signOut().
                addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            FirebaseAuth.getInstance().signOut();
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);
                        }
                    }
                });
    }
}
