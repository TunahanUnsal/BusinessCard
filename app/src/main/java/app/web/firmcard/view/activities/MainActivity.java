package app.web.firmcard.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.annotation.SuppressLint;
import android.os.Bundle;


import app.web.firmcard.R;
import app.web.firmcard.databinding.ActivityMainBinding;
import app.web.firmcard.view.fragments.DesignFragment;
import app.web.firmcard.view.fragments.HistoryFragment;
import app.web.firmcard.view.fragments.ScanFragment;
import app.web.firmcard.view.utils.UiUtils;

//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │
//  │ ──────────────────────── │
//  │    15.11.2021  21:46     │
//  └──────────────────────────┘


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public static Fragment scanFragment;
    public static Fragment historyFragment;
    public static Fragment designFragment;
    public static FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        UiUtils.hideSystemUI(binding.getRoot());
        fragmentCrete();
    }

    private void fragmentCrete(){

        transaction = getSupportFragmentManager().beginTransaction();

        scanFragment = new ScanFragment();
        historyFragment = new HistoryFragment();
        designFragment = new DesignFragment();

        transaction.replace(R.id.fragment_container, designFragment);
        transaction.commit();

    }
}