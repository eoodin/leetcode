package eoodin.maxdistance;

class Solution {
    public int maxDistToClosest(int[] seats) {
        int lm = 0, rm = 0;
        for (int i = 1; seats[0] == 0 && i < seats.length; i++) {
            if (seats[i] > 0) {
                lm = i;
                break;
            }
        }

        for (int i = seats.length - 1; seats[seats.length - 1] == 0 && i >= 0; i--) {
            if (seats[i] > 0) {
                rm = seats.length - i - 1;
                break;
            }
        }

        int maxEmpty = Math.max(lm * 2, rm * 2);
        int tmpCount = 0;
        for (int i = lm; i < seats.length - rm; i++) {
            if (seats[i] == 0) {
                tmpCount++;
            } else {
                if (tmpCount > maxEmpty) {
                    maxEmpty = tmpCount;
                }
                tmpCount = 0;
            }
        }

        return (maxEmpty + 1) / 2;
    }

}