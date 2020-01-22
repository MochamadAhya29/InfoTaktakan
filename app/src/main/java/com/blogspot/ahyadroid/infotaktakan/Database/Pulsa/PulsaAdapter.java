package com.blogspot.ahyadroid.infotaktakan.Database.Pulsa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.ahyadroid.infotaktakan.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class PulsaAdapter extends RecyclerView.Adapter<PulsaAdapter.ViewHolder> {

    private Context mCtx;
    private List<Pulsaa> pulsaaList;

    public PulsaAdapter(Context mCtx, List<Pulsaa> pulsaaList){
        this.mCtx = mCtx;
        this.pulsaaList = pulsaaList;
    }


    @NonNull
    @Override
    public PulsaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_pulsa, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PulsaAdapter.ViewHolder holder, int position) {

        Pulsaa pulsaa = pulsaaList.get(position);

        Glide.with(mCtx)
                .load(pulsaa.getImage())
                .into(holder.imageView);
        holder.textViewTitle.setText(pulsaa.getTitle());
        holder.textViewShortNoHp.setText(pulsaa.getContact());
        holder.textViewLokasi.setText(pulsaa.getLocation());


    }

    @Override
    public int getItemCount() {
        return pulsaaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortNoHp, textViewLokasi;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortNoHp = itemView.findViewById(R.id.textViewnohp);
            textViewLokasi = itemView.findViewById(R.id.textViewlokasi);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
