package eoodin.property;

import org.junit.Test;

import java.util.HashMap;

public class PropertyTest {

    @Test
    public void test() {
        MyProperties p1 = new MyProperties();
        p1.put("KEY-1", null);

        HashMap<String, String> map = new HashMap<>();

        map.put("KEY-1", null);
    }
}
