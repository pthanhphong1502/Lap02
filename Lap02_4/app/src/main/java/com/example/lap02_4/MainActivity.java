package com.example.lap02_4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private ListView listView;
    private EmployeeAdapter adapter;
    private List<Employee> employeeList;
    private EditText editTextID;
    private EditText editTextFullName;
    private CheckBox checkboxIsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewEmployees);
        editTextID = findViewById(R.id.editTextID);
        editTextFullName = findViewById(R.id.editTextFullName);
        checkboxIsManager = findViewById(R.id.checkboxIsManager);

        employeeList = new ArrayList<>();
        adapter = new EmployeeAdapter(this, employeeList);
        listView.setAdapter(adapter);

        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextID.getText().toString();
                String fullName = editTextFullName.getText().toString();
                boolean isManager = checkboxIsManager.isChecked();

                // Validate inputs here
                if (!id.isEmpty() && !fullName.isEmpty()) {
                    Employee newEmployee = new Employee(id, fullName, isManager);
                    employeeList.add(newEmployee);
                    adapter.notifyDataSetChanged();

                    // Clear the input fields for the next entry
                    editTextID.setText("");
                    editTextFullName.setText("");
                    checkboxIsManager.setChecked(false);
                } else {
                    Toast.makeText(MainActivity.this, "ID and Full Name cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
