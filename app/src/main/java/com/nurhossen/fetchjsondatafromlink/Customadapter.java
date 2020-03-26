package com.nurhossen.fetchjsondatafromlink;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Customadapter extends RecyclerView.Adapter<Customadapter.customclass> {
    Context context;
    List<Datamodel> data;

    public Customadapter(Context context, List<Datamodel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public customclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.itemview,parent,false);
        return new customclass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull customclass holder, int position) {

        holder.name.setText(data.get(position).getName());
        holder.pass.setText(data.get(position).getPassword());
        holder.contract.setText(data.get(position).getContatct());
        holder.country.setText(data.get(position).getCountry());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class customclass extends RecyclerView.ViewHolder {

        TextView name,pass,contract,country;
        public customclass(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.tv_name);
            pass=itemView.findViewById(R.id.tv_passt);
            contract=itemView.findViewById(R.id.tv_contract);
            country=itemView.findViewById(R.id.tv_country);
        }
    }
}
