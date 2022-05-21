import java.util.Scanner;

public class lcs {

    public static int LCS(String A, String B) {
        
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
             
                if (A.charAt(i-1) == B.charAt(j-1)){
                    
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } 
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[A.length()][B.length()];
    }

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
 
        String A = s.nextLine();
        String B = s.nextLine();
 
        System.out.println(LCS(A, B));
    }
    
}
