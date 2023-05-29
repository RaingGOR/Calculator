import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Logic {
    //count Char in string
    private static int count(String str, char ch) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                counter++;
            }
        }

        return counter;
    }

    public int doOperation(String operation, int firstNum, int secondNum) {
        switch (operation) {
            case "-" -> {
                return firstNum - secondNum;
            }
            case "+" -> {
                return firstNum + secondNum;
            }
            case ":" -> {
                return firstNum / secondNum;
            }
            case "*" -> {
                return firstNum * secondNum;
            }
            default -> {
                return -1;
            }
        }
    }

//    //+ - : * logic
//    static int operationLogic(String operation) {
//        switch (operation) {
//            case "*" -> {
//                int position = Arrays.asList(example).indexOf("*");
//                return parseInt(example[position - 1]) * parseInt(example[position + 1]);
//            }
//            case ":" -> {
//                int position = Arrays.asList(example).indexOf(":");
//                return parseInt(example[position - 1]) / parseInt(example[position + 1]);
//            }
//            case "+" -> {
//                int position = Arrays.asList(example).indexOf("+");
//                return parseInt(example[position - 1]) + parseInt(example[position + 1]);
//            }
//            case "-" -> {
//                int position = Arrays.asList(example).indexOf("-");
//                return parseInt(example[position - 1]) - parseInt(example[position + 1]);
//            }
//        }
//
//        return 0;
//    }


//    static String bufferTextLogic = MainFrame.bufferText;
//    public static String[] example = bufferTextLogic.split(" ");


}
