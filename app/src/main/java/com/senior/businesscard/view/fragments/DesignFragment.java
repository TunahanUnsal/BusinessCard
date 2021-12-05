package com.senior.businesscard.view.fragments;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static com.senior.businesscard.view.activities.MainActivity.historyFragment;
import static com.senior.businesscard.view.activities.MainActivity.scanFragment;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.senior.businesscard.R;
import com.senior.businesscard.databinding.FragmentDesignBinding;
import com.senior.businesscard.model.models.BusinessCardModel;
import com.senior.businesscard.view.utils.OnSwipeTouchListener;
import java.util.Date;
import java.util.Objects;

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

                Log.d("TAG", "onSwipeRight");
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                transaction.replace(R.id.fragment_container, scanFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
            public void onSwipeLeft() {

                Log.d("TAG", "onSwipeLeft");
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, historyFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }

        });

        binding.createButton.setOnClickListener(v -> {

            String url = "https://www.bitswot.com/p";

            Date date = new Date();
            BusinessCardModel businessCardModel = new BusinessCardModel(url,date.toString(),binding.editTextName.toString(),
                    binding.editTextPhone.toString(),binding.editTextMail.toString(),binding.editTextCompany.toString(),binding.editTextJob.toString());

            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

            try{
                BitMatrix bitMatrix = multiFormatWriter.encode(url, BarcodeFormat.QR_CODE,300,300);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                //imageView.setImageBitmap(bitmap);
                onButtonShowPopupWindowClick(binding.getRoot(),bitmap,url);
            }catch (Exception e){
                e.printStackTrace();
            }
        });

    }

    public void onButtonShowPopupWindowClick(View view,Bitmap bitmap,String url) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                requireContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.pop_up_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = 600;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        ImageView imageView = popupView.findViewById(R.id.qr_code_image);
        Button button = popupView.findViewById(R.id.shareButton);

        imageView.setImageBitmap(bitmap);

        button.setOnClickListener(v -> {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Hello, there is my business card : " + url;
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, url);
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        });




    }

}