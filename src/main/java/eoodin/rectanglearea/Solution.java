package eoodin.rectanglearea;

import java.awt.*;
import java.math.BigInteger;

class Solution {
    public int rectangleArea(int[][] rectangles) {
        BigInteger area = new BigInteger("0");
        for (int i = 0; i < rectangles.length; i++) {
            BigInteger rectArea = area(rectangles[i]);
            System.out.println("Adding area: " + rectArea);
            area = area.add(rectArea);
            for (int j = 0; j < i; j++) {
                BigInteger intersectArea = intersectArea(rectangles[i], rectangles[j]);
                System.out.println("Subtracting intersect: " + intersectArea);
                area = area.subtract(intersectArea);
            }
        }

        return area.mod(new BigInteger("1000000007")).intValue();
    }

    private BigInteger intersectArea(int[] r1, int[] r2) {
        Rectangle rect1 = new Rectangle(r1[0], r1[1], r1[2] - r1[0], r1[3] - r1[1]);
        Rectangle rect2 = new Rectangle(r2[0], r2[1], r2[2] - r2[0], r2[3] - r2[1]);

        if (rect1.intersects(rect2)) {
            Rectangle intersection = rect1.intersection(rect2);
            return BigInteger.valueOf(intersection.width * intersection.height);
        }

        return BigInteger.ZERO;
    }

    private BigInteger area(int[] rect) {
        Rectangle r = new Rectangle(rect[0], rect[1], rect[2] - rect[0], rect[3] - rect[1]);
        ;
        return BigInteger.valueOf(r.height * r.width);
    }
}
