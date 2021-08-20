package study;

public class ResultPlay {
    int ball;
    int strike;
    boolean nothing;

    public ResultPlay(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
        if(strike == 0 && ball == 0)
            nothing = true;
        else
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

    public boolean isFinish() {
        if(strike == 3)
            return true;

        return false;
    }
}

