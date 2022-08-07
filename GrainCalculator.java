import java.text.NumberFormat;

/**
 * @author Arash
 *
 */
public class GrainCalculator {
	public static void main(String[] args) {
//	    int k = 5; //k=0 causes overflow aka infinite recursion
		long grain = 1;
		for (int k = -3; k <= 20; k++) {
			System.out.println("The total grains needed for a total of " + k + " people: "
					+ NumberFormat.getInstance().format(getTotalGrain(k, grain)));
		}
	}

	public static long getTotalGrain(int k, long grains) {
		long tempValue = grains;
		// validate input
		if (k >= 1 && grains >= 0) {
			if (k != 1)
				tempValue += getTotalGrain(k - 1, tempValue * 2);
			else
				return grains;
		}
		return tempValue;
	}
// without validation
//	public static long getTotalGrain(int k, long grains) {
//		if (k == 1)
//			return grains;
//		else
//			return grains += getTotalGrain(k - 1, grains * 2);
//	}
}
