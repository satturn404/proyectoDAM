package com.HilarioBazanToM.umbrellacorpz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class productos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        TextView tvMostrar = findViewById(R.id.tvMostrar);
        tvMostrar.setText("");
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("productos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot producto: task.getResult()){
                                tvMostrar.append(producto.getId()+" "+producto.getData());
                            }

                        }else{
                            Log.w("APP","Error al traer docs",task.getException());
                        }
                    }
                });

    }
}