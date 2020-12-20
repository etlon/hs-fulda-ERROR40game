package com;

public class ButtonAnim extends Thread
{
    MainClickerMiddleButton button;
    ButtonAnim(MainClickerMiddleButton button)
    {
        this.button = button;
    }


    public void run()
    {

            button.anim();
    }

}
