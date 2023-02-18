package interview;

import java.util.ArrayList;

public class DifferentWaysForParenthesis {
    public static void main(String[] args) {
        String expression = "2*3-4*5";

        ArrayList<Character> operator = new ArrayList<>();
        operator.add('*');
        operator.add('-');
        operator.add('+');
        findTheNumberOfWays(expression,0,operator);
    }

    private static void findTheNumberOfWays(String expression,int start,ArrayList<Character> operator) {
        if (start >= expression.length()) {
            System.out.println("expression at this moment is " + expression);
            return;
        }
        String l2 = null;
        String l1 = null;
        if (operator.contains(expression.charAt(start))) {
            l1 = expression.substring(0, start);
            l2 = expression.substring(start+1, expression.length());
        }
        if (!operator.contains(expression.charAt(start))) {
            findTheNumberOfWays(expression,start+1, operator);
        }
        if(l2 == null || l1 ==null){
            return;
        }
        findTheNumberOfWays(l1 + expression.charAt(start) +  "(" + l2 + ")", start+1, operator);
        findTheNumberOfWays("(" + l1   +expression.charAt(start)+ l2 + ")", start+1, operator);
    }
}
