/**
	给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
	不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

	示例 1:
	给定 nums = [1,1,1,2,2,3],
	函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
	你不需要考虑数组中超出新长度后面的元素。

	示例 2:
	给定 nums = [0,0,1,1,1,1,2,3,3],
	函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
	你不需要考虑数组中超出新长度后面的元素。
*/
class Solution_080 {
    public int removeDuplicates(int[] nums) {
        
        int length = nums.length;
        if(length < 1){
            return 0;
        }
        int extra = nums[0] - 1;  // 标记需要清理的元素
        
        // 1. 将要删除的元素标记出来
        int k = 0;
        for(int i=1; i<length-1; i++){    // length-1 防止越界
            if(nums[k] == nums[k+1] && nums[k] == nums[i+1]){
                nums[i+1] = extra;
            }else{
                k = i;
            }
        }
        k = -1;
        for(int i=0; i<length; i++){
            if(nums[i] == extra){
                k = i;
                break;
            }
        }
        if(k == -1){
            return length;
        }
        // 2. 删除或者移动到数组最后面
        for(int i=k+1; i<length; i++){
            if(nums[i] != extra){
                nums[k] = nums[i];
                k++;
            }
        }            
        return k;
    }
}