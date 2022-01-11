import java.util.Comparator;
import java.util.HashMap;

public class MyMain {

    // Returns the number of odd numbers in mat
    public static int countOdds(int[][] mat) {
        // YOUR CODE HERE
        int count = 0;
        for (int[] ints : mat) {
            for (int anInt : ints) {
                if (anInt % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // Returns the largest value in mat
    public static int findLargest(int[][] mat) {
        int largest = Integer.MIN_VALUE;
        for (int[] ints : mat) {
            for (int anInt : ints) {
                if (anInt > largest) {
                    largest = anInt;
                }
            }
        }
        return largest;
    }

    // Write a method that "left-shifts" each row in a 2D array.
    // This means that for each row, all the numbers should be
    // shifted to the left by 1, with wraparound (the first value
    // should wrap around to the last entry in the row)
    public static int[][] leftShift(int[][] mat) {
        // YOUR CODE HERE
        // shift each row to the left by 1
        for (int i = 0; i < mat.length; i++) {
            int tmp = mat[i][0];
            for (int j = 0; j < mat[0].length; j++) {
                if (j == mat[i].length - 1) {
                    mat[i][j] = tmp;
                } else {
                    mat[i][j] = mat[i][j + 1];
                }
            }
        }
        return mat;
    }

    // Creates a 2D array of size arraySize x arraySize
    // where each value is each to the sum of its row and col indexes
    public static int[][] arrayBuilder(int arraySize) {
        int[][] array = new int[arraySize][arraySize];
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                array[i][j] = i + j;
            }
        }
        return array;
    }










    // Methods for the homework:

    // Returns the mean of the 2D array mat
    public static double mean(double[][] mat) {
        // YOUR CODE HERE
        double tot = 0;
        for (double[] doubles : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                tot += doubles[j];
            }
        }
        return tot / (mat.length * mat[0].length);
    }

    // Returns the median of the 2D array mat
    // Remember that the array is sorted!
    public static double median(double[][] mat) {
        // YOUR CODE HERE
        double[] arr = new double[mat.length * mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            System.arraycopy(mat[i], 0, arr, i * mat[0].length, mat[0].length);
        }

        int middle = arr.length/2;
        if (arr.length%2 == 1) {
            return arr[middle];
        } else {
            return (arr[middle-1] + arr[middle]) / 2.0;
        }

    }


    // Returns the mode of the 2D array mat
    // Remember that the array is sorted!
    public static double mode(double[][] mat) {
        HashMap<Double, Integer> map = new HashMap<>();
        for (double[] doubles : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                if (map.containsKey(doubles[j])) {
                    map.replace(doubles[j], map.get(doubles[j]) + 1);
                } else {
                    map.put(doubles[j], 1);
                }
            }
        }
        return map.keySet().stream().max(Comparator.comparingInt(map::get)).get();
    }


    public static void main(String[] args) {
        // Write some code here to test your methods!
    }
}
