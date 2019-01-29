package eoodin.shiftletter;

public class ShiftLetter {
    public String shiftingLetters(String S, int[] shifts) {
        char[] shifted = new char[S.length()];
        int[] calculatedShifts = new int[shifts.length];
        for (int i = shifts.length - 1; i >= 0; --i) {
            if (i < shifts.length - 1) {
                calculatedShifts[i] = calculatedShifts[i + 1] % 26+ shifts[i];
            } else {
                calculatedShifts[i] = shifts[i];
            }
        }
        for (int i = 0, len = shifts.length; i < len; ++i) {
            shifted[i] = (char) ('a' + ((S.charAt(i) - 'a') + calculatedShifts[i]) % 26);
        }
        return String.valueOf(shifted);
    }
}
