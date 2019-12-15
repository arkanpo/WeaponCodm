package com.example.weaponcodm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Profile> profiles;

    public MyAdapter(Context c, ArrayList<Profile> list)
    {
        context = c;
        profiles = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.card_view,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.nama.setText(profiles.get(i).getNama());
        myViewHolder.level.setText(profiles.get(i).getLevel());
        Picasso.with(context).load(profiles.get(i).getImage()).into(myViewHolder.image);

        final String getNamaWeapon = profiles.get(i).getNama();
        final String gettype = profiles.get(i).getType();
        final String getlevel = profiles.get(i).getLevel();
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent godetailwisata = new Intent(context,DetailAct.class);
                godetailwisata.putExtra("nama_wisata", getNamaWeapon);
                godetailwisata.putExtra("type", gettype);
                godetailwisata.putExtra("leveling", getlevel);
                context.startActivity(godetailwisata);
            }
        });

    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nama,level,type;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = (TextView) itemView.findViewById(R.id.nama);
            type = (TextView) itemView.findViewById(R.id.type);
            level = (TextView) itemView.findViewById(R.id.level);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
