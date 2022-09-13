import java.util.Stack;

public class javaQuestion2 {

    static boolean checkEvenBracket(String inputString) {
        
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < inputString.length(); i++) {
            char character = inputString.charAt(i);

            //If an opening bracket is found, push it to the stack.
            switch(character) {
                case '{':
                case '[':
                case '(':
                    stack.push(character);
                    break;
                //When a closing bracket is found, if the element at the top of the stack is not
                // the corresponding opening bracket, return false. Or if the stack is empty also 
                // return false, as this means a closing bracket was found before an opening one. 
                case '}':
                    if ( stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if ( stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;               
            }
        }
        return stack.isEmpty();
    }

    //test
    public static void main(String[] args) {
        System.out.println(checkEvenBracket("[]{})(&")); // false
        System.out.println(checkEvenBracket("java [Test ()34]")); // true
    }
}

