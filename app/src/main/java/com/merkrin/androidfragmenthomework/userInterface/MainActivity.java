package com.merkrin.androidfragmenthomework.userInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.merkrin.androidfragmenthomework.R;

/**
 * Application's main activity class.
 */
public class MainActivity extends AppCompatActivity {
    // I intentionally left the app without saving state when activity was closed with big number
    // fragment shown.
    // But this saving can be implemented by shared preferences using for example.
    // Or maybe with onSaveInstanceState method implementation...

    // Instance of numbers list fragment.
    private static final NumbersListFragment numbersListFragment = new NumbersListFragment();

    /**
     * Method that implements all the logic for the activity creation.
     *
     * @param savedInstanceState State of activity that was saved.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // If saved instance state is null numbers list fragment is shown.
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, numbersListFragment)
                    .commit();
        }
    }

    /**
     * Utility method for showing big number fragment.
     *
     * @param bigNumberFragment Instance of fragment to be shown.
     */
    public void setFragment(BigNumberFragment bigNumberFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, bigNumberFragment).addToBackStack(null).commit();
    }
}