package com.senior.businesscard.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.senior.businesscard.R;
import com.senior.businesscard.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listeners();

    }

    private void listeners(){

    }
}