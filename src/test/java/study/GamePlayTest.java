package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.reflection.FieldSetter;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class GamePlayTest {

    BaseBall baseBall;

    @BeforeEach
    void init() {
        baseBall = new BaseBall();
    }

    @RepeatedTest(10)
    void 서로다른_임의의수_3개생성_컴퓨터_1에서9까지() {
        baseBall.generateBall();

        assertThat(baseBall.getRandomKey().size()).isEqualTo(3);
        assertThat(baseBall.getRandomKey().stream().distinct().count()).isEqualTo(3);
    }

    @Test
    void 스트라이크_체크_3() throws NoSuchFieldException {
        FieldSetter.setField(baseBall,
                BaseBall.class.getDeclaredField("randomKey"),
                Arrays.asList("1", "2", "3"));

        int strikeCount = baseBall.checkStrike(Arrays.asList("1","2","3"));

        assertThat(strikeCount).isEqualTo(3);
    }

    @Test
    void 스트라이크_체크_2() throws NoSuchFieldException {
        FieldSetter.setField(baseBall,
                BaseBall.class.getDeclaredField("randomKey"),
                Arrays.asList("1", "2", "3"));

        int strikeCount = baseBall.checkStrike(Arrays.asList("1","2","4"));

        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    void 스트라이크_체크_1() throws NoSuchFieldException {
        FieldSetter.setField(baseBall,
                BaseBall.class.getDeclaredField("randomKey"),
                Arrays.asList("1", "2", "3"));

        int strikeCount = baseBall.checkStrike(Arrays.asList("5","2","4"));

        assertThat(strikeCount).isEqualTo(1);
    }


    @Test
    void 볼_체크_3() throws NoSuchFieldException{
        FieldSetter.setField(baseBall,
                BaseBall.class.getDeclaredField("randomKey"),
                Arrays.asList("1", "2", "3"));

        int ballCount = baseBall.checkBall(Arrays.asList("2","3","1"));

        assertThat(ballCount).isEqualTo(3);
    }

    @Test
    void nothing_체크() throws NoSuchFieldException {
        FieldSetter.setField(baseBall,
                BaseBall.class.getDeclaredField("randomKey"),
                Arrays.asList("1", "2", "3"));

        Game game = new Game(baseBall);
        ResultPlay resultPlay = game.play(Arrays.asList("4","5","6"));

        assertThat(resultPlay.getBall()).isEqualTo(0);
        assertThat(resultPlay.getStrike()).isEqualTo(0);
        assertThat(resultPlay.isNothing()).isTrue();
    }

}
