import java.util.*;

public class Bogo {

    public static boolean isSorted(int[] isSorted) {

	for (int i = 0; i < isSorted.length; i++) {
	    for (int j = i; j < isSorted.length; j++) {

		if (isSorted[i] > isSorted[j])
		    return false;
	    }
	}

	return true;
    }

    public static int factorial(int n) {

	int result = 1;
	for (int i = 1; i <= n; i++)
	    result = result * i;

	return result;
    }

    public static void shuffle(int[] array) {

	Random rnd = new Random();
	int index;

	for (int i = array.length - 1; i > 0; i--) {

	    index = rnd.nextInt(i + 1);
	    if (index != i) {

		array[index] ^= array[i];
		array[i] ^= array[index];
		array[index] ^= array[i];
	    }
	}
    }

    public static int bogoTime(int[] toBogo) {

	int counter = 0;

	while (!isSorted(toBogo)) {

	    shuffle(toBogo);
	    //System.out.println("Iteration: " + counter + " Order: " + asString(toBogo));
	    counter++;
	}

	System.out.println("Runs: " + counter);
	return counter;
    }

    public static String asString(int[] toConvert) {

	String output = "{";

	for(int i = 0; i < toConvert.length; i++) {

	    output = output + toConvert[i];
	    if (i != (toConvert.length - 1))
		output = output + ",";
	}

	return output + "}";
    }

    public static int[] createNArray(int n) {

	int[] array = new int[n];
	for (int i = 0; i < n; i++) {
	    
	    array[i] = i;
	}

	return array;
    }

public static void main(String[] args) {

    int[] bogo = createNArray(11);
    //shuffle(bogo);
    System.out.println("Approximate runs to completion: " + factorial(bogo.length));

    int runs = 5;
    int totalCount = 0;
    long runTime = 0;

    for (int i = 0; i < runs; i++) {

	shuffle(bogo);
	long start = System.currentTimeMillis();
	totalCount += bogoTime(bogo);
	long end = System.currentTimeMillis();

	runTime += (end - start);
    }

    System.out.println("Average complexit over " + runs + " runs with " + bogo.length + " elements is: " + totalCount/runs);
    runTime /= runs;
    float duration = ((float) runTime) / 1000;
    System.out.println("Averge duration of " + duration + " seconds");
}
}
