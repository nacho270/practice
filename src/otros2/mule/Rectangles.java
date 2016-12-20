package otros2.mule;

import java.util.ArrayList;
import java.util.List;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

Imagine we have an image. We’ll represent this image as a simple 2D array where every pixel is a 1 or a 0. The image you get is known to have a single rectangle of 0s on a background of 1s. Write a function that takes in the image and returns the coordinates of the rectangle -- either top-left and bottom-right; or top-left, width, and height.

 */

class Rectangles {

    static class RectangleInfo {
        int x, y, width, height;

        @Override
        public String toString() {
            return "x= " + x + " y= " + y + " width= " + width + " height= " + height;
        }
    }

    public static void main(String[] args) {
        final int[][] image = { //
                        { 1, 1, 1, 1, 1, 1, 1 }, //
                        { 1, 1, 1, 1, 1, 1, 1 }, //
                        { 1, 1, 1, 0, 0, 0, 1 }, //
                        { 1, 0, 1, 0, 0, 0, 1 }, //
                        { 1, 0, 1, 1, 1, 1, 1 }, //
                        { 1, 0, 1, 0, 0, 1, 1 }, //
                        { 1, 1, 1, 0, 0, 1, 1 }, //
                        { 1, 1, 1, 1, 1, 1, 1 }, };
        final RectangleInfo info = getRectangleInfo(image);
        System.out.println(info);

        final List<RectangleInfo> infos = getRectangleInfoList(image);
        for (final RectangleInfo ri : infos) {
            System.out.println(ri);
        }
    }

    private static List<RectangleInfo> getRectangleInfoList(int[][] image) {
        final List<RectangleInfo> returnList = new ArrayList<>();
        RectangleInfo info = internalGetRectangleInfo(image, 0, 0);
        returnList.add(info);
        while (info != null) {
            info = internalGetRectangleInfo(image, info.y + info.height, info.x + info.width);
            returnList.add(info);
        }
        return returnList;
    }

    private static RectangleInfo internalGetRectangleInfo(int[][] image, int yBegin, int xBegin) {
        for (int i = yBegin; i < image.length; i++) {
            for (int j = xBegin; j < image[i].length; j++) {
                if (image[i][j] == 1) {
                    continue;
                }
                final RectangleInfo info = new RectangleInfo();
                info.x = j;
                info.y = i;
                int widthIndex = j;
                int heightIndex = i;
                int width = 0;
                int height = 0;
                while (widthIndex < image[i].length && image[i][widthIndex] == 0) {
                    width++;
                    widthIndex++;
                }
                while (heightIndex < image.length && image[heightIndex][j] == 0) {
                    height++;
                    heightIndex++;
                }
                info.width = width;
                info.height = height;
                return info;
            }
        }
        return null;
    }

    private static RectangleInfo getRectangleInfo(int[][] image) {
        return internalGetRectangleInfo(image, 0, 0);
    }
}
