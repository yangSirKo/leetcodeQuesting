/**
	假设你正在爬楼梯。需要 n 步你才能到达楼顶。
	每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
	注意：给定 n 是一个正整数。

	示例 1：
	输入： 2       输出： 2
	解释： 有两种方法可以爬到楼顶。
	1.  1 步 + 1 步
	2.  2 步
 */
public class Solution_070 {
	
	// 记忆化搜索的辅助空间
	public static int[] memo2;
	
	public static void main(String[] args) {
    	
		int n = 5;
		// 动规
		int num = climbStairs(n);
    	System.out.println(num);

    	// 记忆化搜索
    	memo2 = new int[n+1];
    	int num2 = climbStairs2(n);
    	System.out.println(num2);
	}
	
    // 动态规划 - 自上而下的解决问题
    public static int climbStairs(int n) {
        // memo 数组用来记录 n个台阶的爬行方法数        
        int[] memo = new int[n+1];
        
        memo[0] = 1;
        memo[1] = 1;
        for(int i=2; i<=n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }
    
    // 记忆化搜索算法 - 自上而下的解决问题
    public static int climbStairs2(int n){
    	
    	if(n < 2){
    		return 1;
    	}
    	if(memo2[n] == 0)
    		memo2[n] = climbStairs2(n-1) + climbStairs2(n-2);
    	return memo2[n];
    }
}