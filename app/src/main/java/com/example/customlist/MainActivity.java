package com.example.customlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListTravelAdapter adapter;
    ListView lv;

    Button btnSave;
    Button btnCancel;
    EditText pltTravel;
    ImageView imgEdit;
    ImageView imgRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "Travel")
                .allowMainThreadQueries()
                .build();

        TravelDao dao = db.travelDao();
        List<Travel> list= dao.getAll();
        lv = findViewById(R.id.lv);
        adapter= new ListTravelAdapter(this, R.layout.item, (ArrayList<Travel>) list);
        lv.setAdapter(adapter);
        btnSave= findViewById(R.id.btnAdd);
        btnCancel= findViewById(R.id.btnCancel);
        pltTravel= findViewById(R.id.tplTravle);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String travel= pltTravel.getText().toString();
                Travel tv= new Travel(travel);
                dao.addTravel(tv);
                lv.setAdapter(new ListTravelAdapter(MainActivity.this,  R.layout.item,(ArrayList<Travel>) dao.getAll()));
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                imgEdit= findViewById(R.id.edit);
                imgRemove= findViewById(R.id.imgRemove);
                imgEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        List<Travel> l= dao.getAll();
                        Travel t = l.get(position);
                        if(pltTravel.getText().toString()!=null){
                            t.setTravel(pltTravel.getText().toString());
                            dao.update(t);
                        }

                        lv.setAdapter(new ListTravelAdapter(MainActivity.this,  R.layout.item,(ArrayList<Travel>) dao.getAll()));
                    }
                });
                imgRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        List<Travel> l= dao.getAll();
                        Travel t = l.get(position);
                        dao.delete(t);
                        lv.setAdapter(new ListTravelAdapter(MainActivity.this,  R.layout.item,(ArrayList<Travel>) dao.getAll()));
                        pltTravel.setText("");
                    }
                });
            }
        });



    }
}