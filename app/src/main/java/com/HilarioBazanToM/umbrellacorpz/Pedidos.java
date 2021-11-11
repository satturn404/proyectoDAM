package com.HilarioBazanToM.umbrellacorpz;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Pedidos {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String titulo;
    private String descripcion;

    @ColumnInfo(name = "año")
    private int precio;

    private int poster;

    public Pedidos(String titulo, String descripcion, int precio, int poster) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.poster = poster;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "pedido{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", poster=" + poster +
                '}';
    }
}