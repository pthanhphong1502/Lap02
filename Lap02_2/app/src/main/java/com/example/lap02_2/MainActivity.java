package com.example.lap02_2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button buttonAdd;
    ListView listView;
    TextView selectedItemTextView;

    ArrayList<String> dataList;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        buttonAdd = findViewById(R.id.buttonAdd);
        listView = findViewById(R.id.listView);
        selectedItemTextView = findViewById(R.id.selectedItemTextView);

        dataList = new ArrayList<>();
        adapter = new CustomAdapter(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString().trim();
                if (!data.isEmpty()) {
                    dataList.add(data);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItemTextView.setText("Position: " + position + ", Value: " + dataList.get(position));
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dataList.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}

