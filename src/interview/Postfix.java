package interview;

import java.util.ArrayList;
import java.util.Stack;

public class Postfix {
    public static void main(String[] args) {
        String exp = "123+*8-";
        evaluateTheExpression(exp);
    }

    private static void evaluateTheExpression(String exp) {
        Stack<Character> operands = new Stack<>();
        Stack<Integer> entities = new Stack<>();
        char[] charArray = exp.toCharArray();

        ArrayList<Character> modelOperators = new ArrayList<>(){};
        modelOperators.add('*');
        modelOperators.add('+');
        modelOperators.add('-');
        modelOperators.add('/');

        for(int i =0 ; i < charArray.length;i++){
            if(modelOperators.contains(charArray[i])){
                operands.add(charArray[i]);
                int a = entities.pop();
                int b = entities.pop();
                int result = doOperation(a,b,operands.pop());

                entities.push(result);
            }else{
                int num = Integer.parseInt(String.valueOf(charArray[i]));
                entities.add(num);
            }
        }


        System.out.println("the result of theoperation is  " +  entities.pop());

    }

    private static int doOperation(int b, int a, Character operator) {
        int result = 0 ;
        switch (operator) {
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                result = a/b;
                break;
        }
        System.out.println("the two operands are " +  a + "  " +operator.toString() +  "  " + b + "  "   + result);
        return result;
    }
}
