package com.example.incubator3.travniknightrace.activities.propertyActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.incubator3.travniknightrace.R;
import com.example.incubator3.travniknightrace.entities.Property;

import java.util.ArrayList;

public class PropertyActivity extends AppCompatActivity {

    public int[] IMAGE = {R.drawable.stari_grad, R.drawable.hotel4, R.drawable.hotel3};

    ArrayList<Property> propertyArrayList;

    private ArrayList<BeanClassForHomeListView> beanClassArrayList;
    private HomelistViewAdapter homelistViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        ListView listview = findViewById(R.id.homeListView);
        beanClassArrayList = new ArrayList<>();



        propertyArrayList = new ArrayList<>();

        propertyArrayList.add(new Property("Stari Grad", "Travnik", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "+387603009280", "dajsidaj","44.2298100,17.6709485","Besplatan ulaz za takmičare"));
        propertyArrayList.add(new Property("Plava Voda", "Travnik", "bla bla bla", "+387", "dajsidaj","44.230285,17.671545","Besplatan ulaz"));
        propertyArrayList.add(new Property("Muzej", "Travnik", "bla bla bla", "+387", "dajsidaj","44.32,32,34","Besplatan ulaz za takmičare"));
        propertyArrayList.add(new Property("Muzej", "Travnik", "bla bla bla", "+387", "dajsidaj","44.32,32,34","Besplatno"));
        propertyArrayList.add(new Property("Muzej", "Travnik", "bla bla bla", "+387", "dajsidaj","44.32,32,34","Besplatno"));

        for (int i = 0; i < IMAGE.length; i++) {

            propertyArrayList.get(i).setImage(IMAGE[i]);
        }
        homelistViewAdapter = new HomelistViewAdapter(PropertyActivity.this, propertyArrayList);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(),CardActivity.class);
                    intent.putExtra("IME",propertyArrayList.get(position).getName());
                    intent.putExtra("LOKACIJA",propertyArrayList.get(position).getLocation());
                    intent.putExtra("TEXT",propertyArrayList.get(position).getText());
                    intent.putExtra("BROJ",propertyArrayList.get(position).getBroj());
                    intent.putExtra("EMAIL",propertyArrayList.get(position).getEmail());
                    intent.putExtra("LONLAT",propertyArrayList.get(position).getLonLat());
                    intent.putExtra("BESPLATNO",propertyArrayList.get(position).getBesplatno());
                    intent.putExtra("IMAGE",propertyArrayList.get(position).getImage());
                    startActivity(intent);


            }
        });

        listview.setAdapter(homelistViewAdapter);


    }

}
