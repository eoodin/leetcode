package eoodin.p065;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidNumberTest {
    @Test
    public void test1() {
        assertTrue(isNumber("0"));
    }

    @Test
    public void test2() {
        assertTrue(isNumber(" 0.1"));
    }

    @Test
    public void test3() {
        assertTrue(isNumber("2e10"));
    }

    @Test
    public void test4() {
        assertFalse(isNumber("abc"));
    }

    @Test
    public void test5() {
        assertFalse(isNumber("1 a"));
    }

    public boolean isNumber(String s) {
        char[] chars = s.trim().toCharArray();
        if (chars.length < 1)
            throw new IllegalArgumentException("empty string");

        int pos = 0;
        char ch = chars[pos];
        if(ch == '+' || ch == '-')
            pos++;
        boolean zeroLeading = chars[pos] == '0';
        boolean decimal = false;
        boolean scientific = false;
        do {
            ch = chars[pos++];
            if (ch < '0' || ch > '9')
                return false;
            else if (ch == '.') {
                if(pos == chars.length)
                    return false;

                do {
                    ch = chars[pos++];
                    if (ch == 'e' || ch == 'E') {
                        scientific = true;
                        break;
                    }
                    else if (ch < '0' || ch > '9')
                        return false;
                } while ( pos < chars.length);
                decimal = true;
            }
        } while (pos < chars.length);

        if (zeroLeading && !decimal)
            return false;

        if (scientific) {
            int apos = takeDecimal(chars, pos);
            if (apos == pos)
                return false;
        }

        return pos == chars.length;
    }

    private int takeDecimal(char[] chars, int pos) {
        int apos = takeDigits(chars, pos);
        if (apos == pos)
            return apos;

        return apos;
    }

    private int takeDigits(char[] chars, int pos) {
        while (pos < chars.length) {
            char ch = chars[pos];
            if (ch < '0' || ch > '9')
                break;
            pos++;
        }
        return pos;
    }
}
