import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BaseBallInput {
    public StringBuffer createScanner() {
        System.out.println("세 자리 수를 입력해주세요");

        Scanner scanner = new Scanner(System.in);
        StringBuffer inputs = new StringBuffer(scanner.next().replace(" ", ""));//공백 있는 경우 제거
        return inputs;
    }

    public boolean validation(StringBuffer inputs, int MAX_LENGTH, List<Integer> inputNumbers){
        if(inputs.length()!=MAX_LENGTH){
            System.out.println("세 자리 수만 입력 가능합니다.");
            return false;
        }
        try{
            Set<Integer> set = new HashSet();
            for(int i=0;i<MAX_LENGTH;i++) {
                inputNumbers.add(Integer.parseInt(String.valueOf(inputs.charAt(i))));
            }

        }catch(Exception e){
            if(e.getClass().equals(NumberFormatException.class)){
                System.out.println("숫자만 입력 가능합니다.");
                return false;
            }
        }
        return true;
    }

}
