package logic;

import android.graphics.Color;

/**
 * Utility class for number storing.
 */
public class NumberItem {
    // Number in numerical form.
    private final int number;
    // Color of the number to show.
    private int color;

    /**
     * Class constructor.
     *
     * @param number Numerical form of the number.
     */
    public NumberItem(int number) {
        this.number = number;

        setColor();
    }

    /**
     * Number's color setter.
     */
    private void setColor() {
        if (number % 2 == 0)
            color = Color.RED;
        else
            color = Color.BLUE;
    }

    /**
     * Number's color getter.
     *
     * @return Number's color as integer.
     */
    public int getColor() {
        return color;
    }

    /**
     * Number's numerical form getter.
     *
     * @return Number in numerical form.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Overriden toString method.
     *
     * @return Number's numerical form as a string.
     */
    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
