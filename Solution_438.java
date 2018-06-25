/**
	给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
	字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

	说明：
	字母异位词指字母相同，但排列不同的字符串。
	不考虑答案输出的顺序。

	示例 1:
	输入:
	s: "cbaebabacd" p: "abc"
	输出:
	[0, 6]
	解释:
	起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
	起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。

	示例 2:
	输入:
	s: "abab" p: "ab"
	输出:
	[0, 1, 2]
	解释:
	起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
	起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
	起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

	我的think：
	判断字母异位词，可以将一个字符串中的字母出现次数保存到数组中。然后遍历另一个字符串的每一个字母，在数组中使对应字母的次数减一。
	然后遍历数组，查看数组元素是否全为零。
*/

// 解法一：比较暴力
class Solution_438 {
    public List<Integer> findAnagrams(String s, String p) {
        
        int m = s.length();  // s的长度
        int n = p.length();  // p的长度
        
        // 采用滑动窗口解决。  //[l...r]
        int start = 0, l = 0;  // start -> 子串的起始位置。 l -> 子串匹配是的左边索引
        int r = n - 1;   // r -> 子串匹配时的右边索引
        List<Integer> list = new ArrayList<>();
        
        while(r < m){
            // 判断字符异位词
            if(isAnagrams(s.substring(l , r+1) , p))
                list.add(start);
            
            l++;
            r++;
            
            start = l;
        }
        return list;
    }   
    // 判断异位词 
    private boolean isAnagrams(String s , String p){
        
        // 题目只判断26个小写字母
        int[] str = new int[26];
        
        // 统计每个字符出现的次数
        for(int i = 0; i < s.length(); i++)
            str[s.charAt(i) - 'a'] ++;
        
        for(int i = 0; i < p.length(); i++)
            str[p.charAt(i) - 'a'] --;
        
        for(int i=0; i < str.length; i++)
            if(str[i] != 0)
               return false;
        return true;
    }
}


// 优化后的算法,采用滑动窗口。
class Solution_438 {
    public List<Integer> findAnagrams(String s, String p) {
   
        ArrayList<Integer> list = new ArrayList<>();
        if(s == "" || s.length() < 1 || p == "" || p.length() < 1){
            return list;
        }
        
        // 将p 中的元素出现的次数保存到数组 pCount中
        int[] pCount = new int[26];
        for(int i=0; i<p.length(); i++)
            pCount[p.charAt(i) - 'a'] ++;
        
        // 滑动窗口 [left...right)
        int left = 0;
        int right = 0;
        char[] sChar = s.toCharArray(); 
        int[] sCount = new int[26];   // 将当前窗口包含的子串中字符出现次数保存到 sCount中。
        
        while(right < s.length()){
            
            char c = sChar[right++];  // 取出 right位置元素，right右移一位
            sCount[c - 'a'] ++;   // 从窗口中取出的元素放入 sCount         
            
            while(sCount[c - 'a'] > pCount[c - 'a']){
                sCount[sChar[left] - 'a']--;   // 从 sCount 中移除left位置元素，即数组对应位置值减一。 然后left右移一位
				left ++;
            }
            if(right - left == p.length()){
                list.add(left);    // 添加
                sCount[sChar[left] - 'a']--;   // 从 sCount 中移除left位置元素，即数组对应位置值减一。 然后left右移一位
				left ++;
			}
        }
        return list;
    }
}