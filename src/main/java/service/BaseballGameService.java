package service;

import model.ResultBaseball;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class BaseballGameService {

    /**
     * 게임 시작전 서로 다른수로 이루어진 3자리수를 생성한다
     * @return 컴퓨터 키
     */
    public String generateRandomKey() {
        int[] ints = {};

        while (ints.length != 3) {
            ints = new Random()
                    .ints(3, 1, 9)
                    .distinct()
                    .toArray();
        }

        String s = Arrays.toString(ints);
        s = s.substring(1, s.length()-1).replace(", ","");
        return s;
    }

    /**
     * 같은 수가 같은 자리에 있으면 스트라이크,
     * 다른 자리에 있으면 볼,
     * 같은 수가 전혀 없으면 포볼 또는 낫싱
     * @param randomKey 컴퓨터 키
     * @param userKey 유저입력 키
     * @return 결과 modle 전달
     */
    public ResultBaseball play(String randomKey, String userKey) {
        ResultBaseball resultBaseball = new ResultBaseball();

        String[] randomKeys = randomKey.split("");
        String[] userKeys = userKey.split("");

        for (int i = 0; i < randomKey.length(); i++) {
            if(randomKeys[i].equals(userKeys[i]))
                resultBaseball.increaseStrikeCount();
            else
                resultBaseball.increaseBallCount();
        }

        return resultBaseball;
    }
}
