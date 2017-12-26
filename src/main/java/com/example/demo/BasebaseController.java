package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// controller class 라고 역할을 부여.
import baseball.Baseball;
//public static void main(String[] args) {
//    while(true) {
//        int strike = 0;
//        int ball = 0;
//        String inputValue = inputUserBalls(scanner);
//        ArrayList<Integer> userBalls = Baseball.inputUserBalls(inputValue);
//        for (int i = 0; i < userBalls.size(); i++) {
//            int result = Baseball.calculateBall(computerBalls, userBalls.get(i), i);
//            if (result == 2) {
//                strike++;
//            } else if (result == 1) {
//                ball++;
//            }
//        }
//        System.out.println(String.format("결과 : %d strike, %d ball", strike, ball));
//        
//        if (strike == 3) {
//            System.out.println("게임 종료");
//            break;
//        }
//    }
//    scanner.close();
//}
@Controller
public class BasebaseController {
	// 브라우저에서 웹서버에 요청을 보낼때 get, post 방식.
    ArrayList<Integer> computerBalls = Baseball.generateComputerBalls();
	@GetMapping("/game")
	public String getThreeNums() {
		return "game";
	}
	@PostMapping("/result")
	public String showResult(String numbers, Model model) {
		int strike = 0;
		int ball = 0;
        ArrayList<Integer> userBalls = Baseball.inputUserBalls(numbers);
        for (int i = 0; i < userBalls.size(); i++) {
            int result = Baseball.calculateBall(computerBalls, userBalls.get(i), i);
            if (result == 2) {
                strike++;
            } else if (result == 1) {
                ball++;
            }
        }
        model.addAttribute("strike", strike);
        model.addAttribute("ball", ball);
		return "result";
	}
}
