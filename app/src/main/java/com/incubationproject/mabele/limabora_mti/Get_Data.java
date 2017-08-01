package com.incubationproject.mabele.limabora_mti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Get_Data extends AppCompatActivity {

    private TextView humidity, soil_moisture, temperature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get__data);

        humidity = (TextView)findViewById(R.id.humidity);
        soil_moisture =(TextView)findViewById(R.id.soil_moisture);
        temperature = (TextView)findViewById(R.id.temperature);
        getData();
    }

    public void getData() {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference countRef = database.getReference("/payload/payload_fields");




        countRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.e("payload1", String.valueOf(dataSnapshot));

                String key = String.valueOf(dataSnapshot.getKey());
                if (key.equals("humidity"))
                    humidity.setText(String.valueOf(dataSnapshot.getValue(Boolean.parseBoolean("humidity"))));
                if (key.equals("soilMoisture"))
                    soil_moisture.setText(String.valueOf(dataSnapshot.getValue(Boolean.parseBoolean("soilMoisture"))));
                if (key.equals("temperature"))
                    temperature.setText(String.valueOf(dataSnapshot.getValue(Boolean.parseBoolean("temperature"))));

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.e("payload1", String.valueOf(dataSnapshot));

                String key = String.valueOf(dataSnapshot.getKey());
                if (key.equals("humidity"))
                humidity.setText(String.valueOf(dataSnapshot.getValue(Boolean.parseBoolean("humidity"))));
                if (key.equals("soilMoisture"))
                soil_moisture.setText(String.valueOf(dataSnapshot.getValue(Boolean.parseBoolean("soilMoisture"))));
                if (key.equals("temperature"))
                temperature.setText(String.valueOf(dataSnapshot.getValue(Boolean.parseBoolean("temperature"))));

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}