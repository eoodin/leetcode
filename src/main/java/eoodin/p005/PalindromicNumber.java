package eoodin.p005;

public class PalindromicNumber {

    public String longest(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();

        int longest = 0;
        int ss = 0;
        int se = len -1;
        int ls = 0, le = 0;
        while (ss <= se) {
            int si = se;
            while (ss <= si && !isPalindromic(chars, ss, si)) si--;
            if(si - ss + 1 > longest) {
                longest = si - ss + 1;
                ls = ss;
                le = si;
            }
            si = ss + 1;
            while (si <= se && !isPalindromic(chars, si, se)) si++;
            if (se - si + 1 > longest) {
                longest = se - si + 1;
                ls = si;
                le = se;
            }
            ss++;
            se--;
        }

        return s.substring(ls, le + 1);
    }

    private boolean isPalindromic(char[] chars, int start, int end) {
        int s = start, e = end;
        while(s < e) {
            if(chars[s++] != chars[e--])
                return false;
        }
        return true;
    }
}
