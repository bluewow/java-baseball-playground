package study;

import java.util.List;

public class Game {

    BaseBall baseBall;

    public Game(BaseBall baseBall) {
        this.baseBall = baseBall;
    }

    public ResultPlay play(List<String> userKey) {
        int strikeCount = baseBall.checkStrike(userKey);
        int ballCount = baseBall.checkBall(userKey);

        return new ResultPlay(ballCount, strikeCount);
    }

    public void init() {
        baseBall.generateBall();
    }
}
