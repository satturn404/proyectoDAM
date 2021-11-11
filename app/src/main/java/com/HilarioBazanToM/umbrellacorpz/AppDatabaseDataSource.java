package com.HilarioBazanToM.umbrellacorpz;

import android.content.Context;

import java.util.List;

public class AppDatabaseDataSource {

    private final pedidosDAO PedidosDAO;

    public AppDatabaseDataSource(Context context) {
        AppDatabase baseDatos = AppDatabase.getInstance(context);
        PedidosDAO = baseDatos.pedid2DAO();
    }

    public void crearPedidos(Pedidos pedidos){
        PedidosDAO.addPedidos(pedidos);
    }

    public List<Pedidos> traerPedidos(){
        return PedidosDAO.traerTodo();
    }

    public void eliminarPedidos(Pedidos pedidos){
        PedidosDAO.eliminarPedidos(pedidos);
    }
}
