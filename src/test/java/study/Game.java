package study;

import java.util.List;

public class Game {

    BaseBall baseBall;

    public Game(BaseBall baseBall) {
        this.baseBall = baseBall;
    }

    public void play(List<String> userKey, ResultPlay resultPlay) {
        baseBall.checkStrike(userKey, resultPlay);
        baseBall.checkBall(userKey, resultPlay);
        resultPlay.changeNothing();
    }
}
