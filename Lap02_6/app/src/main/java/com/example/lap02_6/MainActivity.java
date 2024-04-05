package com.example.lap02_6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;
    private List<Employee> employeeList;
    private EditText editTextFullName;
    private CheckBox checkboxIsManager;
    private Button buttonAdd;
    private EditText editTextID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the RecyclerView and its components
        recyclerView = findViewById(R.id.recyclerViewEmployees);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        employeeList = new ArrayList<>();
        adapter = new EmployeeAdapter(employeeList);
        recyclerView.setAdapter(adapter);

        // Initialize the input fields and the "Add" button
        editTextID = findViewById(R.id.editTextID);
        editTextFullName = findViewById(R.id.editTextFullName); // Replace with the actual ID of your EditText for full name
        checkboxIsManager = findViewById(R.id.checkboxIsManager); // Replace with the actual ID of your CheckBox
        buttonAdd = findViewById(R.id.buttonAdd); // Replace with the actual ID of your button

        // Set up the "Add" button click listener
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextID.getText().toString().trim(); // Assuming editTextID is your EditText for the ID
                String fullName = editTextFullName.getText().toString().trim();
                boolean isManager = checkboxIsManager.isChecked();

                if (!fullName.isEmpty() && !id.isEmpty()) {
                    Employee newEmployee = new Employee(fullName, isManager, id);
                    employeeList.add(newEmployee);
                    adapter.notifyDataSetChanged();

                    // Clear all the input fields after adding the new employee
                    editTextID.setText(""); // Clear the ID field
                    editTextFullName.setText("");
                    checkboxIsManager.setChecked(false);
                } else {
                    // Provide feedback to the user that the fields are required
                    if (fullName.isEmpty()) {
                        editTextFullName.setError("Full name is required");
                    }
                    if (id.isEmpty()) {
                        editTextID.setError("ID is required"); // Assuming editTextID is your EditText for the ID
                    }
                }
            }
        });

    }
}
