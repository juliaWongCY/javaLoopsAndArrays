public class LoopArraysLibrary {

    public static int fib(int n) {
     assert (n >= 0) : "n must be positive."; 
     if (n < 2) {
      return n;
      } 
      int f1 = 0;
      int f2 = 1;
      for (int i = 0; i < n; i++) { 
      int f3 = f1 + f2;
      f1 = f2;
      f2 = f3;      
      }    
       return f1;
    }


    public static int maximum(int[] ms) {
      assert (ms.length > 0) : 
        "the list must not be empty";
      int max = ms[0];
      for(int i = 1; i < ms.length; i++) {
        if (ms[i] > max) {
        max = ms[i];
        }
      }
         return max;     
    }



    public static int[] frequencyTable(double minimum, double maximum,
            int numBuckets, double[] data) {
  
      double interval = ((maximum - minimum) / numBuckets);
      double[] range = new double[numBuckets + 1];
      int[] array = new int[numBuckets];

      for(int i = 0; i <= numBuckets; i++) {
        range[i]  = minimum + (interval * i);
      }

      for(int j = 0; j < numBuckets; j++) { 
      for(double val : data) {
        if (val >= range[j] && val < range[j + 1]) {
        array[j] += 1;

				}
			}
		}
       return array;
   }



    public static double[][] matrixMultiply(double[][] m, double[][] n) {
       

      int row           = m[0].length;
      int resultRow     = m.length;
      int resultColumn  = n[0].length;
      double[][] result = new double[resultRow][resultColumn];
      
      
      for(int i = 0; i < resultRow; i++) {
        for(int j = 0; j < resultColumn; j++) {
        	for(int k = 0; k < row ; k++ ) {
            result[i][j] += (m[i][k] * n[k][j]);
        	}
        }
      }    
    
     return result;
    }




}


