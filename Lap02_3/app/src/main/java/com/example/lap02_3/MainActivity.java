package com.example.lap02_3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;
import com.example.lap02_3.Employee;
import com.example.lap02_3.EmployeeFullTime;
import com.example.lap02_3.EmployeeParttime;

public class MainActivity extends AppCompatActivity {

    // Assuming you have declared these variables
    private ArrayList<Employee> employees;
    private ArrayAdapter<Employee> adapter;
    private EditText etId;
    private EditText etName;
    private RadioGroup rgType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_management);

        // Initialize UI elements
        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        rgType = findViewById(R.id.rgType);

        // Initialize your employees list and adapter here
        employees = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employees);

        // Assuming you have a ListView with the id listViewEmployees
        ListView listView = findViewById(R.id.listViewEmployees);
        listView.setAdapter(adapter);
    }

    // Method to add new employee
    public void addNewEmployee(View view) {
        // Retrieve checked Radio Button ID
        int radId = rgType.getCheckedRadioButtonId();
        String id = etId.getText().toString();
        String name = etName.getText().toString();

        // Validate input
        if (id.isEmpty() || name.isEmpty()) {
            Toast.makeText(this, "ID and name cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        Employee employee;
        if (radId == R.id.radio_full_time) {
            // Create FullTime instance with example salary
            double salary = 500.0; // Replace this with actual salary input from user
            employee = new EmployeeFullTime(id, name, salary);
        } else {
            // Create PartTime instance with example hourly rate and hours
            double hourlyRate = 20.0; // Replace this with actual hourly rate input from user
            int hoursWorked = 8; // Replace this with actual hours worked input from user
            employee = new EmployeeParttime(id, name, hourlyRate, hoursWorked);
        }

        // Add employee to the list and update the UI
        employees.add(employee);
        adapter.notifyDataSetChanged();
    }
}

