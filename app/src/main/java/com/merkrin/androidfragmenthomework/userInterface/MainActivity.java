package com.merkrin.androidfragmenthomework.userInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.merkrin.androidfragmenthomework.R;

public class MainActivity extends AppCompatActivity {
    private static final NumbersListFragment numbersListFragment = new NumbersListFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, numbersListFragment).commit();
        }
    }

    public void setFragment(BigNumberFragment bigNumberFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, bigNumberFragment).addToBackStack(null).commit();
    }
}