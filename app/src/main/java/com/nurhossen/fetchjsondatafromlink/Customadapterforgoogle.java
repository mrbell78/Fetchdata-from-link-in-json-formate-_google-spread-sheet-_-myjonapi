package com.nurhossen.fetchjsondatafromlink;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Customadapterforgoogle extends RecyclerView.Adapter<Customadapterforgoogle.Customclass> {

    Context context;
    List<googledatamodel> gdata;

    public Customadapterforgoogle(Context context, List<googledatamodel> gdata) {
        this.context = context;
        this.gdata = gdata;
    }

    @NonNull
    @Override
    public Customclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.googleitem,parent,false);

        return new Customclass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Customclass holder, int position) {

        holder.name.setText(gdata.get(position).getName());
        holder.meaning.setText(gdata.get(position).getMeaning_());
        holder.synonims.setText(gdata.get(position).getSynonyms());


    }

    @Override
    public int getItemCount() {
        return gdata.size();
    }

    public class Customclass extends RecyclerView.ViewHolder {

        TextView name,meaning,synonims;
        public Customclass(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.tv_name);
            meaning=itemView.findViewById(R.id.tv_meaning);
            synonims=itemView.findViewById(R.id.tv_synonims);
        }
    }
}
