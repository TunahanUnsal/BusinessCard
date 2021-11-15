package com.senior.businesscard.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.senior.businesscard.R;
import com.senior.businesscard.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listeners();

    }

    private void listeners(){

    }
}