package com.example.habittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreateHabit extends AppCompatActivity {


    EditText habit;
    Button button;
    SharedPreferences sp;
    String habitSt;
    private static Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_habit);
        Log.d("CreateHabit", "Starting CreateHabit Activity");
        habit = findViewById(R.id.editTextHabitName);
        button = findViewById(R.id.button);
        sp = getSharedPreferences("UserHabits", Context.MODE_PRIVATE);

        ArrayList<Habit> habitArray = new ArrayList<Habit>();
        Map<String, ?> loadHabitMap = sp.getAll();

        for (Object i : loadHabitMap.values()) {
            String iString = i.toString();
            Log.d("CreateHabit", iString);
            Habit iHabit = gson.fromJson(iString, Habit.class);
            Log.d("CreateHabit", "Habit Loaded from JSON");
            Log.d("loadHabitMap", "Start Date (Epoch): " + iHabit.getStartDate() +
                    ", Readable Date: " + iHabit.getReadableStartDate());
            habitArray.add(iHabit);
        }

        for (Habit habit : habitArray) {
            String testName = habit.getName();
          Log.d("habitHashMap Line", "Name is: " + testName);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateHabit.this, MainActivity.class);
                startActivity(intent);

                String storedHabitJsonString = sp.getString("UserHabit", (new JSONObject()).toString());

                habitSt = habit.getText().toString();
                TimeTracker startDate = new TimeTracker();
                String notificationTime = null;
                LocalDate date = LocalDate.now();
                Habit newHabit = new Habit(habitSt, (int) date.toEpochDay(), notificationTime);
                Log.d("newHabit", "name: " + newHabit.getName() + ", startDate: " +
                        newHabit.getStartDate());


                SharedPreferences.Editor editor = sp.edit();

                if (sp.contains(newHabit.getName())) {
                    Toast.makeText(CreateHabit.this,
                            "Habit already exists. Please choose a different name.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String habitJson = gson.toJson(newHabit);
                    Toast.makeText(CreateHabit.this,habitJson,Toast.LENGTH_SHORT).show();
                    editor.putString(newHabit.getName(), habitJson);
                    editor.commit();
                }

                finish();


                Toast.makeText(CreateHabit.this,"habit added", Toast.LENGTH_SHORT).show();

            }
        });
}}