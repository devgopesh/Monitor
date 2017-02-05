package com.example.android.monitor;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    MainActivity home = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void submit(View view) {
        SharedPreferences.Editor editor = home.sharedPreferences.edit();
        editor.putString("name", home.name.getText().toString());
        editor.putString("branch", home.branch.getText().toString());
        editor.putString("semester", home.semester.getText().toString());
        editor.commit();
    }
}
