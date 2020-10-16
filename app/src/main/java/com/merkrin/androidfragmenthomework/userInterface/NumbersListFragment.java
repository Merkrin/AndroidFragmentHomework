package com.merkrin.androidfragmenthomework.userInterface;

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

public class NumbersListFragment extends Fragment {
    View currentView;
    RecyclerView numbersList;

    private final int MAXIMAL_NUMBER = 100 + 1;

    public NumbersListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View currentView = inflater.inflate(R.layout.fragment_numbers_list, container,
                false);

        numbersList = currentView.findViewById(R.id.numbersList);

        return currentView;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
}