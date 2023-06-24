import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

      

        for (char c : s.toCharArray()) {
          if(ch == '(' || ch == '{' || ch == '['){
             stack.push(ch);
          } else {
            if(!stack.empty()) {
                  char top = stack.top();
                  if( (ch == ')' && top == '(') || 
                     ( ch == '}' && top == '{') || 
                     (ch == ']' && top == '[') ) {
                      s.pop();
                  }
                 else
                     return false; 
             }
             else
                 return false;
          }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str1 = "()[]{}";
        String str2 = "([)]";
        String str3 = "{[()]}";

        System.out.println(str1 + " is valid: " + isValid(str1));
        System.out.println(str2 + " is valid: " + isValid(str2));
        System.out.println(str3 + " is valid: " + isValid(str3));
    }
}
