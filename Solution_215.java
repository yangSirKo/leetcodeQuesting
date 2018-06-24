/**
	在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

	示例 1:
	输入: [3,2,1,5,6,4] 和 k = 2
	输出: 5

	示例 2:
	输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
	输出: 4

	说明:
	你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
*/

class Solution_215 {
    public int findKthLargest(int[] nums, int k) {
        
        int n = nums.length;
        // 第K大的元素 = 第 nums.length-k+1-1 个元素。 即第 k 大元素对应在数组中的位置
        k = n - k;
          
        // 快速排序，将K处的元素排到对应的位置上, 其他位置的元素不一定是有序的。
        quickSort(nums, 0, n-1, k);   // nums[0...n-1]
        return nums[k];
    }

    // 对 arr[l...r] 进行操作
    private static void quickSort(int[] arr, int l, int r, int k){
        
        if(l>r)
            return ;
        
        int p = partition(arr, l, r, k);
        
        if( k == p )   // p 位置元素就是要找的值
            return ;
        else if( k < p )
            quickSort(arr, l, p-1, k);
        else
            quickSort(arr, p+1, r, k);
    }

    private static int partition(int[] arr, int l, int r, int k){

        // 随机选择值和arr[l]交换。避免数组近乎有序时这种特殊情况
        Random random = new Random();
        swap(arr, l, random.nextInt(r-l+1)+l);
        
        int v = arr[l];
        int j = l;
        
        // arr[l+1...j] < v  &&  arr[j+1...i) > v 。 小于V的元素往前换，大于等于不用换。
        for(int i=l; i<=r; i++){
            if(arr[i] < v){
                swap(arr, ++j, i);
            }
        }
        swap(arr, j , l);
        return j;
    }
    
    private static void swap(int[] arr , int i , int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
