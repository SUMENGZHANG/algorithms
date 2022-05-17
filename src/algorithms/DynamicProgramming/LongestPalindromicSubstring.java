/**
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 */
public class LongestPalindromicSubstring {

    /**
     * 动态规划  O(n**2)
     * @param s
     * @return
     */
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


    /**
     * 中心扩散方法
     * 时间复杂度 O(n**2)
     * 空间复杂度 O(1)
     * @param s
     * @return
     */
    public static String method02(String s){
          if(s==null||s.length()<1) return "";
          int start = 0,end = 0;
          for(int i = 0;i<s.length();i++){
              int len1 = expandAroundCenter(s,i,i);
              int len2 = expandAroundCenter(s,i,i+1);
              int len =  Math.max(len1,len2);
              if(len>end-start){
                  start = i-(len-1)/2;
                  end = i+len/2;
              }

          }
        return s.substring(start,end+1);
    }

    public static int expandAroundCenter(String s, int left, int right){
        int len  = s.length();
        while(left>=0&&right<len&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
    public static void main(String[] args) {
        System.out.println(method("ab"));
    }

}
