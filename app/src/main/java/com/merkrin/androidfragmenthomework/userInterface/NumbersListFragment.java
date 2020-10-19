package com.merkrin.androidfragmenthomework.userInterface;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.merkrin.androidfragmenthomework.R;

import java.util.Objects;

import logic.NumberItemAdapter;

/**
 * Number list fragment class.
 */
public class NumbersListFragment extends Fragment {
    // Recycler view showed in the fragment.
    private RecyclerView numbersList;
    // Number item adapter to work with recycler view.
    private NumberItemAdapter numberItemAdapter;

    // Variable used to get what number was maximal in the list.
    private int maximalNumber = 100;

    // Constant strings for working process simplification.
    private static final String APP_PREFERENCES = "application_settings";
    private static final String APP_PREFERENCES_MAX_NUMBER = "maximal_number";

    // Constant values for columns amount in grid of recycler view
    private final int PORTRAIT_MODE_COLUMNS_AMOUNT = 3;
    private final int LANDSCAPE_MODE_COLUMNS_AMOUNT = 4;

    // SharedPreferences that are used to restore state.
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    /**
     * Method that implements all the logic for the fragment's view creation.
     *
     * @param inflater           Instance of layout inflater to create view from layout file.
     * @param container          Container instance of all the views.
     * @param savedInstanceState State of fragment that was saved.
     * @return View of the fragment.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_numbers_list, container,
                false);
    }

    /**
     * Method that implements all the logic after the fragment's view creation.
     *
     * @param view               Current view.
     * @param savedInstanceState State of fragment that was saved.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize recycler view for further usage.
        initializeRecyclerView(view);

        // Shared preferences initialization.
        sharedPreferences = Objects.requireNonNull(this.getActivity())
                .getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Check if there is any saved data for maximal number in the list.
        if (sharedPreferences.contains(APP_PREFERENCES_MAX_NUMBER)) {
            maximalNumber = sharedPreferences.getInt(APP_PREFERENCES_MAX_NUMBER, maximalNumber);
        }
        // Set items in the recycler view.
        numberItemAdapter.setItems(maximalNumber);

        // Set onClickListener to the addButton.
        view.findViewById(R.id.addButton).setOnClickListener(view1 -> addNumber());
    }

    /**
     * Method to set amount of columns in the recycler view.
     */
    private void setColumns() {
        int columnsAmount = PORTRAIT_MODE_COLUMNS_AMOUNT;

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            columnsAmount = LANDSCAPE_MODE_COLUMNS_AMOUNT;
        }

        // Set grid layout with given columns amount.
        numbersList.setLayoutManager(new GridLayoutManager(getActivity(), columnsAmount));
    }

    /**
     * Method for primary recycler view initialization - adapter and columns amount setting.
     *
     * @param view View of the fragment.
     */
    private void initializeRecyclerView(View view) {
        numbersList = view.findViewById(R.id.numbersList);

        numberItemAdapter = new NumberItemAdapter(view.getContext());
        numbersList.setAdapter(numberItemAdapter);

        setColumns();
    }

    /**
     * Method for number adding.
     */
    private void addNumber() {
        maximalNumber++;

        numberItemAdapter.setItems(maximalNumber);

        // Save new maximal number.
        editor.putInt(APP_PREFERENCES_MAX_NUMBER, maximalNumber);
        editor.commit();
    }
}