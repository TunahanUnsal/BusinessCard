package app.web.firmcard.view.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import app.web.firmcard.databinding.ActivityLoginBinding;
import app.web.firmcard.model.models.BusinessCardModel;
import app.web.firmcard.model.sources.Constants;
import app.web.firmcard.model.sources.HistorySource;
import app.web.firmcard.view.utils.UiUtils;

//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │
//  │ ──────────────────────── │
//  │    15.11.2021  21:46     │
//  └──────────────────────────┘

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private ActivityLoginBinding binding;
    private static final int RC_SIGN_IN = 1;

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


            GoogleSignInOptions gso =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build();
            GoogleApiClient googleApiClient=new GoogleApiClient.Builder(this)
                    .enableAutoManage(this,this)
                    .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                    .build();

            Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
            startActivityForResult(intent,RC_SIGN_IN);


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

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            assert data != null;
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            assert result != null;
            handleSignInResult(result);

        }
    }
    private void handleSignInResult(GoogleSignInResult result){
        if(result.isSuccess()){
            Constants.googleSignInAccount = result.getSignInAccount();
            gotoProfile();
        }else{
            Toast.makeText(getApplicationContext(),"Sign in cancel",Toast.LENGTH_LONG).show();
        }
    }

    private void gotoProfile(){
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }
}