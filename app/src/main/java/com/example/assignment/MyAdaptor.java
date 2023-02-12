package com.example.assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdaptor  extends RecyclerView.Adapter<MyAdaptor.MyViewHolder> {
    private Context context;
    private ArrayList ID_id, Name_id, Sabak_id, Sabki_id;

    public MyAdaptor(Context context,ArrayList roll_id, ArrayList name_id, ArrayList sabak_id, ArrayList sabki_id) {
        this.context = context;

        ID_id=roll_id;
        Name_id = name_id;
        Sabak_id = sabak_id;
        Sabki_id = sabki_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.ID_id.setText(String.valueOf(ID_id.get(position)));
        holder.Name_id.setText(String.valueOf(Name_id.get(position)));
        holder.Sabak_id.setText(String.valueOf(Sabak_id.get(position)));
        holder.Sabki_id.setText(String.valueOf(Sabki_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return Name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Name_id, Sabak_id, Sabki_id, ID_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ID_id=itemView.findViewById(R.id.textRollNumber);
            Name_id=itemView.findViewById(R.id.textName);
            Sabak_id=itemView.findViewById(R.id.textSabak);
            Sabki_id= itemView.findViewById(R.id.textSabki);
        }


    }
}
