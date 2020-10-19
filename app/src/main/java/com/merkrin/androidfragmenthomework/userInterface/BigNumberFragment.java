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

public class BigNumberFragment extends Fragment {
    private NumberItem numberItem;
    private TextView bigNumber;

    public static final String APP_PREFERENCES = "application_settings";
    public static final String APP_PREFERENCES_CURRENT_NUMBER = "current_number";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_big_number, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bigNumber = view.findViewById(R.id.bigNumber);
        sharedPreferences = Objects.requireNonNull(this.getActivity())
                .getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (numberItem == null) {
            if (sharedPreferences.contains(APP_PREFERENCES_CURRENT_NUMBER)) {
                numberItem = new NumberItem(sharedPreferences.getInt(APP_PREFERENCES_CURRENT_NUMBER,
                        1));
            }
        }else{
            editor.putInt(APP_PREFERENCES_CURRENT_NUMBER, this.numberItem.getNumber());
            editor.commit();
        }

        bigNumber.setTextColor(numberItem.getColor());
        bigNumber.setText(numberItem.toString());
    }

    public void initializeNumber(NumberItem numberItem) {
        this.numberItem = numberItem;
    }

    /*        sharedPreferences = Objects.requireNonNull(this.getActivity())
                .getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if (sharedPreferences.contains(APP_PREFERENCES_CURRENT_NUMBER)) {
            numberItem = new NumberItem(sharedPreferences.getInt(APP_PREFERENCES_CURRENT_NUMBER,
                    1));
        }*/
}