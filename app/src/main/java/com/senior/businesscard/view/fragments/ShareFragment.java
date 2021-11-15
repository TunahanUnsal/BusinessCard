package com.senior.businesscard.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.senior.businesscard.R;
import com.senior.businesscard.databinding.FragmentShareBinding;

public class ShareFragment extends Fragment {

    private FragmentShareBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentShareBinding.inflate(inflater,container,false);

        listeners();

        return binding.getRoot();
    }

    private void listeners(){

    }

}