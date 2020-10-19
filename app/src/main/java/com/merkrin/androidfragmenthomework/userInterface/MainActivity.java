package com.merkrin.androidfragmenthomework.userInterface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.merkrin.androidfragmenthomework.R;

import logic.NumberViewHolder;

public class MainActivity extends AppCompatActivity {
    LinearLayout container;

    private static NumbersListFragment numbersListFragment = new NumbersListFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.container, numbersListFragment).commit();
        }
    }

    public void setFragment(BigNumberFragment bigNumberFragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, bigNumberFragment).addToBackStack(null).commit();
    }
}