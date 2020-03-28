package com.example.drag_task;

import android.os.Bundle;
import android.view.ViewTreeObserver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Trip> tripList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tripList = new ArrayList<>();


        String status = "failed";
        for (int i = 0; i < 33; i++) {
            tripList.add(
                    new Trip(
                            "20 March 2019, 10:00 AM",
                            "JF092319",
                            "Silver Jubilee Tower",
                            "St. Mary's Basilica, Bengaluru",
                            "2199.43",
                            "successfull")
            );
            tripList.add(
                    new Trip(
                            "20 March 2019, 10:00 AM",
                            "JF092319",
                            "Silver Jubilee Tower",
                            "St. Mary's Basilica, Bengaluru",
                            "2199.43",
                            "pending")
            );
            tripList.add(
                    new Trip(
                            "20 March 2019, 10:00 AM",
                            "JF092319",
                            "Silver Jubilee Tower",
                            "St. Mary's Basilica, Bengaluru",
                            "2199.43",
                            "failed")
            );

        }


        TripAdapter adapter = new TripAdapter(this, tripList);
        recyclerView.setAdapter(adapter);
    }
}
