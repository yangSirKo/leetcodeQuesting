/** 
	给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
	不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
	元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

	示例 1:
	给定 nums = [3,2,2,3], val = 3,
	函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
	你不需要考虑数组中超出新长度后面的元素。

	说明:
	为什么返回数值是整数，但输出的答案是数组呢?
	请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

	你可以想象内部操作如下:
		// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
		int len = removeElement(nums, val);

		// 在函数里修改输入数组对于调用者是可见的。
		// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
		for (int i = 0; i < len; i++) {
			print(nums[i]);
		}
*/


class Solution_27 {
    public int removeElement(int[] nums, int val) {
        
        int k = 0;  // O(1)的空间复杂度，指向最前面的值为val的元素
        
        for(int i=0; i<nums.length; i++){
            
            if(nums[k] != val){
                k++;
            }
            // 此处的删除相当于将所有等于val的元素移到了数组的后面。返回不等于val的元素数。
            // [0...k) 中的值都不等于val， [k...i) 中的值都等于val。  
            if(nums[i] != val && i > k ){
                nums[k] = nums[i];
                nums[i] = val;   // 此处 nums[i] 必须等于 val，因为后面的循环中还可能或用到该值。
                k++;
            }
        }
        return k;  // k 之前的值都不等于val        
    }
} 

// 进一步优化
class Solution_027 {
    public int removeElement(int[] nums, int val) {
        
        int k = -1; 
		// 找出第一次出现 val的位置
        for(int i=0; i<nums.length; i++){
            if(nums[i] == val){
                k = i;
                break;
            }
        }
		// 数组中没有元素 == val
		if(k == -1){
            return nums.length;
        }
        
        for(int i=k+1; i<nums.length; i++){
            
            if(nums[i] != val && i > k){
                nums[k] = nums[i];
                nums[i] = val;
                k++;
            }
        }
        return k;    
    }    
    }
}   