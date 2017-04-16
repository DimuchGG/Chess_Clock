package com.example.dimuch.chess_clock;

import android.os.CountDownTimer;

/**
 * Created by Dimuch on 16.04.2017.
 */

public class Presenter {

    private View view;
    private int test;

    public Presenter() {
        test = 0;
    }

    public void bind (View view) {
        this.view = view;
    }

    public void doSomeThing() {
        CountDownTimer countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                view.changeBtnText("huy " + test++);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
}
