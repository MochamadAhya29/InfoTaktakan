package com.blogspot.ahyadroid.infotaktakan.Database.Bengkel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.ahyadroid.infotaktakan.Database.Bensin.BensinAdapter;
import com.blogspot.ahyadroid.infotaktakan.Database.Bensin.Bensinn;
import com.blogspot.ahyadroid.infotaktakan.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class BengkelAdapter extends RecyclerView.Adapter<BengkelAdapter.ViewHolder> {

    private Context mCtx;
    private List<Bengkell> bengkellList;

    public BengkelAdapter(Context mCtx, List<Bengkell> bengkellList){
        this.mCtx = mCtx;
        this.bengkellList = bengkellList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_bengkel, null);
        return new BengkelAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        Bengkell bengkell = bengkellList.get(position);

        Glide.with(mCtx)
                .load(bengkell.getImage())
                .into(holder.imageView);
        holder.textViewTitleBengkel.setText(bengkell.getTitle());
        holder.textViewShortNoHpBengkel.setText(bengkell.getContact());
        holder.textViewLokasiBengkel.setText(bengkell.getLocation());
    }

    @Override
    public int getItemCount() {
        return bengkellList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitleBengkel, textViewShortNoHpBengkel, textViewLokasiBengkel;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitleBengkel = itemView.findViewById(R.id.textViewTitleBengkel);
            textViewShortNoHpBengkel = itemView.findViewById(R.id.textViewnohpBengkel);
            textViewLokasiBengkel = itemView.findViewById(R.id.textViewlokasiBengkel);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
