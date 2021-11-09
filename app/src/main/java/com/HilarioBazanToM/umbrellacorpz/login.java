package com.HilarioBazanToM.umbrellacorpz;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class login extends AppCompatActivity {
    EditText username, password;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = FirebaseFirestore.getInstance();
        username = findViewById(R.id.userID);
        password = findViewById(R.id.userContra);


    }
    public void login(View view) {
        String nombre= username.getText().toString();
        String pass= password.getText().toString();
        db.collection("users")
                .whereEqualTo("user",nombre)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()) {
                            if (task.getResult().isEmpty()) {
                                Log.d("REROR","usuario y/o contraseña no coinciden 1");
                            }else {

                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if (pass.equals(document.getData().get("clave"))) {
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                    }else{
                                        Log.d("REROR","usuaio y/o contraseña no coinciden2");
                                    }
                                }
                            }
                        }else {
                            Log.e("EREROR","error getting docmuent", task.getException());
                        }

                    }
                });



    }

}