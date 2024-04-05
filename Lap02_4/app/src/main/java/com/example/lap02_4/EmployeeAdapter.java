package com.example.lap02_4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import androidx.core.content.ContextCompat;

public class EmployeeAdapter extends ArrayAdapter<Employee> {
    private Activity context;
    private List<Employee> employees;

    public EmployeeAdapter(Activity context, List<Employee> employees) {
        super(context, R.layout.item_employee, employees);
        this.context = context;
        this.employees = employees;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_employee, parent, false);
        }

        // Get the data item for this position
        Employee employee = getItem(position);

        // Lookup view for data population
        TextView tvFullName = convertView.findViewById(R.id.item_employee_tv_fullname);
        TextView tvPosition = convertView.findViewById(R.id.item_employee_tv_position);
        ImageView ivManager = convertView.findViewById(R.id.item_employee_iv_manager);

        // Populate the data into the template view using the data object
        tvFullName.setText(employee.getFullName());

        if (employee.isManager()) {
            // Show the manager icon and hide the "Staff" label
            ivManager.setVisibility(View.VISIBLE);
            tvPosition.setVisibility(View.GONE);
            // Set the background color for managers
            convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.light_blue));
        } else {
            // Hide the manager icon and show the "Staff" label
            ivManager.setVisibility(View.GONE);
            tvPosition.setVisibility(View.VISIBLE);
            tvPosition.setText(getContext().getString(R.string.staff));
            // Set the background color for staff
            convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.purple_200));
        }

        // Return the completed view to render on screen
        return convertView;
    }
}
