import util.BaseballGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int MAX_LENGTH=3;
    public static void main(String[] args) {
        boolean againFlag = true;


        while(againFlag) {
            boolean endFlag = false;
            BaseBallInput baseBallInput = new BaseBallInput();
            //정답 얻기
            int[] answers = BaseballGenerator.answerGenerator(MAX_LENGTH);
            System.out.printf("answers = %d %d %d", answers[0], answers[1],answers[2]);
            while(!endFlag) {
                boolean inputFlag = false;
                List<Integer> inputNumbers = new ArrayList<>(); //validation 함수에서 값을 넣어주기 위해 참조배열 선언

                while (!inputFlag) {
                    //세 자리 수 입력 받기
                    StringBuffer inputs = baseBallInput.createScanner();

                    //입력 값 검증
                    inputFlag = baseBallInput.validation(inputs, MAX_LENGTH, inputNumbers);
                }

                //판별하기
                int countBall = countBall(answers, inputNumbers);
                int countStrike = countStrike(answers, inputNumbers);

                if (countStrike == MAX_LENGTH) {
                    System.out.println("3 스트라이크!!");
                    endFlag = true;
                    break;
                }
                if(countStrike+countBall==0){
                    System.out.println("낫싱");
                }else{
                    System.out.printf("%d 스트라이크, %d 볼",countStrike,(countBall-countStrike));
                }
            }
            againFlag = playAgain();
        }
    }

    public static int countBall(int[] answers,List<Integer> inputNumbers){
        int result = 0;
        for(int i=0;i<answers.length;i++){
            if(inputNumbers.contains(answers[i])){
                result+=1;
            }
        }
        return result;
    }

    public static int countStrike(int[] answers,List<Integer>inputNumbers){
        int result=0;
        for(int i=0;i<answers.length;i++){
            if(answers[i] == inputNumbers.get(i)){
                result+=1;
            }
        }
        return result;
    }
    public static boolean playAgain(){
        System.out.println("게임을 다시 하시겠습니까?");
        System.out.println("1: 경기 재시작");
        System.out.println("2: 경기 종료");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();

        if(answer.equals("1")){
            return true;
        }
        return false;
    }
}