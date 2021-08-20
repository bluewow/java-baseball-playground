package study;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BaseballGamePlay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BaseBall baseBall = new BaseBall();
        Game game = new Game(baseBall);
        ResultPlay resultPlay = null;

        game.init();

        while(true) {
            Display.InputPrint();

            resultPlay = game.play(userInputs(scanner));

            Display.outputPrint(resultPlay);

            if(resultPlay.isNotFinish())
                continue;

            if(Display.terminatePrint(scanner::nextInt))
                break;
        }
        Display.finish();
    }

    private static List<String> userInputs(Scanner scanner) {
        return Arrays.asList(scanner.next().split(""));
    }
}
