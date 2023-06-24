public class StairClimberBasic {
    public static int countDistinctWays(int n) {
        
        if(n<0){
            return 1;
        }
        int ans = countDistinctWays(n-1) + countDistinctWays(n-2);
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Distinct ways to climb the stair: " + countDistinctWays(n)); // ans 8
    }
}
