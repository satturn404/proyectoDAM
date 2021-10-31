package com.HilarioBazanToM.umbrellacorpz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.inicio_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        List<pedidos> zpedidos = new ArrayList();
        zpedidos.add(new pedidos(R.drawable.play," PLAY 4","entrega en Huancayo"));
        zpedidos.add(new pedidos(R.drawable.silla,"Silla gamer 360","entrega en Tacna"));
        zpedidos.add(new pedidos(R.drawable.tv,"Tv 45","entrega en Cusco"));

        ListAdapter adapter = new ListAdapter(zpedidos, this);
        RecyclerView ListaPedidos = findViewById(R.id.Recicler_view_lista);
        ListaPedidos.setLayoutManager(new LinearLayoutManager(this));
        ListaPedidos.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){

            case R.id.item1:
                Intent intentCompras = new Intent(getApplicationContext(),listaDeCompras.class);
                startActivity(intentCompras);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}