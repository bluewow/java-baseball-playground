package view;

import model.ResultBaseball;

import java.util.Scanner;

public class Display {

    public static void InputPrint() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void outputPrint(ResultBaseball model) {
        String s = "";

        if(model.getBall() > 0)
            s += model.getBall() + "볼 ";

        if(model.getStrike() > 0) 
            s += model.getStrike() + "스트라이크 ";

        if(model.isNothing())
            s += "낫싱";

        System.out.println(s);
    }

    public static boolean isTerminate(ResultBaseball result) {
        if(result.getStrike() != 3)
            return false;

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextInt() == 1)
            return false;

        return true;
    }
}
