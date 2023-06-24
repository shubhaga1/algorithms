import java.util.Stack;

public class DeleteMiddleElementInStack {
    public static void deleteMiddleElement(Stack<Integer> stack, int count, int size) {
        if (count == stack.size() / 2) {
          stack.pop();  
          return;
        }

        int num = stack.top(); // saving the value in recursive call
        stack.pop();
        deleteMiddleElement(stack, count+1, size);
        stack.push(num); // when recursion returns before completing function, it will add all evicted numbers.
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Original Stack: " + stack);

        deleteMiddleElement(stack);

        System.out.println("Stack after deleting middle element: " + stack);
    }
}
