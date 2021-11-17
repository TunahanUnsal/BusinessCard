package com.senior.businesscard.view.fragments;

import static com.senior.businesscard.view.activities.MainActivity.designFragment;
import static com.senior.businesscard.view.activities.MainActivity.historyFragment;
import static com.senior.businesscard.view.activities.MainActivity.scanFragment;
import static com.senior.businesscard.view.activities.MainActivity.transaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.senior.businesscard.R;
import com.senior.businesscard.databinding.FragmentHistoryBinding;
import com.senior.businesscard.view.utils.OnSwipeTouchListener;

//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │
//  │ ──────────────────────── │
//  │    15.11.2021  21:46     │
//  └──────────────────────────┘

public class HistoryFragment extends Fragment {

    private FragmentHistoryBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHistoryBinding.inflate(inflater,container,false);

        listeners();

        return binding.getRoot();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void listeners(){

        binding.generalView.setOnTouchListener(new OnSwipeTouchListener(getContext()) {

            public void onSwipeRight() {

                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, designFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
            public void onSwipeLeft() {

            }

        });

    }
}