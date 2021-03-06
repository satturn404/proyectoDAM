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
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void guardarUsuario(View view) {
        Toast.makeText(getApplicationContext(), "Formulario Enviado con Éxito", Toast.LENGTH_SHORT).show();
    }

    public void paginaInicio(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        Toast.makeText(getApplicationContext(), "Pedido Cancelado", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}