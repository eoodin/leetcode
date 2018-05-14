package eoodin.p003;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        return slideWindow(s);
    }

    private int bruteForceSearch(String s) {
        int len = s.length();
        int longest = len > 0 ? 1 : 0;
        for (int ss = 0; ss < len; ss++) {
            int l = 1;
            for(; l + ss < len; l++) {
                if (s.substring(ss, ss + l).contains(String.valueOf(s.charAt(ss + l)))) {
                    break;
                }
            }
            if (longest < l)
                longest = l;
        }


        return longest;
    }

    private int slideWindow(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        if (len == 0)
            return 0;

        int longest = 1;
        int tci = 1;
        int ps = 0, pe = 0;
        while (tci < len) {
            int pri = charPos(chars, ps, pe, tci);
            if(pri == -1) {
                tci++;
                pe++;
                continue;
            }

            if (longest < pe - ps + 1)
                longest = pe - ps + 1;
            ps = pri + 1;
            pe = tci;
            tci++;
        }

        if (longest < pe - ps + 1)
            return pe - ps + 1;

        return longest;
    }

    private int charPos(char[] chars, int start, int end, int tci) {
        for (int i = start; i <= end; i++) {
            if(chars[i] == chars[tci])
                return i;
        }

        return -1;
    }
}
