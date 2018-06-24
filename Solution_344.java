/**
	请编写一个函数，其功能是将输入的字符串反转过来。

	示例：
	输入：s = "hello"
	返回："olleh"
*/

class Solution_344 {
    public String reverseString(String s) {
        
        int l=0, r=s.length()-1;
        char[] sChar = s.toCharArray();
        while(l < r){
            char t = sChar[l];
            sChar[l] = sChar[r];
            sChar[r] = t;
            l++;
            r--;
        }
        return String.copyValueOf(sChar);
    }
}






