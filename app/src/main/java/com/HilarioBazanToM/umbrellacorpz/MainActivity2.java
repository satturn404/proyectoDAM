package com.HilarioBazanToM.umbrellacorpz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
    }
}