package com.HilarioBazanToM.umbrellacorpz;

public class pedidos {
    private int imgProducto;
    private String NombreProducto;
    private String Descripcion;

    public pedidos(int imgProducto, String NombreProducto, String Descripcion) {
        this.imgProducto = imgProducto;
        this.NombreProducto = NombreProducto;
        this.Descripcion = Descripcion;
    }

    public int getimgProducto(){
        return imgProducto;
    }

    public void setimgProducto(int imgProducto) {
        this.imgProducto = imgProducto;
    }


    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }


    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
}
