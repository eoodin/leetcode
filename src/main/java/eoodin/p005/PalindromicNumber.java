package eoodin.p005;

public class PalindromicNumber {

    public String longest(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        if(len == 0)
            throw new IllegalArgumentException("Given string is empty");

        int lhl = 0;
        int lp = 0;
        boolean odd = true;
        for (int i = 1; i < len; i++) {
            int hl = longestEven(chars, i, 1);
            if (hl != -1 && lhl < hl) {
                lhl = hl;
                lp = i;
                odd = false;
            }
            hl = longestOdd(chars, i, 1);
            if (hl != -1 && lhl <= hl) {
                lhl = hl;
                lp = i;
                odd = true;
            }
        }

        return s.substring(lp - lhl, lp + lhl + (odd ? 1 : 0));
    }

    private int longestOdd(char[] chars, int searchStart, int step) {
        if (searchStart - step < 0 || searchStart + step >= chars.length)
            return -1;
        if(chars[searchStart - step] != chars[searchStart + step])
            return -1;

        int hl = longestOdd(chars, searchStart, step + 1);
        if (hl != -1)
            return hl;

        return step;
    }

    private int longestEven(char[] chars, int searchStart, int step) {
        if (searchStart - step < 0 || searchStart + step - 1 >= chars.length)
            return -1;

        if(chars[searchStart - step] != chars[searchStart + step -1])
            return -1;

        int hl = longestEven(chars, searchStart, step + 1);
        if (hl != -1)
            return hl;

        return step;
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
