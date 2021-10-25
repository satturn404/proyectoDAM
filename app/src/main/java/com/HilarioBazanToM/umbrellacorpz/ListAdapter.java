package com.HilarioBazanToM.umbrellacorpz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<pedidos> stock;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListAdapter(List<pedidos> misDatos, Context context) {
        this.stock = misDatos;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.contenido, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.juntarData(stock.get(position));
    }

    @Override
    public int getItemCount() {
        return stock.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView NombreProducto, descripcion;
        ImageView imgProducto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProducto = itemView.findViewById(R.id.imgProducto);
            NombreProducto = itemView.findViewById(R.id.NombreProducto);
            descripcion = itemView.findViewById(R.id.Descripcion);
        }

        public void juntarData(pedidos item){
            imgProducto.setImageResource(item.getimgProducto());
            NombreProducto.setText(item.getNombreProducto());
            descripcion.setText(item.getDescripcion());
        }
    }

}
