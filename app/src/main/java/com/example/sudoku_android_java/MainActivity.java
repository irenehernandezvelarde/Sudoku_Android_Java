package com.example.sudoku_android_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TableLayout table = findViewById(R.id.table);

        CharSequence[] nombres = {"0","1","2","3","4","5","6","7","8","9"};
        for(int i = 0; i <= 9; i++){
            TableRow row = new TableRow(this);
            for(int j = 0; j <= 9; j++) {
                Spinner spinner = new Spinner(this);
                spinner.setBackground(null);
                spinner.setPadding(5, 5, 5, 5);
                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                        android.R.layout.simple_spinner_item, nombres);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                row.addView(spinner);
            }
            table.addView(row);
        }

    }
}