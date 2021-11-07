package com.HilarioBazanToM.umbrellacorpz;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class login extends AppCompatActivity {
    EditText username, password;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        db = FirebaseFirestore.getInstance();
    }

    public void iniLogin(View view) {
        String usuario = username.getText().toString();
        String contrasenha = password.getText().toString();

        db.collection("users")
                .whereEqualTo("user",usuario)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                Log.d("Exito",document.getId()+ " => " + document.getData());
                            }
                        }else{
                            Log.d("ERROR","error getting docments: ", task.getException());
                        }
                    }
                });

    }
}