package com.blogspot.ahyadroid.infotaktakan.Database.Pulsa;

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
import com.blogspot.ahyadroid.infotaktakan.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Pulsa extends AppCompatActivity {

    private static final String URL_PULSA = "http://192.168.43.196/info_taktakan/Api.php";

    //a list to store all the products
    List<Pulsaa> pulsaaList;

    PulsaAdapter adapter;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulsa);

        pulsaaList= new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadPulsa();

    }

    private void loadPulsa() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PULSA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray pulsas = new JSONArray(response);

                            for (int i=0; i<pulsas.length(); i++){
                                JSONObject pulsaObject= pulsas.getJSONObject(i);

                                int id = pulsaObject.getInt("id");
                                String title = pulsaObject.getString("title");
                                String contact = pulsaObject.getString("contact");
                                String location = pulsaObject.getString("location");
                                String image = pulsaObject.getString("image");

                                Pulsaa pulsa = new Pulsaa(id, title, contact, location, image);
                                pulsaaList.add(pulsa);
                            }

                            adapter = new PulsaAdapter(Pulsa.this, pulsaaList);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    setContentView(R.layout.thereisno);
                    Toast.makeText(Pulsa.this, error.getMessage() , Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
