package com.HilarioBazanToM.umbrellacorpz;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.auth.api.Auth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class login extends AppCompatActivity {
    FirebaseAuth mfirebaseAutH;
    FirebaseAuth.AuthStateListener mAuthListener;
    public static final int REQUEST_CODE = 54654;
    List<AuthUI.IdpConfig> provider = Arrays.asList (
            new AuthUI.IdpConfig.FacebookBuilder().build(),
            new AuthUI.IdpConfig.GoogleBuilder().build()
            );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mfirebaseAutH = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user !=null ){
                    Toast.makeText( login.this,"Bienvenido Guapo", Toast.LENGTH_SHORT).show();
                }else {
                    startActivityForResult (AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(provider)
                        .setIsSmartLockEnabled(false)
                        .build(),REQUEST_CODE
                    );
                }
            }
        };
    }
    @Override
    protected void onResume(){
        super.onResume();
        mfirebaseAutH.addAuthStateListener(mAuthListener);
    }
    @Override
    protected void onPause(){
        super.onPause();
        mfirebaseAutH.addAuthStateListener(mAuthListener);
    }
    public void cerrarsession(View view) {
        AuthUI.getInstance().singOut(this).addOnComppleteListener(new OnCompleteListener<Void>(){
            @Override
            public void onComplete(@NonNull Task>void> task) {
        }
    });
}