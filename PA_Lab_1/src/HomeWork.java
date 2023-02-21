import java.util.Scanner;

public class HomeWork {

    private static int matrixDimension = 0;
    private static long startTime = 0;
    private static long endTime = 0;

    public static void main(String[] args) {
        int[][] resultMatrix = makeLatinSquare();
        displayRowsAndColumns(resultMatrix);
        endTime = System.nanoTime();
        if (matrixDimension > 30_000) {
            System.out.println(endTime - startTime);
        }
    }

    private static int[][] makeLatinSquare() {
        Scanner inputInt = new Scanner(System.in);
        System.out.println("Enter an integer:...");
        if (inputInt.hasNextInt()) {
            matrixDimension = inputInt.nextInt();
            if (matrixDimension > 30_000) {
                startTime = System.nanoTime();
            }
            int[][] latinSquare = new int[matrixDimension][matrixDimension];
            for (int i = 0; i < matrixDimension; i++) {
                for (int j = 0; j < matrixDimension; j++) {
                    latinSquare[i][j] = ((i + 1) + j) % matrixDimension;
                    if (latinSquare[i][j] == 0) latinSquare[i][j] = matrixDimension;
                }
            }
            return latinSquare;
        } else {
            System.out.println("Error! That's not a valid integer value!");
        }
        return new int[0][];
    }

    private static void displayRowsAndColumns(int[][] inputMatrix) {
        if (matrixDimension <= 30_000) {
            System.out.println("Rows:");
        }
        for (int i = 0; i < matrixDimension; i++) {
            StringBuilder lineConcat = new StringBuilder(i + ": ");
            for (int j = 0; j < matrixDimension; j++) {
                lineConcat.append(inputMatrix[i][j]);
            }
            if (matrixDimension <= 30_000) {
                System.out.println(lineConcat);
            }
        }
        if (matrixDimension <= 30_000) {
            System.out.println("Columns:");
        }
        for (int j = 0; j < matrixDimension; j++) {
            StringBuilder lineConcat = new StringBuilder(j + ": ");
            for (int i = 0; i < matrixDimension; i++) {
                lineConcat.append(inputMatrix[i][j]);
            }
            if (matrixDimension <= 30_000) {
                System.out.println(lineConcat);
            }
        }
    }
}
