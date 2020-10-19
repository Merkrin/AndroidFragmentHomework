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

public class NumbersListFragment extends Fragment {
    private RecyclerView numbersList;
    private NumberItemAdapter numberItemAdapter;

    private int maximalNumber = 100;

    public static final String APP_PREFERENCES = "application_settings";
    public static final String APP_PREFERENCES_MAX_NUMBER = "maximal_number";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_numbers_list, container,
                false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeRecyclerView(view);

        sharedPreferences = Objects.requireNonNull(this.getActivity())
                .getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if (sharedPreferences.contains(APP_PREFERENCES_MAX_NUMBER)) {
            maximalNumber = sharedPreferences.getInt(APP_PREFERENCES_MAX_NUMBER, 100);
        }
        numberItemAdapter.setItems(maximalNumber);

        view.findViewById(R.id.addButton).setOnClickListener(view1 -> addNumber());
    }

    private void setColumns() {
        int columnsAmount = 3;

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            columnsAmount = 4;
        }

        // GetActivity returns Activity that is a Context
        GridLayoutManager manager = new GridLayoutManager(getActivity(), columnsAmount);

        numbersList.setLayoutManager(manager);
    }

    private void initializeRecyclerView(View view) {
        numbersList = view.findViewById(R.id.numbersList);

        numberItemAdapter = new NumberItemAdapter(view.getContext());
        numbersList.setAdapter(numberItemAdapter);

        setColumns();
    }

    private void addNumber(){
        maximalNumber++;

        numberItemAdapter.setItems(maximalNumber);

        editor.putInt(APP_PREFERENCES_MAX_NUMBER, maximalNumber);
        editor.commit();
    }
}