package eoodin.p006;

public class ZigZagString {
    public String convert(String s, int numRows) {
        if (numRows < 1)
            throw new IllegalArgumentException("row should be positive integer");

        int len = s.length();
        if (numRows <= 1 || numRows >= len)
            return s;

        char[] chars = s.toCharArray();

        int nRound = numRows * 2 - 2;
        int group = len / nRound;
        int sanct = len % nRound;
        if (sanct > 0)
            group++;

        char[][] buckets = new char[numRows][group * 2];
        int[] iis = new int[numRows];

        for (int i = 0, ib = 0, iboffset = -1; i < len; i++) {
            buckets[ib][iis[ib]++] = chars[i];
            if(ib == numRows -1 || ib == 0) {
                iboffset *= -1;
            }

            ib += iboffset;
        }

        char[] collect = new char[len];
        for (int i = 0, ins = 0; i < numRows; i++) {
            char[] bucket = buckets[i];
            for (int j = 0; j < iis[i]; j++) {
                collect[ins++] = bucket[j];
            }
        }

        return String.valueOf(collect);
    }
}
