import java.util.Arrays;

void main() {
    printLongestStraightLine(new int[]{2, 2},
            new int[]{1, 1},
            new int[]{2, 1},
            new int[]{3, 3},
            new int[]{4, 4},
            new int[]{1, 3});

    printLongestStraightLine(new int[]{0, 0},
            new int[]{1, 3},
            new int[]{1, 2},
            new int[]{2, 4},
            new int[]{2, 2},
            new int[]{3, 1},
            new int[]{4, 0});

    printLongestStraightLine(new int[]{-1, 0},
            new int[]{1, 3},
            new int[]{-1, 1},
            new int[]{-2, 2},
            new int[]{2, -2},
            new int[]{3, -3},
            new int[]{4, -4});
}

void printLongestStraightLine(int[]... coordinatePairs) {
    int[][] longestLinePairs = new int[coordinatePairs.length][2];
    int[] firstPair = new int[2];
    int maxLength = 0;
    double gradient = 0;
    int currentLength;
    int printedPointCount = 0;

    for (int i = 0; i < coordinatePairs.length; i++) {
        for (int j = i + 1; j < coordinatePairs.length; j++) {
            currentLength = getLengthBetween2Coordinates(coordinatePairs[i], coordinatePairs[j]);
            if (currentLength > maxLength) {
                maxLength = currentLength;
                gradient = getGradientBetween2Coordinates(coordinatePairs[i], coordinatePairs[j]);
                firstPair = coordinatePairs[i];
            }
        }
    }
    longestLinePairs[0] = firstPair;

    int longestArrayCount = 1;
    for (int[] coordinatePair : coordinatePairs) {
        if (checkWhetherPointInLongestLine(gradient, firstPair, coordinatePair)) {
            longestLinePairs[longestArrayCount] = coordinatePair;
            longestArrayCount++;
        }
    }

    for (int[] longestLinePair : longestLinePairs) {
        System.out.print(STR."\{Arrays.toString(longestLinePair)},");
        printedPointCount++;
        if (printedPointCount == longestArrayCount) break;
    }
    System.out.println("\b\n");

    System.out.println("----------------------------");

}

int getLengthBetween2Coordinates(int[] pair1, int[] pair2) {
    int x = pair1[0] - pair2[0];
    int y = pair1[1] - pair2[1];
    //return Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5);
    return x * x + y * y;
}

double getGradientBetween2Coordinates(int[] pair1, int[] pair2) {
    int x = pair1[0] - pair2[0];
    int y = pair1[1] - pair2[1];
    return (double) y / x;
}

boolean checkWhetherPointInLongestLine(double gradient, int[] startingPoint, int[] checkingPoint) {
    return getLengthBetween2Coordinates(startingPoint, checkingPoint) > 0 && getGradientBetween2Coordinates(startingPoint, checkingPoint) == gradient;
}