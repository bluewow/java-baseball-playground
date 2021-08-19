package model;

import jdk.nashorn.internal.objects.annotations.Getter;

public class ResultBaseball {
    int ball;
    int strike;
    boolean nothing;

    public ResultBaseball() {
        ball = 0;
        strike = 0;
        nothing = false;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isNothing() {
        return nothing;
    }

    public void increaseBallCount() {
        ball++;
        if(ball == 3) {
            ball = 0;
            nothing = true;
        }
    }

    public void increaseStrikeCount() {
        strike++;
    }
}
