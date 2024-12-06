package org.devpush.com.day04;

import java.util.List;

public class Helper {

    public char[][] convertListToMatrix(List<String> list) {
        if (list == null || list.isEmpty()) {
            return new char[0][0];
        }

        int rows = list.size();
        int cols = list.get(0).length();
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = list.get(i).toCharArray();
        }

        return matrix;
    }

    public int DFS(int i, int j, char[][] matrix) {
        int[][] directions = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
        };
        int counter = 0;
        String target = "XMAS";
        for (int[] dir : directions) {
            int newRow = i;
            int newCol = j;
            StringBuilder sb = new StringBuilder();

            // Traverse in the current direction for the length of the target string
            for (int k = 0; k < target.length(); k++) {
                if (isSafe(newRow, newCol, matrix)) {
                    sb.append(matrix[newRow][newCol]);
                    newRow += dir[0];
                    newCol += dir[1];
                } else {
                    break;
                }
            }

            // Check if the constructed string matches the target
            if (sb.toString().equals(target)) {
                counter++;
            }
        }
        return counter;

    }

    public boolean isPatternFound(int i, int j, char[][] matrix) {
        // Offsets for 'M' diagonally from A
        int[][] mOffsets = {
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };

        if (isSquareSafe(i, j, matrix)) {

            int lefttopx = i + mOffsets[0][0];
            int lefttopy = j + mOffsets[0][1];

            int righttopx = i + mOffsets[1][0];
            int righttopy = j + mOffsets[1][1];

            int leftbottomx = i + mOffsets[2][0];
            int leftbottomy = j + mOffsets[2][1];

            int rightbottomx = i + mOffsets[3][0];
            int rightbottomy = j + mOffsets[3][1];

            if ((matrix[lefttopx][lefttopy] == 'M' && matrix[rightbottomx][rightbottomy] == 'S') &&
                    (matrix[righttopx][righttopy] == 'S' && matrix[leftbottomx][leftbottomy] == 'M')) {
                return true;
            }

            if ((matrix[lefttopx][lefttopy] == 'S' && matrix[rightbottomx][rightbottomy] == 'M') &&
                    (matrix[righttopx][righttopy] == 'M' && matrix[leftbottomx][leftbottomy] == 'S')
            ) {
                return true;
            }

            if ((matrix[lefttopx][lefttopy] == 'M' && matrix[rightbottomx][rightbottomy] == 'S') &&
                    (matrix[righttopx][righttopy] == 'M' && matrix[leftbottomx][leftbottomy] == 'S')
            ) {
                return true;
            }

            if ((matrix[lefttopx][lefttopy] == 'S' && matrix[rightbottomx][rightbottomy] == 'M') &&
                    (matrix[righttopx][righttopy] == 'S' && matrix[leftbottomx][leftbottomy] == 'M')
            ) {
                return true;
            }
            else {
                return false;
            }
        } else {
            return false;
        }

    }

//    public boolean isXPatternFound(int i, int j, char[][] matrix) {
//        // Directions for the X pattern: top-left, top-right, bottom-left, bottom-right
//        int[][] directions = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
//
//        for (int[] dir : directions) {
//            if (checkXPatternInDirection(i, j, matrix, dir[0], dir[1])) {
//                return true;
//            }
//        }
//
//        return false;
//    }

//    private static boolean checkXPatternInDirection(int i, int j, char[][] matrix, int di, int dj) {
//        // Check both forward and backward 'MAS' patterns
//        // Case 1: M first, then A, then S
//        if (checkSequence(i, j, matrix,
//                new char[]{'M', 'A', 'S'},
//                di, dj)) {
//            return true;
//        }
//
//        // Case 2: S first, then A, then M (reversed pattern)
//        if (checkSequence(i, j, matrix,
//                new char[]{'S', 'A', 'M'},
//                di, dj)) {
//            return true;
//        }
//
//        return false;
//    }

//    private static boolean checkSequence(int i, int j, char[][] matrix, char[] sequence, int di, int dj) {
//        for (int k = 0; k < sequence.length; k++) {
//            int ni = i + k * di;
//            int nj = j + k * dj;
//
//            // Check if the current position is safe and matches the expected character
//            if (!isSafe(ni, nj, matrix) || matrix[ni][nj] != sequence[k]) {
//                return false;
//            }
//        }
//        return true;
//    }


    private static boolean isSafe(int i, int j, char[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        return (i >= 0 && i < rowSize) && (j >= 0 && j < colSize);
    }

    private static boolean isSquareSafe(int i, int j, char[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        return (i >= 1 && i < rowSize - 1) && (j >= 1 && j < colSize - 1);
    }
}
