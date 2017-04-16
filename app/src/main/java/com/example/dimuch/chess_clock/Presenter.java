package com.example.dimuch.chess_clock;

/**
 * Created by Dimuch on 16.04.2017.
 */

public class Presenter {

    private MyView myView;

    private int timeOfTheGame;
    private int timePlayer1;
    private int timePlayer2;

    private CountDownTimerPausable countDownTimerPausablePlayer1;
    private CountDownTimerPausable countDownTimerPausablePlayer2;

    private boolean isCountPlayer1;
    private boolean isCountPlayer2;
    private boolean isCountPlayer1Active;
    private boolean isCountPlayer2Active;

    private boolean isPause;

    public Presenter(int timeOfTheGame) {
        this.timeOfTheGame = timeOfTheGame;

        timePlayer1 = timeOfTheGame;
        timePlayer2 = timeOfTheGame;
    }

    public void bind (MyView myView) {
        this.myView = myView;
    }

    public void doSomeThingPlayer1() {
        if (isCountPlayer1Active || isPause) return;

        isCountPlayer1Active = true;
        isCountPlayer2Active = false;

        if (isCountPlayer2) countDownTimerPausablePlayer2.pause();
        if (isCountPlayer1) countDownTimerPausablePlayer1.start();
        else {
            countDownTimerPausablePlayer1 = new CountDownTimerPausable(50000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    myView.changeBtnTextPlayer1(String.valueOf(timePlayer1--));
                }

                @Override
                public void onFinish() {

                }
            }.start();
        }
        isCountPlayer1 = true;
    }

    public void doSomeThingPlayer2() {
        if (isCountPlayer2Active || isPause) return;

        isCountPlayer2Active = true;
        isCountPlayer1Active = false;

        if (isCountPlayer1) countDownTimerPausablePlayer1.pause();
        if (isCountPlayer2) countDownTimerPausablePlayer2.start();
        else {
            countDownTimerPausablePlayer2 = new CountDownTimerPausable(50000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    myView.changeBtnTextPlayer2(String.valueOf(timePlayer2--));
                }

                @Override
                public void onFinish() {

                }
            }.start();
        }
        isCountPlayer2 = true;
    }

    public void pause() {
        if (!isPause && isCountPlayer1Active && isCountPlayer1) {
            countDownTimerPausablePlayer1.pause();
            isPause = true;
            myView.changeBtnTextPause("Unpause");
            return;
        }
        if (!isPause && isCountPlayer2Active && isCountPlayer2) {
            countDownTimerPausablePlayer2.pause();
            isPause = true;
            myView.changeBtnTextPause("Unpause");
            return;
        }
        if (isPause && isCountPlayer1Active) {
            if (isCountPlayer1) {
                countDownTimerPausablePlayer1.start();
            }
            isPause = false;
            myView.changeBtnTextPause("Pause");
            return;
        }
        if (isPause && isCountPlayer2Active) {
            if (isCountPlayer2) {
                countDownTimerPausablePlayer2.start();
            }
            isPause = false;
            myView.changeBtnTextPause("Pause");
            return;
        }
    }

    public void refresh() {
        if (!isPause) {
            pause();
        }
        myView.changeBtnTextPause("Pause");

        timePlayer1 = timeOfTheGame;
        timePlayer2 = timeOfTheGame;

        myView.changeBtnTextPlayer1(String.valueOf(timePlayer1));
        myView.changeBtnTextPlayer2(String.valueOf(timePlayer2));

        isCountPlayer1 = false;
        isCountPlayer2 = false;
        isCountPlayer1Active = false;
        isCountPlayer2Active = false;

        isPause = false;

    }
}
