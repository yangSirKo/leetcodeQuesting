/**
	给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

	示例:
	输入: [0,1,0,3,12]
	输出: [1,3,12,0,0]

	说明:
	必须在原数组上操作，不能拷贝额外的数组。
	尽量减少操作次数。
*/
class Solution {
    public void moveZeroes(int[] nums) {
        
        int zeroFlag = 0;   // 数组最前面的 0 的索引
        
       for(int i=0; i<nums.length; i++){
            // 移动到第一次出现 0 的地方
            if(nums[zeroFlag] != 0){
                zeroFlag ++;
            }
			// 当前非零元素如果在 zeroFlag之后，则交换位置。  此时[zeroFlag...i)间的元素都为 0。 
            if(nums[i] != 0 && i > zeroFlag){
                int temp = nums[i];
                nums[i] = nums[zeroFlag];
                nums[zeroFlag] = temp;
                zeroFlag++;
            }
        }
    }
}