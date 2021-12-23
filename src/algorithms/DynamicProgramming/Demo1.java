/**
 * 0-1背包问题
 *
 */

public class Demo1 {
    private int maxWeight = Integer.MIN_VALUE;
    // 物品重量
    private  int[] weight = {2,2,4,6,3};
    // 物品数量
    private int n = 5;
    // 背包承受的最大重量
    private int w = 18;

    // 优化点之一：添加回忆录
    private boolean[][] mem = new boolean[weight.length][w];




    /**
     * 回溯的方法解决问题
     * @param i
     * @param curWeight
     */
    public void find(int i, int curWeight){
        if(curWeight==w||i==n){
            if(curWeight>maxWeight) maxWeight = curWeight;
            return;
        }

        // 备忘录去剪枝
        if(mem[i][curWeight]) return;
        mem[i][curWeight] = true;
        find(i+1,curWeight);
        if(curWeight+weight[i]<=w){
            find(i+1,curWeight+weight[i]);
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.find(0,0);
        System.out.println(demo1.maxWeight);
    }








}
