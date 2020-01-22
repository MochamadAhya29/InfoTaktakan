package com.blogspot.ahyadroid.infotaktakan.Database.Bensin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.blogspot.ahyadroid.infotaktakan.Database.Pulsa.Pulsa;
import com.blogspot.ahyadroid.infotaktakan.Database.Pulsa.PulsaAdapter;
import com.blogspot.ahyadroid.infotaktakan.Database.Pulsa.Pulsaa;
import com.blogspot.ahyadroid.infotaktakan.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Bensin extends AppCompatActivity {


    private static final String URL_BENSIN = "http://192.168.43.196/info_taktakan/Apibensin.php";

    //a list to store all the products
    List<Bensinn> bensinnList;

    BensinAdapter adapter;

    //the recyclerview
    RecyclerView recyclerViewBensin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bensin);

        bensinnList= new ArrayList<>();
        recyclerViewBensin = (RecyclerView) findViewById(R.id.recyclerViewBensin);
        recyclerViewBensin.setHasFixedSize(true);
        recyclerViewBensin.setLayoutManager(new LinearLayoutManager(this));

        loadBensin();
    }

    private void loadBensin() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_BENSIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray bensins = new JSONArray(response);

                            for (int i=0; i<bensins.length(); i++){
                                JSONObject bensinObject= bensins.getJSONObject(i);

                                int id = bensinObject.getInt("id");
                                String title = bensinObject.getString("title");
                                String contact = bensinObject.getString("contact");
                                String location = bensinObject.getString("location");
                                String image = bensinObject.getString("image");

                                Bensinn bensinn = new Bensinn(id, title, contact, location, image);
                                bensinnList.add(bensinn);
                            }

                            adapter = new BensinAdapter(Bensin.this, bensinnList);
                            recyclerViewBensin.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        setContentView(R.layout.thereisno);
                        Toast.makeText(Bensin.this, error.getMessage() , Toast.LENGTH_LONG).show();
                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
