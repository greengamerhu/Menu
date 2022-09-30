package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MasodikActivity extends AppCompatActivity {
    private Button buttonSave;
    private EditText editTextInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masodik);
        init();
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String seged = editTextInput.getText().toString();
                if (seged.equals("")) {
                    editTextInput.setError("Muszáj kitölteni");
                }
                else {
                    sharedPreferenceSave(seged);
                    //felugroablak
                    Toast.makeText(MasodikActivity.this, "Mentés Sikeres volt", Toast.LENGTH_LONG).show();
                    //Visszalépés az első activity-re
                    Intent intent = new Intent(MasodikActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    private void sharedPreferenceSave(String seged) {
        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nev", seged);
        editor.apply();
    }

    private void init()  {
        buttonSave = findViewById(R.id.buttonSave);
        editTextInput = findViewById(R.id.editTextInput);
    }

}