package com.HilarioBazanToM.umbrellacorpz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText etTitulo, etDescripcion, etPrecio, etPoster;
    AppDatabaseDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitulo = findViewById(R.id.etTitulo);
        etDescripcion = findViewById(R.id.etDescripcion);
        etPrecio = findViewById(R.id.etAnho);
        etPoster = findViewById(R.id.etPoster);

        dataSource = new AppDatabaseDataSource(this);
    }

    public void agregar(View view) {
        String titulo, descripcion;
        int anho, poster;

        titulo = etTitulo.getText().toString();
        descripcion = etDescripcion.getText().toString();
        anho = Integer.parseInt(etPrecio.getText().toString());
        poster = Integer.parseInt(etPoster.getText().toString());

        Pedidos pedidos = new Pedidos(titulo, descripcion, anho, poster);
        dataSource.crearPedidos(pedidos);
        Toast.makeText(getApplicationContext(), "Pedido seleccionado", Toast.LENGTH_SHORT).show();
    }

    public void mostrar(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(intent);
    }
}