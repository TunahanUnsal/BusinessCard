package com.senior.businesscard.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.senior.businesscard.R;
import com.senior.businesscard.databinding.FragmentDesignBinding;


public class DesignFragment extends Fragment {

    FragmentDesignBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDesignBinding.inflate(inflater,container,false);

        listeners();

        return binding.getRoot();
    }

    private void listeners(){

    }
}