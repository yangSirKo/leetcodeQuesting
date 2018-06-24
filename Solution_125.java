/**
	给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
	说明：本题中，我们将空字符串定义为有效的回文串。

	示例 1:
	输入: "A man, a plan, a canal: Panama"
	输出: true

	示例 2:
	输入: "race a car"
	输出: false
*/

class Solution_125 {
    
    // 优化后的算法
    public boolean isPalindrome(String s) {
            if(s == ""){
            return true;
        }
        
        int l = 0, r = s.length()-1;
        
        while(l < r){
            char a = ' ';
            while(l < r){
                a = s.charAt(l);
                if('a' <= a && a <= 'z'){
                    a = (char)(a-'a'+'A');
                    break;
                }
                else if('A' <= a && a <= 'Z')
                    break;
                else if('0' <= a && a <= '9')
                    break;
                else
                    l++;
            }
                
            char b = ' ';
            while(l < r){
                b = s.charAt(r);
                if('a' <= b && b <= 'z'){
                    b = (char)(b-'a'+'A');
                    break;
                }
                else if('A' <= b && b <= 'Z')
                    break;
                else if('0' <= b && b <= '9')
                    break;
                else
                    r--;
            }
            
            if(r==l)
                return true;
            
            if(a == b){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
    
    /**
    // 空间复杂度较大
    public boolean isPalindrome(String s) {
        
        if(s == ""){
            return true;
        }
        
        // s -> 转为字符数组
        char[] sChar = s.toCharArray();
        int i=0, j=sChar.length-1;
        
        while(i<j){
            
            while(!(('a' <= sChar[i] && sChar[i] <= 'z') || ('A' <= sChar[i] && sChar[i] <= 'Z') || ('0' <= sChar[i] && sChar[i] <= '9'))){
                i++;
                if(i>=j)
                    return true;
            }
            while(!(('a' <= sChar[j] && sChar[j] <= 'z') || ('A' <= sChar[j] && sChar[j] <= 'Z') || ('0' <= sChar[j] && sChar[j] <= '9'))){
                j--;
                if(i>=j)
                    return true;
            }
            
            // 字符转换为字符串进行比较     
            if((""+sChar[i]).equalsIgnoreCase(""+sChar[j])){
                i++;
                j--;
            }else
                return false;
        }
        return true;
    }
    */
}