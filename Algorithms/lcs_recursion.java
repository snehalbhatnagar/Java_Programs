import java.util.Scanner;

public class lcs_recursion {
    public static String LCS_r(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
    
        if (m < 0 || n < 0)
            return "";
    
        if (a.charAt(m)==b.charAt(n)) {
            return LCS_r(a.substring(0, m), b.substring(0, n)) + a.substring(m);
        } 
        else {
            String s1 = LCS_r(a, b.substring(0, n));
            String s2 = LCS_r(a.substring(0, m), b);
            if (s1.length() > s2.length()) {
                return s1;
            } else {
                return s2;
            }
        }
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter string 1: ");
        String str1 = s.nextLine();
        System.out.println("Enter string 2: ");
        String str2 = s.nextLine();

        System.out.println(LCS_r(str1, str2));
    }
    
}
