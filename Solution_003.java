/** 
    问题：无重复字符的最长子串
	给定一个字符串，找出不含有重复字符的最长子串的长度。

	示例：
	给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
	给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
	给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
public class Solution_003 {
	
	public static void main(String[] args){
		
		String str = "abcabcbb";
		int n = lengthOfLongestSubstring(str);
		System.out.println(n);
	}
	
	public static int lengthOfLongestSubstring(String str){
		
		if(str == null || str == ""){
			return 0;
		}
		// 记录元素最后一次出现的位置
		Map<Character,Integer> map = new HashMap<>();
		int length = 0;  // 当前情况最长子串的长度
		int start = 0;  // 当前最长子串的起始位置
		char[] sChar = str.toCharArray();   // 字符串转化为字节数组
		for(int i = 0; i < sChar.length; i++){
			
			// 注意：从start位置处开始查找，map中是否包含该元素
			if(map.containsKey(sChar[i]) && map.get(sChar[i]) >= start){
				start = map.get(sChar[i]) + 1;
			}else{
				length++;
			}
			if(length < i-start+1){
				length = i-start+1;
			}
			map.put(sChar[i], i);
		}
		return length;
	}
}

// 优化算法，  空间复杂度为 O(1)
class Solution {
    
    public int lengthOfLongestSubstring(String s) {

        if(s == null || s == ""){
			return 0;
		}
        
        // 采用滑动窗口的方式
        int start = 0;   // 最长子串起始位置
        int max = 0;  // 当前子串长度
        Map<Character, Integer> map = new HashMap<>();

        // char[] sChar = s.toCharArray();
        char c = ' ';
        for(int i=0; i<s.length(); i++){
            c = s.charAt(i);
            if(map.containsKey(c) && map.get(c) >= start)
                start = map.get(c) + 1;

            map.put(c , i);

            max = Math.max( max , i-start+1);
        }
        return max;
    }
}