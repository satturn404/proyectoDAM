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

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        AppDatabaseDataSource dataSource = new AppDatabaseDataSource(this);
        List<Pedidos> pedido = dataSource.traerPedidos();

        ListAdapter adapter = new ListAdapter(pedido, this);
        RecyclerView miRecycler = findViewById(R.id.myRecycler);
        miRecycler.setLayoutManager(new LinearLayoutManager(this));
        miRecycler.setAdapter(adapter);

        Toolbar toolbarmain2 = findViewById(R.id.main2_toolbar);
        setSupportActionBar(toolbarmain2);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
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
                Intent intentMAS = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intentMAS);
                return true;
            case R.id.item2:
                Intent intentActualizar = new Intent(getApplicationContext(),MainActivity2.class);
                Toast.makeText(getApplicationContext(), "ACTUALIZADO", Toast.LENGTH_SHORT).show();
                startActivity(intentActualizar);
                return true;
            case R.id.item3:
                Intent intentclose = new Intent(getApplicationContext(),login.class);
                Toast.makeText(getApplicationContext(), "Cerraste sesion", Toast.LENGTH_SHORT).show();
                startActivity(intentclose);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}