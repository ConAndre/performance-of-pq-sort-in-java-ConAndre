import java.nio.charset.Charset;
import java.util.Random;

/*
 * DO NOT ALTER THIS CODE!
 */
public class PerformanceTest {
	static final int TIMES_TO_TEST = 10;
	
	public static long TimeForSortingNStrings(int N) throws Exception {
		
		MyPQSort mySort = new MyPQSort();
		String[][] stringsToSort = new String[TIMES_TO_TEST][N];
		
		for (int i = 0; i < TIMES_TO_TEST; i++) {
			stringsToSort[i] = getNRandomStrings(N);
		}

		long totalTime = 0;
		
		for (int i = 0; i < TIMES_TO_TEST; i++) {
			System.out.println(stringsToSort[i][0]);
			long startTime = System.nanoTime();
			String[] sortedStrings = mySort.sort(stringsToSort[i]);			
			long endTime = System.nanoTime();
			totalTime += (endTime - startTime);
			if (!isSorted(sortedStrings)) {
				throw new Exception("This list of strings is not sorted.");
			}
		}
		
		
		return totalTime / TIMES_TO_TEST;		
	}
	
	private static boolean isSorted(String[] sortedStrings) {		
		for (int i = 1; i < sortedStrings.length; i++) {
			if (sortedStrings[i-1].compareTo(sortedStrings[i]) > 0) {
				return false;
			}
		}

		return true;
	}

	private static String[] getNRandomStrings(int N) {
		String[] returnValue = new String[N];
		for (int i=0; i<N; i++) {
			returnValue[i] = generateOneRandomString();
		}
		return returnValue;
	}
	
	private static String generateOneRandomString() {
	    byte[] array = new byte[10]; 
	    new Random().nextBytes(array);
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	    return generatedString;
//	    return new String(array, Charset.forName("UTF-8"));
	}

	public static void main(String[] args) throws Exception {
		int[] lengthsToTest = {1, 10, 100, 1000, 10000, 100000, 1000000};
		
		for (int length : lengthsToTest) {
			System.out.println(length + "," + TimeForSortingNStrings(length));
		}
		
	}
}
