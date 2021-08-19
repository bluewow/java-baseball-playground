package service;

import model.ResultBaseball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameServiceTest {

    BaseballGameService service;

    @BeforeEach
    void init() {
        service = new BaseballGameService();
    }

    @DisplayName("랜덤값이 정상적으로 생성되는지 체크(서로다른 3개의 숫자")
    @RepeatedTest(10)
    void generateRandomKey() {
        //given
        //when
        String s = service.generateRandomKey();
        //then
        assertThat(s.chars().distinct().count()).isEqualTo(3);
    }

    @DisplayName("볼, 스트라이크, 낫싱 체크")
    @ParameterizedTest
    @CsvSource(value = {
            "123:456:0:0:true",
            "456:456:0:3:false",
            "456:468:2:1:false"} ,delimiter = ':')
    void play(String randomKey, String userKey, int ballCnt, int strikeCnt, boolean nothing) {
        //given
        //when
        ResultBaseball resultBaseball = service.play(randomKey, userKey);
        //then
        assertThat(resultBaseball.getBall()).isEqualTo(ballCnt);
        assertThat(resultBaseball.getStrike()).isEqualTo(strikeCnt);
        assertThat(resultBaseball.isNothing()).isEqualTo(nothing);

    }
}