package app.web.firmcard.view.fragments;

import static app.web.firmcard.view.activities.MainActivity.designFragment;
import static app.web.firmcard.view.activities.MainActivity.historyFragment;
import static app.web.firmcard.view.activities.MainActivity.scanFragment;
import static app.web.firmcard.view.activities.MainActivity.transaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import app.web.firmcard.R;
import app.web.firmcard.databinding.FragmentHistoryBinding;
import app.web.firmcard.model.sources.HistorySource;
import app.web.firmcard.view.adapters.HistoryListAdapter;
import app.web.firmcard.view.utils.OnSwipeTouchListener;

//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │
//  │ ──────────────────────── │
//  │    15.11.2021  21:46     │
//  └──────────────────────────┘

public class HistoryFragment extends Fragment {

    private FragmentHistoryBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHistoryBinding.inflate(inflater,container,false);


        ListAdapter customAdapter = new HistoryListAdapter(getContext(), R.layout.history_list_item, HistorySource.history_list);

        binding.historyListView.setAdapter(customAdapter);

        listeners();


        return binding.getRoot();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void listeners(){

        binding.historyListView.setOnTouchListener(new OnSwipeTouchListener(getContext()) {

            public void onSwipeRight() {

                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                transaction.replace(R.id.fragment_container, designFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
            public void onSwipeLeft() {

            }

        });

    }
}