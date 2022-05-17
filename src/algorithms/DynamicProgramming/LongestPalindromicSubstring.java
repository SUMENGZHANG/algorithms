/**
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 */
public class LongestPalindromicSubstring {

    private static String method(String s){
        // init
        int len = s.length();
        if(len<2) return s;
        boolean [][]dp = new boolean[len][len];
        for(int i = 0;i<len;i++){
            dp[i][i] = true;
        }

        // mark dp array
        int maxLen = 1;
        int startPoint = 0;
        for(int Len = 2;Len<=len;Len++){
            for(int i = 0;i<len;i++){
                int j = Len+i-1;
                if(j>=len) break;
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else{
                    dp[i][j] = false;
                }
                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen = j-i+1;
                    startPoint = i;
                }
            }

        }
        return s.substring(startPoint,startPoint+maxLen);

    }

    public static void main(String[] args) {
        System.out.println(method("ab"));
    }

}
