package eoodin.p010;

public class RegularExp {
    public boolean isMatch(String s, String p) {
        char[] chars = s.toCharArray();
        char[] pattern = p.toCharArray();
        int pi = 0, si = 0;
        System.out.println("Text:    " + s);
        System.out.println("Pattern: " + p);
        return regMatch(chars, pattern, pi, si);
    }

    private boolean regMatch(char[] target, char[] pattern, int pi, int si) {
//        if (pi < 1)
//            throw new IllegalArgumentException("Start with *");
//        if (pattern[pi - 1] == '*')
//            throw new IllegalArgumentException("Double *");
        System.out.println("Match: pi=" + pi + ", si=" + si);
        while (pi < pattern.length && si < target.length) {
            if (pi + 1 < pattern.length && pattern[pi + 1] == '*') {
                return greedyMatch(target, pattern, pi + 1, si, pattern[pi]);
            }
            else if(pattern[pi] == '.' || pattern[pi] == target[si]) {
                pi++;
                si++;
            }
        }

        return pi == pattern.length && si == target.length;
    }

    private boolean greedyMatch(char[] target, char[] pattern, int pi, int si, char c) {
        System.out.println("Greedy: pi=" + pi + ", si=" + si + ", ch=" + c);
        if(c == '.') {
            for (int ssi = target.length - 1; ssi >= si; ssi--) {
                if(regMatch(target, pattern, pi + 1, ssi))
                    return true;
            }
        }
        else {
            int end = target.length - 1;
            for (; end >= si; end--) {
                int ssi = si;
                for (;ssi < end; ssi++) {
                    if (target[ssi] != c)
                        break;
                }

                if(pi + 1 == pattern.length)
                    return false;

                if (regMatch(target, pattern, pi + 1, ssi))
                    return true;
            }
        }

        return false;
    }
}
