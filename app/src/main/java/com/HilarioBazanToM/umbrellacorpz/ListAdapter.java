package com.HilarioBazanToM.umbrellacorpz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Pedidos> misDatos;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListAdapter(List<Pedidos> misDatos, Context context) {
        this.misDatos = misDatos;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.contenido, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.juntarData(misDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return misDatos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView titulo, descripcion;
        ImageView imagen;
        Button btnEliminar, btnVer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tvTitulo);
            descripcion = itemView.findViewById(R.id.tvDescripcion);
            imagen = itemView.findViewById(R.id.imagen);
            btnEliminar = itemView.findViewById(R.id.btEliminar);
            btnVer = itemView.findViewById(R.id.btVer);
        }

        public void juntarData(Pedidos item){
            String new_titulo = item.getTitulo()+ "("+item.getAnho()+")";
            titulo.setText(new_titulo);
            descripcion.setText(item.getDescripcion());
            item.setPoster(R.drawable.iconic1);
            imagen.setImageResource(item.getPoster());
            btnEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppDatabaseDataSource dataSource = new AppDatabaseDataSource(view.getContext());
                    dataSource.eliminarPedidos(item);
                    Intent intent = new Intent(view.getContext(), MainActivity4.class);
                    view.getContext().startActivity(intent);
                }
            });
            btnVer.setOnClickListener(new  View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), MainActivity3.class);
                    intent.putExtra("id", item.getId());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

}
