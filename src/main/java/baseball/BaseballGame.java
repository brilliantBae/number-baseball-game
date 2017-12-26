package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseballGame {
    static String inputUserBalls(Scanner scanner) {
        System.out.println("예상하는 3개의 값을 입력하세요.(예. 1 2 3)");
        return scanner.nextLine();
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> computerBalls = Baseball.generateComputerBalls();
        
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int strike = 0;
            int ball = 0;
            String inputValue = inputUserBalls(scanner);
            ArrayList<Integer> userBalls = Baseball.inputUserBalls(inputValue);
            for (int i = 0; i < userBalls.size(); i++) {
                int result = Baseball.calculateBall(computerBalls, userBalls.get(i), i);
                if (result == 2) {
                    strike++;
                } else if (result == 1) {
                    ball++;
                }
            }
            System.out.println(String.format("결과 : %d strike, %d ball", strike, ball));
            
            if (strike == 3) {
                System.out.println("게임 종료");
                break;
            }
        }
        scanner.close();
    }
}