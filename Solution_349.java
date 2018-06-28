/**
	给定两个数组，写一个函数来计算它们的交集。

	例子:
	给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].

	提示:
	每个在结果中的元素必定是唯一的。
	我们可以不考虑输出结果的顺序。
*/

class Solution_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        if(nums1.length < 1 || nums2.length < 1)
            return new int[0];

		// deal with nums1
        Set<Integer> set1 = new HashSet<>();
        for(int i=0; i<nums1.length; i++)
            set1.add(nums1[i]);

		// deal with nums2 and compare nums1
        Set<Integer> set2 = new HashSet<>();
        for(int i=0; i<nums2.length; i++)
            if(set1.contains(nums2[i]))
                set2.add(nums2[i]);
        
        int[] res = new int[set2.size()];
        int i=0;
        for(int v : set2){
            res[i++] = v;
        }
        return res;
    }
}

