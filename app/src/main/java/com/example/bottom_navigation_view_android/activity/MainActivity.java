package com.example.bottom_navigation_view_android.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bottom_navigation_view_android.R;
import com.example.bottom_navigation_view_android.fragment.AccountFragment;
import com.example.bottom_navigation_view_android.fragment.ExploreFragment;
import com.example.bottom_navigation_view_android.fragment.HomeFragment;
import com.example.bottom_navigation_view_android.fragment.MoreFragment;
import com.example.bottom_navigation_view_android.fragment.OthersFragment;
import com.example.bottom_navigation_view_android.utility.BottomNavigationBehavior;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListener();
    }

    private void initViews() {
        bottomNav = findViewById(R.id.navView);
        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNav.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        addFragment(new HomeFragment());
    }

    private void initListener() {
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        addFragment(new HomeFragment());
                        break;

                    case R.id.explore:
                        Toast.makeText(MainActivity.this, "Explore", Toast.LENGTH_SHORT).show();
                        addFragment(new ExploreFragment());
                        break;

                    case R.id.others:
                        Toast.makeText(MainActivity.this, "Others", Toast.LENGTH_SHORT).show();
                        addFragment(new OthersFragment());
                        break;

                    case R.id.account:
                        Toast.makeText(MainActivity.this, "Account", Toast.LENGTH_SHORT).show();
                        addFragment(new AccountFragment());
                        break;

                    case R.id.more:
                        Toast.makeText(MainActivity.this, "More", Toast.LENGTH_SHORT).show();
                        addFragment(new MoreFragment());
                        break;
                }

                return false;
            }
        });
    }


    public void addFragment(Fragment fragment) {

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_place, fragment).commit();
        }
    }
}
