package eoodin.jvm;

public class CLTest {
    public static void main(String[] args) {
    }

    public void test() {
        try {
            int p = add(8, 8);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    private int add(int v1, int v2) {
        return v1 + v2;
    }
}
