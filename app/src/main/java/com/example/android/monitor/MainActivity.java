package com.example.android.monitor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    EditText name = (EditText) findViewById(R.id.name);
    EditText branch = (EditText)findViewById(R.id.branch);
    EditText semester = (EditText)findViewById(R.id.semester);

    SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void monitor(View view) {
        Intent i = new Intent(this, MonitorActivity.class);
        startActivity(i);
    }

    public void summary(View view) {
        Intent i = new Intent(this, SummaryActivity.class);
        startActivity(i);
    }

    public void profile(View view) {
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    public void settings(View view) {
        Intent i = new Intent(this, MonitorActivity.class);
        startActivity(i);
    }
}
