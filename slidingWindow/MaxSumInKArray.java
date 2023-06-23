import java.util.ArrayList;

public class MaxSumInKArray {

    public static int findMaxSum(int[] arr, int k) {

        
        int i = 0; // Start of the window
        int j = 0; // End of the window
        
         while (j < arr.length) {
            sum = sum + arr[j];

            // Slide the window
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                max = Math.max(max, sum); // Update the maximum sum
                sum = sum - arr[i]; // Remove the first element from the sum for the next window
                i++;
                j++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, -3, 4, -1, -2, 1, 5, -3};
        int k = 3;

        int maxSum = findMaxSum(arr, k);
        System.out.println("Maximum sum of elements in a window of K size: " + maxSum);
    }
}
