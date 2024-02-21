package DynamicProgramming;

public class lc509 {


    /**
     *  O(n*n)
     * @param n
     * @return
     */
    public static int fib(int n) {
       if(n==1||n==2) return 1;
       return fib(n-1)+fib(n-2);
    }

    /**
     *  o(n)
     * @param n
     * @return
     */
    public static int fib2(int n){

        if(n<1) return 0;
        if(n==1||n==2) return 1;
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for(int i =3;i<=n;i++){
            tmp = res;
            res = res+pre;
            pre = tmp;
        }
        return res;

    }
    public static void main(String[] args) {
        System.out.println(fib2(10));

    }
}
