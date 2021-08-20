package study;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Display {
    public static void InputPrint() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void outputPrint(ResultPlay play) {
        String s = "";

        if(play.getBall() > 0)
            s += play.getBall() + "볼 ";

        if(play.getStrike() > 0)
            s += play.getStrike() + "스트라이크 ";

        if(play.isNothing())
            s += "낫싱";

        System.out.println(s);
    }

    public static boolean terminatePrint(Supplier<Integer> supplier, boolean isFinish) {
        if(!isFinish)
            return false;

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Integer input = supplier.get();
        if(input == 1)
            return false;

        if(input == 2)
            return true;

        return false;
    }

    public static void finish() {
        System.out.println("종료");
    }
}
