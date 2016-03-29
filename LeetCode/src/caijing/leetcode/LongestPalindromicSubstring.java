package caijing.leetcode;

/**
 * Created by Caij on 2016/3/15.
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s.length() < 1) return s;
        int start = 0;
        int maxLen = 1;
        int curLen = maxLen;
        int curStart = start;

        for (int i = 1; i < s.length(); i ++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen ++;
            }else {
                curStart = i;
                curLen = 1;
            }

            if (curLen > maxLen) {
                maxLen = curLen;
                start = curStart;
            }
        }
//        System.out.println("maxLen:" + maxLen);
//        System.out.println("start:" + start);

        if (maxLen == 1) {
            return s;
        }

        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        System.out.print(longestPalindrome("ccd"));
    }

//    private int lo, maxLen;
//
//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len < 2)
//            return s;
//
//        for (int i = 0; i < len-1; i++) {
//            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
//            extendPalindrome(s, i, i+1); //assume even length.
//        }
//        return s.substring(lo, lo + maxLen);
//    }
//
//    private void extendPalindrome(String s, int j, int k) {
//        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
//            j--;
//            k++;
//        }
//        if (maxLen < k - j - 1) {
//            lo = j + 1;
//            maxLen = k - j - 1;
//        }
//    }

}
