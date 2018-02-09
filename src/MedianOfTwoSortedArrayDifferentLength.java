import java.util.Arrays;

public class MedianOfTwoSortedArrayDifferentLength {

	public static void main(String[] args) {
		int a[] = { 1, 3, 8, 9, 15 };
		int b[] = { 7, 12, 19, 21, 18, 25 };
		Arrays.sort(a);
		Arrays.sort(b);
		MedianOfTwoSortedArrayDifferentLength m = new MedianOfTwoSortedArrayDifferentLength();
		double result = m.getMedian(a, b);
		System.out.println(result);
	}

	private double getMedian(int[] a, int[] b) {
		if (a.length > b.length) {
			return getMedian(b, a);
		}
		int x = a.length;
		int y = b.length;

		int low = 0;
		int high = x;
		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : a[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : a[partitionX];
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : b[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : b[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((x + y) % 2 == 0) {
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY) / 2);
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			}

			if (maxLeftX > minRightY) {
				high = partitionX - 1;
			} else {
				low = partitionX + 1;
			}
		}
		
		throw new IllegalArgumentException();
	}
}
