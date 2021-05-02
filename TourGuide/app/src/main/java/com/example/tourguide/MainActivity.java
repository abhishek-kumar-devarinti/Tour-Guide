package com.example.tourguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    boolean onHome = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new AboutFragment()).commit();

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navi_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new AboutFragment()).commit();
                        onHome = true;
                        break;
                    case R.id.navi_temples:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TemplesFragment()).commit();
                        onHome = false;
                        break;
                    case R.id.navi_restaurant:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new RestaurantFragment()).commit();
                        onHome = false;
                        break;
                    case R.id.navi_hotels:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HotelsFragment()).commit();
                        onHome = false;
                        break;
                    case R.id.navi_theatres:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TheatresFragment()).commit();
                        onHome = false;
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (!onHome){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new AboutFragment()).commit();
            onHome = true;
        }
        else {
            super.onBackPressed();
        }
    }
}
