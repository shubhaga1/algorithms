import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElement {
    public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(n);

         for(int i=n-1; i>=0 ; i--) {
                int curr = arr[i];
                while(s.top() >= curr)
                {
                    s.pop();
                }
                //ans is top of stack
                ans[i] = s.top();
                s.push(curr);
            }
            return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(3);
        arr.add(1);
        arr.add(4);
        arr.add(6);
        int n = arr.size();

        ArrayList<Integer> result = nextSmallerElement(arr, n);
        System.out.println("Next Smaller Elements:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
