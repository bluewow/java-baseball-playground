package study;

import java.util.*;
import java.util.stream.Collectors;

public class BaseBall {

    private List<String> randomKey;

    public void generateBall() {
        int[] ints = {};
        while(ints.length != 3) {
            ints = new Random().ints(3, 1, 9)
                    .distinct()
                    .toArray();
        }

        randomKey = Arrays.stream(ints).mapToObj(i->Integer.toString(i)).collect(Collectors.toList());
    }

    public List<String> getRandomKey() {

        return randomKey;
    }

    public void checkStrike(List<String> userKey, ResultPlay resultPlay) {
        for (int i = 0; i < randomKey.size(); i++) {
            if(randomKey.get(i) == userKey.get(i))
                resultPlay.increaseStrikeCount();
        }
    }

    public void checkBall(List<String> userKey, ResultPlay resultPlay) {
        for (int i = 0; i < randomKey.size(); i++) {
            for(int j = 0; j < randomKey.size(); j++) {
                if(i == j)
                    continue;

                if(randomKey.get(i) == userKey.get(j))
                    resultPlay.increaseBallCount();
            }

        }
    }

}
