package eoodin.jvm;

import org.junit.Test;

public class StringTest {

    @Test
    public void benchmarkStringBuilding() {
        long t = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer(100000);
        for (int i = 0; i < 100000; i++) {
            sb.append("a");
        }
        String str = sb.toString();
        System.out.printf("StringBuler.append: %dms%n", System.currentTimeMillis() - t);
        t = System.currentTimeMillis();
        str = "";
        for (int i = 0; i < 100000; i++) {
            str += "a";
        }
        System.out.printf("String '+': %dms%n", System.currentTimeMillis() - t);
    }
}
