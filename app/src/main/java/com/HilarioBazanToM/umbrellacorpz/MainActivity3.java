package com.HilarioBazanToM.umbrellacorpz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView tvId = findViewById(R.id.tvId);
        String id = String.valueOf(getIntent().getExtras().get("id"));
        tvId.setText("Felicidades la entrega del producto N°: "+id+ " se realizó correctamente");
    }

    public void continuarP(View view) {
        Intent intentrecarga = new Intent(getApplicationContext(),MainActivity2.class);
        Toast.makeText(getApplicationContext(), "Pedido Entregado con Exito", Toast.LENGTH_SHORT).show();
        startActivity(intentrecarga);
    }
}

