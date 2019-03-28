package array;

//import java.util.Stack;Queue.java
public class SolutionBracket {
    public static void main(String[] args) {
        System.out.println( (new SolutionBracket()).isValid("(){}[]"));
        System.out.println( (new SolutionBracket()).isValid("(){}[])"));

    }

//    Stack<Character> stack = new Stack<Character>();
    ArrayStack<Character> stack = new ArrayStack<Character>();
    public boolean isValid(String s){
        for (int i=0;i<s.length();i++){
            char c =s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
               stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }

                char topChar = stack.pop();
                if (c == ')' && topChar !=   '('){
                    return  false;
                }
                if (c == ']' && topChar != '['){
                    return false;
                }
                if (c == '}' && topChar != '{'){
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}