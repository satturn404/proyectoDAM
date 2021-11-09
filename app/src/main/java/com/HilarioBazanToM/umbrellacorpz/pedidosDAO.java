package com.HilarioBazanToM.umbrellacorpz;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

    @Dao
    public interface pedidosDAO {
        @Query("SELECT * FROM pedidos")
        List<Pedidos> traerTodo();

        @Insert
        void addPedidos(Pedidos ... pedidos);

        @Delete
        void eliminarPedidos(Pedidos pedidos);

}
