package com.blogspot.ahyadroid.infotaktakan.Database.Bensin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.ahyadroid.infotaktakan.Database.Pulsa.PulsaAdapter;
import com.blogspot.ahyadroid.infotaktakan.Database.Pulsa.Pulsaa;
import com.blogspot.ahyadroid.infotaktakan.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class BensinAdapter extends RecyclerView.Adapter<BensinAdapter.ViewHolder> {

    private Context mCtx;
    private List<Bensinn> bensinList;

    public BensinAdapter(Context mCtx, List<Bensinn> bensinList){
        this.mCtx = mCtx;
        this.bensinList = bensinList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_bensin, null);
        return new BensinAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Bensinn bensinn = bensinList.get(position);

        Glide.with(mCtx)
                .load(bensinn.getImage())
                .into(holder.imageView);
        holder.textViewTitleBensin.setText(bensinn.getTitle());
        holder.textViewShortNoHpBensin.setText(bensinn.getContact());
        holder.textViewLokasiBensin.setText(bensinn.getLocation());
    }

    @Override
    public int getItemCount() {
        return bensinList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitleBensin, textViewShortNoHpBensin, textViewLokasiBensin;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitleBensin = itemView.findViewById(R.id.textViewTitleBensin);
            textViewShortNoHpBensin = itemView.findViewById(R.id.textViewnohpBensin);
            textViewLokasiBensin = itemView.findViewById(R.id.textViewlokasiBensin);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
