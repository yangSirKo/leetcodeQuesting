/**
	给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
	不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

	示例 1:
	给定数组 nums = [1,1,2], 
	函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
	你不需要考虑数组中超出新长度后面的元素。
	
	示例 2:
	给定 nums = [0,0,1,1,1,2,2,3,3,4],
	函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
	你不需要考虑数组中超出新长度后面的元素。
*/
class Solution_026 {
    public int removeDuplicates(int[] nums) {
        
        int length = nums.length;
        if(length < 1){
            return 0;
        }
        
        int extra = nums[0] - 1;  // 辅助值
        
        int k = 0;
        // 将要删除的元素标记为 extra
        for(int i=k+1; i<length; i++){
            if(nums[i] == nums[k]){
                nums[i] = extra;
            }else{
                k = i;
            }
        }
        
        // 定位第一次出现 extra的位置。            
        k = -1;
        for(int i=0; i<length; i++){
            if(nums[i] == extra){
                k = i;
                break;
            }        
        }
        // 无重复元素
        if(k == -1){
            return length;
        }
        
        // 将所有的 extra 移动到后面。
        for(int i=k+1; i<length; i++){
            if(nums[i] != extra){
                nums[k] = nums[i];
                k++;
            }
        }
		// [0...k)中的元素无重复， [k...length)中的元素为 extra	
		return k;
    }
}