package com.example.sudoku_android_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TableLayout table = findViewById(R.id.table);

        CharSequence[] nombres = {"X","1","2","3","4","5","6","7","8","9"};
        for(int i = 0; i <= 9; i++){
            TableRow row = new TableRow(this);
            for(int j = 0; j <= 9; j++) {
                Spinner spinner = new Spinner(this);
                spinner.setTag(R.id.fila,i);
                spinner.setTag(R.id.col,j);
                spinner.setTag("bug init");
                spinner.setBackground(null);
                spinner.setPadding(5, 5, 5, 5);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int k, long l) {
                        int fila = (int) adapterView.getTag(R.id.fila);
                        int col = (int) adapterView.getTag(R.id.col);
                        if( spinner.getTag().equals("bug init")){
                            spinner.setTag("hecho");
                            return;
                        }
                        Toast.makeText(MainActivity.this, "fila: "+ fila +" columna: " + col + " nuevo valor: ", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
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