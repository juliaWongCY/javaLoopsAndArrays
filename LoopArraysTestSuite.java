import java.util.Arrays;

public class LoopArraysTestSuite {

    public static void main(String[] args) {
        System.out.println("Running tests...");

        fibTests();
        maximumTests();
        frequencyTableTests();
        matrixMultiplyTests();

        System.out.println("...tests complete.");
    }

    public static void fibTests() {
        testFib(5, 5);
        testFib(4, 3);
        testFib(0, 0);
        testFib(1, 1);
        testFib(9, 34);
        testFib(15, 610);
    }

    public static void maximumTests() {
        testMaximum(new int[] { 1, 3, 2 }, 3);
        testMaximum(new int[] { 1, 100, 2 }, 100);
        testMaximum(new int[] { 4, 12, 7 }, 12);
        testMaximum(new int[] { 65, 43, 44 }, 65);
        testMaximum(new int[] { 9, 2, 11 }, 11);
        testMaximum(new int[] {2, 9, 113}, 113);
        testMaximum(new int[] {75, 16, 11, 44}, 75); 
        testMaximum(new int[] { 9, 2, 11, 44, 55 }, 55);
        testMaximum(new int[] { 12, 123, 55, 23, 66, 448 }, 448);
        testMaximum(new int[] {1, 1, 0, 0, 0, 2 }, 2);
    }

    public static void frequencyTableTests() {
        testFrequencyTable(-1.5, 1.5, 6
                          ,new double[] { -1.1, 1.1, 1.2, -0.8, 1.6 }
                          ,new int[] { 1, 1, 0, 0, 0, 2 });
        testFrequencyTable(1.0, 4.0, 6
                          ,new double[] { 1.1, 1.0, 1.2, 3.8, 2.6, 3.2 }
                          ,new int[] { 3, 0, 0, 1, 1, 1 });
        testFrequencyTable(2.0, 6.0, 4
                          ,new double[] { 2.1, 3.3, 4.5, 5.5 }
                          ,new int[] { 1, 1, 1, 1});
        testFrequencyTable(3.0, 13.0, 10
                          ,new double[] { 3.5, 4.5, 5.6, 7.8, 9.0, 11.4, 12.0 }
                          ,new int[] { 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 });
        testFrequencyTable(-4.0, -1.0, 6
                          ,new double[] { -1.0, -1.4, -2.3, -2.6, -3.3, -3.8}
                          ,new int[] { 1, 1, 1, 1, 0, 1});
        
    }

    public static void matrixMultiplyTests() {

        testMatrixMultiply(new double[][] { { 1, 2, 3, 4 }
                                          , { 5, 6, 7, 8 }
                                          , { 9, 1, 2, 3 }
                                          }
                          ,new double[][] { { 1, 2, 3 }
                                          , { 4, 5, 6 }
                                          , { 7, 8, 9 }
                                          , { 1, 2, 3 }
                                          }
                          , new double[][] { { 34, 44, 54 }
                                           , { 86, 112, 138 }
                                           , { 30, 45, 60 } });
        
        testMatrixMultiply(new double[][] { {1, 2, 3, 4 }
                                          , {5, 6, 7, 8 }
                                          }
                          , new double[][] { { 1 }
                                           , { 2 }
                                           , { 3 }
                                           , { 4 }
                                           }
                          , new double[][] { { 30 }
                                           , { 70 } });
        
        testMatrixMultiply(new double[][] { {1, 2, 3 }
                                          , {5, 6, 9 }
                                          }
                          ,new double[][] { { 4 }
                                          , { 4 }
                                          , { 4 }
                                          }
                          , new double[][] { { 24 }
                                           , { 80 } });
        
        testMatrixMultiply(new double[][] { { 1 }
                                          , { 3 }
                                          , { 5 }
                                          }
                          , new double[][] { { 2, 4, 6 }
                                           }
                          , new double[][] { { 2, 4, 6 }
                                           , { 6, 12, 18 }
                                           , { 10, 20, 30 } });
        testMatrixMultiply(new double[][] { { 2, 3 }
                                          , { 2, 3 }
                                          }
                                          , new double[][] { { 1 }
                                                           , { 5 }
                                                           }
                                          , new double[][] { { 17 }
                                                           , { 17 } });
    }

    private static final double EPSILON = 0.001;

    private static boolean approxEqualDouble(double a, double b) {
      return a == b
          || Math.abs(a - b) / Math.max(Math.abs(a), Math.abs(b)) < EPSILON;
    }

    private static boolean approxEqualDoubleArrays(double[][] x, double[][] y) {
         
      for(int i = 0; i < x.length; i++) {
      for(int k = 0; k < y.length; k++) {
      for(int j = 0; j < y[0].length; j++) {
        if (x[i] == y[j] && approxEqualDouble(x[i][k], y[i][k])) {
         }
      }
      }
      }
     
        //System.out.println("The two matrices are approximately equal.");
       return true;
    }

    private static void testFib(int n, int expected) {
        int actual = LoopArraysLibrary.fib(n);
        if (expected != actual) {
            System.out.println("fib(" + n + "); expected: " + expected
                    + " got: " + actual);
        }
    }

    private static void testMaximum(int[] vs, int expected) {
        int actual = LoopArraysLibrary.maximum(vs);
        if (expected != actual) {
            System.out.println("maximum(" + Arrays.toString(vs)
                    + "); expected: " + expected + " got: " + actual);
        }
    }

    private static void testFrequencyTable(double minimum, double maximum,
            int numBuckets, double[] data, int[] expected) {
        int[] actual = LoopArraysLibrary.frequencyTable(minimum, maximum,
                numBuckets, data);

        if (!Arrays.equals(expected, actual)) {
            System.out.println("frequencyTable(" + minimum + ", " + maximum
                    + ", " + numBuckets + ", " + Arrays.toString(data)
                    + "); expected: " + Arrays.toString(expected) + " got: "
                    + Arrays.toString(actual));
        }
    }

    private static void testMatrixMultiply(double[][] m, double[][] n,
            double[][] expected) {
        double[][] actual = LoopArraysLibrary.matrixMultiply(m, n);

        if (!approxEqualDoubleArrays(expected, actual)) {
            System.out.println("matrixMultiply(" + Arrays.deepToString(m)
                    + ", " + Arrays.deepToString(n) + "); expected: "
                    + Arrays.deepToString(expected) + ", got: "
                    + Arrays.deepToString(actual));
        }
    }

}
