package com;

public class ButtonAnim extends Thread {
    MainClickerMiddleButton button;
    static boolean isRunning = false;


    ButtonAnim(MainClickerMiddleButton button) {
        this.button = button;
    }


    public void run() {
        if (!isRunning) {
            isRunning = true;

            isRunning = false;
        }


    }

}
