package com.example.habittracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    public static ArrayList<Habit> habitArray;




    public Adapter(Context context, ArrayList<Habit> habitArray) {
        this.context = context;
        this.habitArray = habitArray;

    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        Habit model = habitArray.get(position);
        holder.habit_name.setText(model.getName());


        holder.notDone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                holder.daysComplete.setText(String.valueOf(0));
                habitArray.get(holder.getAdapterPosition()).setCount(habitArray.get(holder.getAdapterPosition()).setCount(0));


            }
        });


        holder.Done.setOnClickListener(new View.OnClickListener() {
            int count;
            @Override
            public void onClick(View view) {
                count = 0;
                habitArray.get(holder.getAdapterPosition()).setCount(habitArray.get(holder.getAdapterPosition()).getCount()+1);
                holder.daysComplete.setText(String.valueOf(habitArray.get(holder.getAdapterPosition()).getCount()));

            }
        });
        holder.daysComplete.setText(String.valueOf(habitArray.get(position).getCount()));



        // Get element from your dataset at this position and replace the
        // contents of the view with that element

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return habitArray.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView habit_name;
        public TextView daysComplete;
        public Button Done;
        public Button notDone;
        public Button Delete;
        View rootView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rootView = itemView;
            int count;

            // Define click listener for the ViewHolder's View
            habit_name = itemView.findViewById(R.id.habit_name);
            daysComplete = itemView.findViewById(R.id.NumComplete);
            Done= itemView.findViewById(R.id.Done);
            notDone= itemView.findViewById(R.id.NotDone);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    habitArray.remove(getAdapterPosition());
                    return false;
                }
            });







        }
    }
}

