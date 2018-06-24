/**
	编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

	示例 1：
	给定 s = "hello", 返回 "holle".

	示例 2：
	给定 s = "leetcode", 返回 "leotcede".

	注意:
	元音字母不包括 "y".
*/

class Solution_345 {
    public String reverseVowels(String s) {
        
        // 从两端反转字符串中的字符，很容易会想到 碰撞指针方法
        int l=0, r = s.length()-1;
        // 涉及到交换字符串元素，所以转换为字符数组
        char[] sChar = s.toCharArray();
        
        while( l < r){
            while(!isVowels(sChar[l]) && l < r){     // 从前向后定位元音
                l++;
            }
            while(!isVowels(sChar[r]) && l < r){    // 从后向前定位元音
                r--;
            }
            
            if(l < r){    
                char t = sChar[l];
                sChar[l] = sChar[r];
                sChar[r] = t;
                l++;
                r--;
            }
        }
        return String.copyValueOf(sChar);         
    }
    
	// 判断是否为元音字符
    private boolean isVowels(char c){
        
        switch(c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default :
                return false;
        }
    }
}