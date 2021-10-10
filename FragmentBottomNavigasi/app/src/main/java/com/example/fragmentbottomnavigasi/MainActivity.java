package com.example.fragmentbottomnavigasi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    //membuat deklarasi bottomNavigation
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_nav);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        //membuat action ketika kita memilih bottom navigation
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //membuat objek fragment
                Fragment selectedFragment = null;

                //membuat switch - case
                switch (item.getItemId()){
                    //case navigasi home
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;

                    //case navigasi shorts
                    case R.id.nav_shorts:
                        selectedFragment = new ShortsFragment();
                        break;

                    //case navigasi subs
                    case R.id.nav_subs:
                        selectedFragment = new SubscriptionFragment();
                        break;

                    //case navigasi koleksi
                    case R.id.nav_koleksi:
                        selectedFragment = new KoleksiFragment();
                        break;
                }

                //memanggil fungsi dari setiap fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });
    }
}