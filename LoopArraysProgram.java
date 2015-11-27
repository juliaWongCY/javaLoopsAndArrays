public class LoopArraysProgram {

	public static void main(String[] args) {

		System.out
				.println("Please enter the size of your data (n) set followed by n numbers to visualise: ");

		int size = IOUtil.readInt();
		double[] data = new double[size];

		for (int i = 0; i < size; i++) {
			data[i] = IOUtil.readDouble();
		}

		System.out
				.println("Please enter a minimum, maximum and number of buckets to print a histogram with: ");

		double min = IOUtil.readDouble();
		double max = IOUtil.readDouble();
		int numBuckets = IOUtil.readInt();

		int[] result = LoopArraysLibrary.frequencyTable(min, max, numBuckets,
				data);

		
		int frequencyMax = LoopArraysLibrary.maximum(result);

		System.out.println("y");
		System.out.println("^");
		System.out.println("|");
		

		for (int i = frequencyMax; i > 0; i--) {
			System.out.print("|");
			
			for (int j = 0; j < numBuckets; j++) {
				if (result[j] >= i) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		System.out.print("+");
		for (int k = 0; k < numBuckets; k++) {
			System.out.print("-");

		}
		System.out.println(" >x");		
		System.out.println("    Bucket     | Frequency");
		System.out.println("--------------------------");
		
		
		double[] range = new double[numBuckets + 1];
		
		double interval = ((max - min) / numBuckets);
		for(int i = 0; i <= numBuckets; i++) {
	        range[i]  = min + (interval * i);
	      }
		
		for (int l = 0; l < numBuckets; l++) {
		System.out.println(range[l] + " <= " + "i" + " < " + range[l+1] + "  |" + "   " + result[l]); 
		}
		
	}

}
