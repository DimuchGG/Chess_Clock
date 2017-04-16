package com.example.dimuch.chess_clock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyView {

    @BindView(R.id.bTime1) Button bTime1;
    @BindView(R.id.bTime2) Button bTime2;
    @BindView(R.id.bPause) Button bPause;
    @BindView(R.id.bRefresh) Button bRefresh;
    @BindView(R.id.bSettings) Button bSettings;

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new Presenter();
        presenter.bind(this);

        setOnClickListeners();
    }

    private void setOnClickListeners() {
        bTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Time 1", Toast.LENGTH_SHORT).show();
                presenter.doSomeThingPlayer1();
            }
        });

        bTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Time 2", Toast.LENGTH_SHORT).show();
                presenter.doSomeThingPlayer2();
            }
        });

        bPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pause", Toast.LENGTH_SHORT).show();
                presenter.pause();
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

    @Override
    public void changeBtnTextPlayer1(String str) {
        bTime1.setText(str);
    }

    @Override
    public void changeBtnTextPlayer2(String str) {
        bTime2.setText(str);
    }

    @Override
    public void changeBtnTextPause(String str) {
        bPause.setText(str);
    }
}
