package com.example.cricketscorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Button btnSelect,btn0,btn1,btn2,btn3,btn4,btn5,btn6,btne,btnout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.teams, R.layout.test);
        adapter.setDropDownViewResource(R.layout.test);
        spinner.setAdapter(adapter);



    }
}
