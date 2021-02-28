package com.smd.loglevel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button debugButton = findViewById(R.id.buttonDebug);
        final Button infoButton = findViewById(R.id.buttonInfo);
        final Button warnButton = findViewById(R.id.buttonWarn);
        final Button errorButton = findViewById(R.id.buttonError);

        final EditText inputEditText = findViewById(R.id.editTextInput);

        debugButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("LogLevel: debug", inputEditText.getText().toString());
            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("LogLevel: info", inputEditText.getText().toString());
            }
        });

        warnButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.w("LogLevel: warn", inputEditText.getText().toString());
            }
        });

        errorButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e("LogLevel: error", inputEditText.getText().toString());
            }
        });

    }
}