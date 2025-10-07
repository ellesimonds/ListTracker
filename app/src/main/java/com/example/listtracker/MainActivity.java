package com.example.listtracker;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText taskInput;
    private EditText nameInput;
    private Button submitButton;
    private ListView listOfTasks;

    private ArrayList<String> taskList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        //link UI elements to Java
        taskInput = findViewById(R.id.taskInput);
        nameInput = findViewById(R.id.nameInput);
        submitButton = findViewById(R.id.submitButton);
        listOfTasks = findViewById(R.id.listOfTasks);

        //create an ArrayList and an adapter to display the list
        taskList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        listOfTasks.setAdapter(adapter);

        //handle the button click
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = taskInput.getText().toString().trim();
                String name = nameInput.getText().toString().trim();

                if (!task.isEmpty() && !name.isEmpty()) {
                    String entry = name + " – " + task;
                    taskList.add(entry);
                    adapter.notifyDataSetChanged(); // refresh list

                    //clear inputs
                    taskInput.setText("");
                    nameInput.setText("");
                }
            }
        });
    }
}
