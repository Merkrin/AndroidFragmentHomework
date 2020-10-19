package com.merkrin.androidfragmenthomework.userInterface;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.merkrin.androidfragmenthomework.R;

import java.util.Objects;

import logic.NumberItem;

/**
 * Big number fragment class.
 */
public class BigNumberFragment extends Fragment {
    // NumberItem that is shown in this fragment.
    private NumberItem numberItem;
    // TextView to show number.
    private TextView bigNumber;

    // Constant strings for working process simplification.
    private static final String APP_PREFERENCES = "application_settings";
    private static final String APP_PREFERENCES_CURRENT_NUMBER = "current_number";

    // SharedPreferences that are used to restore state.
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

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
        return inflater.inflate(R.layout.fragment_big_number, container, false);
    }

    /**
     * Method that implements all the logic after the fragment's view creation.
     *
     * @param view               Current view.
     * @param savedInstanceState State of fragment that was saved.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bigNumber = view.findViewById(R.id.bigNumber);

        // Shared preferences initialization.
        sharedPreferences = Objects.requireNonNull(this.getActivity())
                .getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // If numberItem is null take number from sharedPreferences.
        // The only problem is that it is not permitted to save Object instances there.
        // So a JSON-serialization is commonly used, but a downloaded library is needed for that.
        // That is why I prefer creating new NumberItem instance.
        // If numberItem is not null save it for further usage.
        if (numberItem == null) {
            if (sharedPreferences.contains(APP_PREFERENCES_CURRENT_NUMBER)) {
                numberItem = new NumberItem(sharedPreferences.getInt(APP_PREFERENCES_CURRENT_NUMBER,
                        1));
            }
        } else {
            editor.putInt(APP_PREFERENCES_CURRENT_NUMBER, this.numberItem.getNumber());
            editor.commit();
        }

        bigNumber.setTextColor(numberItem.getColor());
        bigNumber.setText(numberItem.toString());
    }

    /**
     * Method for showed number item initialization.
     *
     * @param numberItem NumberItem instance to show.
     */
    public void initializeNumber(NumberItem numberItem) {
        this.numberItem = numberItem;
    }
}