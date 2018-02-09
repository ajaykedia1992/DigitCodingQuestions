import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfRunningStream {

	public static void main(String args[]) {
		MedianOfRunningStream m = new MedianOfRunningStream();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int N = arr.length;
		m.getMedian(arr, N);
	}

	private void getMedian(int[] arr, int N) {
		PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				return -1 * a.compareTo(b);
			}
		});
		PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
		double medians[] = new double[N];
		for (int i = 0; i < N; i++) {
			int number = arr[i];
			createHeap(number, lowers, highers);
			rebalanceHeap(lowers, highers);
			medians[i] = getMedian(lowers, highers);
		}

		print(medians);
	}

	private void print(double[] medians) {
		for (int i = 0; i < medians.length; i++) {
			System.out.println(medians[i]);
		}

	}

	private double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

		if (biggerHeap.size() == smallerHeap.size()) {
			return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
		} else {
			return biggerHeap.peek();
		}
	}

	private void rebalanceHeap(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
		if (biggerHeap.size() - smallerHeap.size() >= 2) {
			smallerHeap.add(biggerHeap.poll());
		}

	}

	private void createHeap(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if (lowers.size() == 0 || number < lowers.peek()) {
			lowers.add(number);
		} else {
			highers.add(number);
		}

	}
}
