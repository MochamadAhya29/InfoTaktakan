package com.blogspot.ahyadroid.infotaktakan.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.blogspot.ahyadroid.infotaktakan.Database.Bengkel.Bengkel;
import com.blogspot.ahyadroid.infotaktakan.Database.Bensin.Bensin;
import com.blogspot.ahyadroid.infotaktakan.Database.Pulsa.Pulsa;
import com.blogspot.ahyadroid.infotaktakan.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.text.DateFormat;
import java.util.Calendar;

public class HomeFragment extends Fragment {


    ImageView pulsa, spbu, bengkel;
    private int[] images = new int[] {
            R.drawable.banten1, R.drawable.nasisumsum, R.drawable.banten2, R.drawable.rabeg, R.drawable.satebandeng, R.drawable.banten3, R.drawable.banten4
    };



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);


        CarouselView carouselView = root.findViewById(R.id.corousel);
        carouselView.setPageCount(images.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(images[position]);
            }
        });

        pulsa = (ImageView) root.findViewById(R.id.pulsa);
        spbu = (ImageView) root.findViewById(R.id.spbu);
        bengkel = (ImageView) root.findViewById(R.id.bengkel);


        pulsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Pulsa.class));
            }
        });
        spbu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Bensin.class));
            }
        });
        bengkel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Bengkel.class));
            }
        });

        // TIME
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView textViewLocation = root.findViewById(R.id.txtlocation);
        TextView textViewDate = root.findViewById(R.id.txtdate);
        textViewDate.setText(currentDate);

        return root;
    }


}