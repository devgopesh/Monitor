package com.example.android.monitor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    EditText nameET = (EditText) findViewById(R.id.name);
    EditText branchET = (EditText)findViewById(R.id.branch);
    EditText semesterET = (EditText)findViewById(R.id.semester);
    EditText sDateET = (EditText)findViewById(R.id.s_date);
    EditText sMonthET = (EditText)findViewById(R.id.s_month);
    EditText sYearET = (EditText)findViewById(R.id.s_year);
    EditText eDateET = (EditText)findViewById(R.id.e_date);
    EditText eMonthET = (EditText)findViewById(R.id.e_month);
    EditText eYearET = (EditText)findViewById(R.id.e_year);

    SharedPreferences profileData = getSharedPreferences("ProfileData", MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        data();
    }

    public void save(View view) {
        int error = 0;

        SharedPreferences.Editor editor = profileData.edit();
        editor.putString("name", nameET.getText().toString());
        editor.putString("branch", branchET.getText().toString());
        editor.putString("semester", semesterET.getText().toString());

        try {
            editor.putInt("s_date", Integer.parseInt(sDateET.getText().toString()));
            editor.putInt("s_month", Integer.parseInt(sMonthET.getText().toString()));
            editor.putInt("s_year", Integer.parseInt(sYearET.getText().toString()));
            editor.putInt("e_date", Integer.parseInt(eDateET.getText().toString()));
            editor.putInt("e_month", Integer.parseInt(eMonthET.getText().toString()));
            editor.putInt("e_year", Integer.parseInt(eYearET.getText().toString()));
        }
        catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show();
            error = 1;
        }

        if(error != 1) {
            editor.commit();

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }

    private void data() {
        nameET.setText(profileData.getString("name", ""));
        branchET.setText(profileData.getString("branch", ""));
        semesterET.setText(profileData.getString("semester", ""));
        sDateET.setText(profileData.getInt("s_date", 04));
        sMonthET.setText(profileData.getInt("s_month", 02));
        sYearET.setText(profileData.getInt("s_year", 2017));
        eDateET.setText(profileData.getInt("e_date", 05));
        eMonthET.setText(profileData.getInt("e_month", 02));
        eYearET.setText(profileData.getInt("e_year", 2017));
    }
}
