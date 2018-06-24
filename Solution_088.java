/**
	问题：合并两个有序的数组
	给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

	说明:
	初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
	你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
	示例:

	输入:
	nums1 = [1,2,3,0,0,0], m = 3
	nums2 = [2,5,6],       n = 3
	输出: [1,2,2,3,5,6]
*/

class Solution_088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // 采用归并排序的思想
        int[] aux = Arrays.copyOfRange(nums1,0,m);  // 辅助空间, 保存了nums1中有元素的部分

        // aux[] + nums2[] -> nums1[]
        int i=0, j=0, length = m+n;
        for(int k=0; k<length; k++){
            if(i>=m)
                nums1[k] = nums2[j++];
            
            else if(j>=n)
                nums1[k] = aux[i++];
            
            else if(aux[i] <= nums2[j])
                nums1[k] = aux[i++];
            
            else
                nums1[k] = nums2[j++];
        }
    }
}