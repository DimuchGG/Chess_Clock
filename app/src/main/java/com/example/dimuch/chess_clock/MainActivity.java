package com.example.dimuch.chess_clock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements com.example.dimuch.chess_clock.View {

    private Button bTime1;
    private Button bTime2;
    private Button bPause;
    private Button bRefresh;
    private Button bSettings;

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter();
        presenter.bind(this);

        findElements();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        bTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Time 1", Toast.LENGTH_SHORT).show();
                presenter.doSomeThing();
            }
        });

        bTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Time 2", Toast.LENGTH_SHORT).show();
            }
        });

        bPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pause", Toast.LENGTH_SHORT).show();
            }
        });

        bRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
            }
        });

        bSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void findElements() {
        bTime1 = (Button) findViewById(R.id.time1);
        bTime2 = (Button) findViewById(R.id.time2);
        bPause = (Button) findViewById(R.id.pause);
        bRefresh = (Button) findViewById(R.id.refresh);
        bSettings = (Button) findViewById(R.id.settings);
    }

    @Override
    public void changeBtnText(String str) {
        bTime1.setText(str);
    }
}
