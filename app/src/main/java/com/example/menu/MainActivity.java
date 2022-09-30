package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textVievResults;
    private Button buttonExit, buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        String seged = getSharedPreferenceData();
        textVievResults.setText(seged);

        buttonNext.setOnClickListener(this);
        buttonExit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonNext:
                Intent intent  = new Intent(MainActivity.this, MasodikActivity.class);
                startActivity(intent);
                // fontos, backstack miatt
                finish();
                break;
            case R.id.buttonExit:
                finish();

                break;
        }
    }

    private String getSharedPreferenceData() {
        SharedPreferences sharedPreferences =
                getSharedPreferences("Data", Context.MODE_PRIVATE);
        return sharedPreferences.getString("nev", "nincs ilyen adat");
    }

    private void init() {
        buttonExit = findViewById(R.id.buttonExit);
        buttonNext = findViewById(R.id.buttonNext);
        textVievResults = findViewById(R.id.TextViewResults);
    }
}