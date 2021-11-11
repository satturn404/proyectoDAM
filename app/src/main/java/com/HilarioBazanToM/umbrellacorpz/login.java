package com.HilarioBazanToM.umbrellacorpz;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                                Toast.makeText(getApplicationContext(), "usuario no coincide", Toast.LENGTH_SHORT).show();
                            }else {

                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if (pass.equals(document.getData().get("clave"))) {
                                        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                                        Toast.makeText(getApplicationContext(), "Escoja pedido a atender", Toast.LENGTH_LONG).show();
                                        startActivity(intent);
                                    }else{
                                        Toast.makeText(getApplicationContext(), "contraseña no coincide", Toast.LENGTH_SHORT).show();
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