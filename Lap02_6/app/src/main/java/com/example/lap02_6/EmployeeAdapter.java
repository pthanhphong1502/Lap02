package com.example.lap02_6;

import android.graphics.Color; // Import for Color
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView; // Import for ImageView
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat; // Import for ContextCompat
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private final List<Employee> employeeList;

    public EmployeeAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.textViewFullName.setText(employee.getFullName());

        if (employee.isManager()) {
            holder.imageViewManagerIcon.setVisibility(View.VISIBLE);
            holder.textViewStaffLabel.setVisibility(View.GONE);
        } else {
            holder.imageViewManagerIcon.setVisibility(View.GONE);
            holder.textViewStaffLabel.setVisibility(View.VISIBLE);
        }

        // Alternating background colors
        int backgroundColor = position % 2 == 0 ? Color.BLUE : ContextCompat.getColor(holder.itemView.getContext(), R.color.purple_200); // Using ContextCompat for compatibility
        holder.itemView.setBackgroundColor(backgroundColor);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textViewFullName;
        final ImageView imageViewManagerIcon;
        final TextView textViewStaffLabel;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewFullName = itemView.findViewById(R.id.textViewName); // Make sure this matches your XML
            imageViewManagerIcon = itemView.findViewById(R.id.imageViewManagerIcon); // Make sure this matches your XML
            textViewStaffLabel = itemView.findViewById(R.id.textViewStaffLabel); // Ensure this matches your XML ID
        }
    }
}
