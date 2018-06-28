/**
	
	给定两个数组，写一个方法来计算它们的交集。

	例如:
	给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].

	注意：
	   输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
	   我们可以不考虑输出结果的顺序。

    跟进:
	如果给定的数组已经排好序呢？你将如何优化你的算法？   // 采用第二种解法
	如果 nums1 的大小比 nums2 小很多，哪种方法更优？    
	如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？   // 遍历过程中将nums1中符合条件的值去除。
*/

class Solution_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
     
        if(nums1.length < 1 || nums2.length < 1)
            return new int[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        int k = 0;
        // 存储 nums1
        for(int i=0; i<nums1.length; i++){
            k = nums1[i];
            if(map.containsKey(k))
                map.put(k , map.get(k)+1);
            else 
                map.put(k, 1);
        }
        
        int j = 0;
        int[] res = new int[nums1.length];
        // 遍历 nums2，找重复元素
        for(int i=0; i<nums2.length; i++){
            k = nums2[i];
            if(map.containsKey(k) && map.get(k) > 0){
                res[j++] = k;
                map.put(k, map.get(k) - 1);
            }
        }
        return Arrays.copyOfRange(res, 0, j);   // res 添加元素后进行了 ++ 操作，所以此处直接用 j
    }
}

// 如果数组有序的话，采用对比的方式
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
     
        if(nums1.length < 1 || nums2.length < 1)
            return new int[0];
        
        // 跟进
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    
        int[] rtn = new int[nums1.length];
        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                rtn[k++] = nums1[i];
                i ++;
                j ++;
            }
            else if(nums1[i] > nums2[j]){
                j ++;
            }
            else{
                i ++;
            }
        }
        return Arrays.copyOfRange(rtn, 0, k);        
    }
}