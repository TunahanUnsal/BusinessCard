package com.senior.businesscard.view.fragments;

import static com.senior.businesscard.view.activities.MainActivity.designFragment;
import static com.senior.businesscard.view.activities.MainActivity.historyFragment;
import static com.senior.businesscard.view.activities.MainActivity.scanFragment;
import static com.senior.businesscard.view.activities.MainActivity.transaction;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;
import com.senior.businesscard.R;
import com.senior.businesscard.databinding.FragmentScanBinding;
import com.senior.businesscard.view.utils.OnSwipeTouchListener;

import java.util.Objects;


//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │
//  │ ──────────────────────── │
//  │    15.11.2021  21:46     │
//  └──────────────────────────┘

public class ScanFragment extends Fragment {

    private FragmentScanBinding binding;
    private CodeScanner mCodeScanner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentScanBinding.inflate(inflater,container,false);

        if (requireActivity().checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[] {Manifest.permission.CAMERA}, 1);
        }

        startCam();
        listeners();

        return binding.getRoot();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void listeners(){

        binding.scannerView.setOnTouchListener(new OnSwipeTouchListener(getContext()) {


            public void onSwipeRight() {

            }
            public void onSwipeLeft() {

                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, designFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }

        });

    }
    public void startCam(){

        CodeScannerView scannerView = binding.scannerView;

        mCodeScanner = new CodeScanner(requireActivity(), scannerView);

        mCodeScanner.setDecodeCallback(result -> requireActivity().runOnUiThread(() -> Toast.makeText(getActivity(), result.getText(), Toast.LENGTH_SHORT).show()));

        scannerView.setOnClickListener(view -> mCodeScanner.startPreview());

    }
}