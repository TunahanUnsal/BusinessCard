package com.senior.businesscard.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.senior.businesscard.R;
import com.senior.businesscard.databinding.ActivityLoginBinding;
import com.senior.businesscard.model.models.BusinessCardModel;
import com.senior.businesscard.model.sources.HistorySource;
import com.senior.businesscard.view.utils.UiUtils;

//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │
//  │ ──────────────────────── │
//  │    15.11.2021  21:46     │
//  └──────────────────────────┘

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        UiUtils.hideSystemUI(binding.getRoot());
        listeners();
        test();

    }

    private void listeners(){

        binding.btnGoogleSignIn.setOnClickListener(v -> {

            Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(myIntent);

        });

    }

    public void test(){

        BusinessCardModel businessCardModel = new BusinessCardModel("www.google.com","18.10.1997","Tuna Ünsal","","","","");
        HistorySource.history_list.add(businessCardModel);

        businessCardModel = new BusinessCardModel("www.google.com","18.10.1997","Mehmet Ünsal","","","","");
        HistorySource.history_list.add(businessCardModel);

        businessCardModel = new BusinessCardModel("www.google.com","18.10.1997","Eray Turan","","","","");
        HistorySource.history_list.add(businessCardModel);

        businessCardModel = new BusinessCardModel("www.google.com","18.10.1997","Arda Eren Erdoğan","","","","");
        HistorySource.history_list.add(businessCardModel);

        businessCardModel = new BusinessCardModel("www.google.com","18.10.1997","Enes Özeren","","","","");
        HistorySource.history_list.add(businessCardModel);

        businessCardModel = new BusinessCardModel("www.google.com","18.10.1997","Semih Kalkan","","","","");
        HistorySource.history_list.add(businessCardModel);

        businessCardModel = new BusinessCardModel("www.google.com","18.10.1997","Mevlüde Köksal","","","","");
        HistorySource.history_list.add(businessCardModel);


    }
}