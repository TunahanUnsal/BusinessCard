package app.web.firmcard.view.fragments;

import static app.web.firmcard.view.activities.MainActivity.designFragment;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import app.web.firmcard.R;
import app.web.firmcard.databinding.FragmentScanBinding;
import app.web.firmcard.view.utils.OnSwipeTouchListener;

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

        mCodeScanner.setDecodeCallback(result -> requireActivity().runOnUiThread(() -> {


            binding.scannerView.setVisibility(View.GONE);
            binding.webView.setVisibility(View.VISIBLE);
            binding.webView.loadUrl(result.getText());
            binding.webView.setWebViewClient(new WebViewClient());
            binding.webView.setInitialScale(1);
            binding.webView.getSettings().setBuiltInZoomControls(true);
            binding.webView.getSettings().setUseWideViewPort(true);

        }));

        scannerView.setOnClickListener(view -> mCodeScanner.startPreview());

    }
}