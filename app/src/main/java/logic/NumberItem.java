package logic;

import android.graphics.Color;

public class NumberItem {
    private int number;
    private int color;

    public NumberItem(int number){
        this.number = number;

        setColor();
    }

    private void setColor(){
        if(number % 2 == 0)
            color = Color.RED;
        else
            color = Color.BLUE;
    }

    public int getColor(){
        return color;
    }
}
