/**
 *  给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 */
public class ReverseBits {
    public int reverseBits(int num) {
        int max = 1;
        int insert = 0;
        int cur = 0;
        for(int i = 0;i<32;i++){
            if((num&(1<<i))!=0){
                cur++;
                insert++;

            }else{
                insert = cur+1;
                cur = 0;
            }
            max = Math.max(max,insert);
        }
        return max;



    }

}
