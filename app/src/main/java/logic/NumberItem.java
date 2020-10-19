package logic;

import android.graphics.Color;

public class NumberItem {
    private final int number;
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
    public int getNumber(){
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
