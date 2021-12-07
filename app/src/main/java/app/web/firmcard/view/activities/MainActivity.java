package app.web.firmcard.view.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

import app.web.firmcard.R;
import app.web.firmcard.databinding.ActivityMainBinding;
import app.web.firmcard.model.sources.Constants;
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
    FirebaseFirestore db = FirebaseFirestore.getInstance();

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
    private void writeFirebase(){
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("user_id", Constants.googleSignInAccount.getId());

        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(documentReference -> Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId()))
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document", e);
                    }
                });
    }
    private void readFirebase(){
        db.collection("users")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Log.d("TAG", document.getId() + " => " + document.getData());
                        }
                    } else {
                        Log.w("TAG", "Error getting documents.", task.getException());
                    }
                });
    }
}