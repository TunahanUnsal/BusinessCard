package com.senior.businesscard.view.fragments;

import static com.senior.businesscard.view.activities.MainActivity.historyFragment;
import static com.senior.businesscard.view.activities.MainActivity.scanFragment;
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
import com.senior.businesscard.databinding.FragmentDesignBinding;
import com.senior.businesscard.view.utils.OnSwipeTouchListener;

//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │
//  │ ──────────────────────── │
//  │    15.11.2021  21:46     │
//  └──────────────────────────┘


public class DesignFragment extends Fragment {

    FragmentDesignBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDesignBinding.inflate(inflater,container,false);

        listeners();

        return binding.getRoot();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void listeners(){

        binding.generalView.setOnTouchListener(new OnSwipeTouchListener(getContext()) {


            public void onSwipeRight() {

                Log.d("TAG", "onSwipeLeft: asdasd");
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, scanFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
            public void onSwipeLeft() {

                Log.d("TAG", "onSwipeLeft: asdasd2");
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, historyFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }

        });

    }
}