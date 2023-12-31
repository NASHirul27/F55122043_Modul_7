package com.nashirul.sqlite_f55122043;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nashirul.sqlite_f55122043.databinding.ActivityContentBinding;

public class ContentActivity extends AppCompatActivity {
    private ActivityContentBinding binding;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedList =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    int itemId = item.getItemId();

                    if (itemId == R.id.navigation_home) {
                        fragment = new HomeFragment();
                    } else if (itemId == R.id.navigation_dashboard) {
                        fragment = new DashboardFragment();
                    } else if (itemId == R.id.navigation_account) {
                        fragment = new AccountFragment();
                    }

                    if (fragment != null) {
                        switchFragment(fragment);
                        return true;
                    }

                    return false;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedList);

        if (savedInstanceState == null){
            binding.navigation.setSelectedItemId(R.id.navigation_home);
        }
    }
    private void switchFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName()).commit();
    }
}