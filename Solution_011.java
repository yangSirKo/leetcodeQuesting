/**
	给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
	画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
	找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

	注意：你不能倾斜容器，n 至少是2。
*/

// 很容易想到暴力解法，求出所有的任意两条线围成的容器的体积。
// 时间复杂度 O(n^2)
class Solution_011 {
    public int maxArea(int[] height) {
        int max = 0;
        int length = height.length;
        
        // 暴力解法
        for(int i = 0; i <= length ; i++){
            for(int j = i+1; j < length ; j++){
                
                if(max < ((j-i)*Math.min(height[i],height[j]))){
                    max = (j-i)*Math.min(height[i],height[j]);
                }
            }
        }
        return max;        
    }
}

// 算法优化
// 因为是计算两条线之间的最大容量，则很容易想到<对撞指针法>求解
// 时间复杂度 O(n)
class Solution_011 {
    public int maxArea(int[] height) {
        
        int max = 0;   // 存储最大容量值
        int l = 0, r = height.length - 1;
                
        while(l < r){
            
            if(height[l] <= height[r]){
                if(max < ((r-l) * height[l]))
                    max = (r-l) * height[l];   // 当前最大容器值
                l ++;
            }else{
                if(max < ((r-l) * height[r]))
                    max = (r-l) * height[r];   // 当前最大容器值
                r --;
            }
        }
        return max;
    }
}

// 算法进一步优化
// 优化思路：每次移动两个垂直线中较低的一个。移动 l 时，移动到比当前height[l]值大时在停止。移动 r 同理。
class Solution_011 {
    public int maxArea(int[] height) {
        
        int max = 0;   // 存储最大容量值
        int l = 0, r = height.length - 1;
                
        while(l < r){
            
            if(height[l] <= height[r]){
                if(max < ((r-l) * height[l]))
                    max = (r-l) * height[l];   // 当前最大容器值
                
                while(height[l] > height[++l] && l < r);  // 让 l 移动到比 height[l] 大的位置上。
                    // l ++;
            }else{
                if(max < ((r-l) * height[r]))
                    max = (r-l) * height[r];   // 当前最大容器值
                
                while(height[r] > height[--r] && l < r);
                    // r --;
            }
        }
        return max;
    }
}