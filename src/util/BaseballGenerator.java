package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaseballGenerator {
    public static int[] answerGenerator(int length){
        int answers[] = new int[length]; //Array List vs Linked List
        Set<Integer> set = new HashSet();
        Random random = new Random();
        int i=0;

        //중복 숫자 안됨!
        while (i<answers.length){
            int randomNum = random.nextInt(9)+1;
            if(!set.contains(randomNum)) {
                answers[i] = randomNum;
                set.add(randomNum);
                i++;
            }
        }

        return answers;
    }
}
