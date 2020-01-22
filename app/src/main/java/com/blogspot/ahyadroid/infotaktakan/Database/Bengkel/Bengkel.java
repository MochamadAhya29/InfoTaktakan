package com.blogspot.ahyadroid.infotaktakan.Database.Bengkel;

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
import com.blogspot.ahyadroid.infotaktakan.Database.Bensin.Bensin;
import com.blogspot.ahyadroid.infotaktakan.Database.Bensin.BensinAdapter;
import com.blogspot.ahyadroid.infotaktakan.Database.Bensin.Bensinn;
import com.blogspot.ahyadroid.infotaktakan.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Bengkel extends AppCompatActivity {

    private static final String URL_BENGKEL = "http://192.168.43.196/info_taktakan/Apibengkel.php";

    //a list to store all the products
    List<Bengkell> bengkellist;

    BengkelAdapter adapter;

    //the recyclerview
    RecyclerView recyclerViewBengkel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bengkel);

        bengkellist= new ArrayList<>();
        recyclerViewBengkel = (RecyclerView) findViewById(R.id.recyclerViewBengkel);
        recyclerViewBengkel.setHasFixedSize(true);
        recyclerViewBengkel.setLayoutManager(new LinearLayoutManager(this));

        loadBengkel();
    }

    private void loadBengkel() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_BENGKEL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray bengkels = new JSONArray(response);

                            for (int i=0; i<bengkels.length(); i++){
                                JSONObject bengkelsObject= bengkels.getJSONObject(i);

                                int id = bengkelsObject.getInt("id");
                                String title = bengkelsObject.getString("title");
                                String contact = bengkelsObject.getString("contact");
                                String location = bengkelsObject.getString("location");
                                String image = bengkelsObject.getString("image");

                                Bengkell bengke = new Bengkell(id, title, contact, location, image);
                                bengkellist.add(bengke);
                            }

                            adapter = new BengkelAdapter(Bengkel.this, bengkellist);
                            recyclerViewBengkel.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        setContentView(R.layout.thereisno);
                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
