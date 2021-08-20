package study;

public class ResultPlay {
    int ball;
    int strike;
    boolean nothing;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isNothing() {
        return nothing;
    }

    public void increaseStrikeCount() {
        strike++;
    }

    public void increaseBallCount() {
        ball++;
    }

    public void changeNothing() {
        if(nothingPredicate())
            nothing = true;
    }

    private boolean nothingPredicate() {
        return ball == 0 && strike == 0;
    }
}
