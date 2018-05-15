package eoodin.p010;

public class RegularExp {

    class Token {

    }

    class FixToken extends Token {
        private final char[] patterns;
        private final int start;
        private final int end;

        FixToken(char[] patterns, int start, int end) {
            this.patterns = patterns;
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return String.valueOf(patterns, start, end - start + 1);
        }
    }

    class VaryToken extends Token {
        private char ch;

        VaryToken(char ch) {

            this.ch = ch;
        }

        public String toString() {
            return String.valueOf(ch);
        }
    }

    public boolean isMatch(String s, String p) {
        char[] chars = s.toCharArray();
        char[] pattern = p.toCharArray();
        Token[] tokens = buildToken(pattern);

        return false;
    }

    private Token[] buildToken(char[] p) {
        Token[] tokens = new Token[p.length];
        int fpStart = 0;
        int tii = 0;
        for (int i = 0; i < p.length - 1; i++) {
            if (p[i + 1] == '*') {
                if(fpStart < i) {
                    tokens[tii++] = new FixToken(p, fpStart, i - 1);
                }
                tokens[tii++] = new VaryToken(p[i]);
                i++;
                fpStart = i + 1;
            }
        }
        if (fpStart < p.length) {
            tokens[tii++] = new FixToken(p, fpStart, p.length - 1);
        }

        Token[] trimmed = new Token[tii];
        System.arraycopy(tokens, 0, trimmed, 0, tii);

        return trimmed;
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
