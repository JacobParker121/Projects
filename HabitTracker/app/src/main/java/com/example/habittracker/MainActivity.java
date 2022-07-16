package com.example.habittracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.habittracker.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fabAddHabit;
    Button buttonAddHabit;
    private Adapter adapter;
    private RecyclerView RV;
    Button deleteButton;
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RV = findViewById(R.id.idRV);
        addListenerOnButton();


        TextView t1;
        loadData();



        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserHabits", Context.MODE_PRIVATE);
        String habit = sp.getString("habit","");




    }
    private void loadData() {
        /*// method to load arraylist from shared prefs
        // initializing our shared prefs with name as
        // shared preferences.
        Log.d("loadData","Starting loadData()"); */

        SharedPreferences sharedPreferences = getSharedPreferences("UserHabits", MODE_PRIVATE);
        Log.d("loadData", "Got Shared Preferences");

        // creating a variable for gson.
        Gson gson = new Gson();
        Log.d("loadData", "Created Gson object");


        final ArrayList<Habit>[] habitArray = new ArrayList[]{new ArrayList<>()};
        Map<String, ?> loadHabitMap = sharedPreferences.getAll();

        for (Object i : loadHabitMap.values()) {
            String iString = i.toString();
            Log.d("loadData", iString);
            Habit iHabit = gson.fromJson(iString, Habit.class);
            Log.d("loadData", "Habit Loaded from JSON");
            Log.d("loadHabitMap", "Start Date (Epoch): " + iHabit.getStartDate() +
                    ", Readable Date: " + iHabit.getReadableStartDate());
            habitArray[0].add(iHabit);
        }
        Log.d("loadData", habitArray[0].toString());

        // below line is to get to string present from our
        // shared prefs if not present setting it as null.
        // String json = sharedPreferences.getString("UserHabits", null);
        // Log.d("loadData", "Loaded JSON string");
        // Log.d("loadData", "json:" + json);
        // below line is to get the type of our array list.
        Type type = new TypeToken<ArrayList<Habit>>() {}.getType();
        Log.d("loadData", "Created TypeToken object");
        // in below line we are getting data from gson
        // and saving it to our array list
        // habitArray = gson.fromJson(json, type);
        Log.d("loadData", "Created habitArray");
        // checking below if the array list is empty or not


        adapter = new Adapter(MainActivity.this, habitArray[0]);

        // adding layout manager to our recycler view.
        LinearLayoutManager manager = new LinearLayoutManager(this);
        RV.setHasFixedSize(false);

        // setting layout manager to our recycler view.
        RV.setLayoutManager(manager);

        // setting adapter to our recycler view.
        RV.setAdapter(adapter);




        if (habitArray[0] == null) {
            // if the array list is empty
            // creating a new array list.
            habitArray[0] = new ArrayList<>();
        }
    }




    public void addListenerOnButton() {
        buttonAddHabit = (Button) findViewById(R.id.buttonAddHabit);
        buttonAddHabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CreateHabit.class);
                startActivity(i);
            }
        });
    }

    }

