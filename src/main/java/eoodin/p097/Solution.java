package eoodin.p097;

public class Solution {
    private int[][] results;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        this.results = new int[s1.length() + 1][s2.length() + 1];
        return interleave(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0);
    }

    private boolean interleave(char[] arr1, char[] arr2, char[] arr, int p1, int p2) {
        if (p1 == arr1.length && p2 == arr2.length) {
            return true;
        }

        boolean b1 = false, b2 = false;
        if (p1 < arr1.length && arr[p1 + p2] == arr1[p1]) {
            int c = this.results[p1 + 1][p2];
            if (c != 0) {
                b1 = c == 1;
            } else {
                b1 =  interleave(arr1, arr2, arr, p1 + 1, p2);
            }
        }

        if (p2 < arr2.length && arr[p1 + p2] == arr2[p2]) {
            int c = this.results[p1][p2 + 1];
            if (c != 0) {
                b2 = c == 1;
            } else {
                b2 = interleave(arr1, arr2, arr, p1, p2 + 1);
            }
        }

        boolean v = b1 || b2;
        this.results[p1][p2] = v ? 1 : 2; // 1: true, 2: false
        return v;
    }
}
