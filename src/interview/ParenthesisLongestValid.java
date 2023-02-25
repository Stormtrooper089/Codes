package interview;

import java.util.Stack;

public class ParenthesisLongestValid {
    public static void main(String[] args) {
        String question = "()(()()";
        findtheLength(question);
    }

    private static void findtheLength(String question) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> stackInt = new Stack<>();
        stackInt.push(-1);
        int max = 0;
        int curr = 0;
        for(int i = 0 ; i < question.length() ;i++ ){
            if(question.charAt(i) == '('){
                charStack.push('(');
                stackInt.add(i);
            }else{
                if(!charStack.isEmpty() && charStack.peek() == '('){
                    curr = stackInt.pop();
                    max = Math.max(i-stackInt.peek(),max);
                }else{
                    stackInt.push(i);
                }
            }
        }

        System.out.println("the max brackets is " + max);
    }
}

