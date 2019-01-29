package eoodin.p763;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> lens = new ArrayList<>();
        char[] chars = s.toCharArray();
        int pos = 0;

        while (pos < chars.length) {
            int li = pos;
            int si = pos;
            do {
                int t = chars.length - 1;
                for (; t > si; --t) {
                    if(chars[si] == chars[t]) {
                        break;
                    }
                }
                if (t > li) {
                    li = t;
                }
                si++;
            } while(si < li);
            lens.add(li - pos + 1);
            pos = li + 1;
        }

        return lens;
    }
}
