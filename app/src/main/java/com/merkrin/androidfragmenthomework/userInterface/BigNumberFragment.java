package com.merkrin.androidfragmenthomework.userInterface;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.merkrin.androidfragmenthomework.R;

import logic.NumberItem;

public class BigNumberFragment extends Fragment {
    private NumberItem numberItem;
    private TextView bigNumber;

    public BigNumberFragment() {
        // Required empty public constructor
    }

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

        if(numberItem != null){
            bigNumber.setTextColor(numberItem.getColor());
            bigNumber.setText(numberItem.toString());
        }
    }

    public void initializeNumber(NumberItem numberItem){
        this.numberItem = numberItem;
    }
}