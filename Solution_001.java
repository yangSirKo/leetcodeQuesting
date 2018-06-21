/**
	给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
	你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

	示例:
	给定 nums = [2, 7, 11, 15], target = 9
	因为 nums[0] + nums[1] = 2 + 7 = 9
	所以返回 [0, 1]
*/
package com.ccyang;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_001 {

	public static void main(String[] args){
		
		int[] nums = new int[]{ 2, 7, 11, 15};
		int	target = 9;
	
		int[] res = twoSum(nums, target);
		System.out.println(Arrays.toString(res));
	
	}
	
	public static int[] twoSum(int[] nums, int target){
	
		int[] res = new int[2];
		if(nums == null || nums.length <= 0){
			return res;
		}
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i< nums.length; i++){
			if(!map.containsKey(target-nums[i])){
				map.put(nums[i],i);
			}else{
				res[i] = map.get(target-nums[i]);
				res[0] = i;
				break;
			}
		}
		return res;
	}
}
