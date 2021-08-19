import model.ResultBaseball;
import service.BaseballGameService;
import view.Display;

import java.util.Scanner;

public class BaseballGameControl {

    BaseballGameService game = new BaseballGameService();

    void play() {
        //초기화
        String randomKey = game.generateRandomKey();
        ResultBaseball result = null;

        do {
            //입력화면
            Display.InputPrint();

            //입력
            Scanner scanner = new Scanner(System.in);
            String userKey = scanner.next();
            result = game.play(randomKey, userKey);

            //출력
            Display.outputPrint(result);

        //게임 종료
        } while (!Display.isTerminate(result));
    }


}
