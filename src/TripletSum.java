import java.util.HashSet;
import java.util.Set;

public class TripletSum {

	public static void main(String args[]) {
		int arr[] = { 0, -1, 2, -3, 1 };
		TripletSum t = new TripletSum();
		t.getTripletSum(arr);
	}

	private void getTripletSum(int[] arr) {
		boolean found = false;
		for (int i = 0; i < arr.length - 1; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = i + 1; j < arr.length; j++) {

				int x = -(arr[i] + arr[j]);
				if (set.contains(x)) {
					System.out.println(x + " " + arr[i] + " " + arr[j]);
					found = true;
				} else {
					set.add(arr[j]);
				}

			}
		}
		if (found == false) {
			System.out.println("No triplet found");
		}
	}
}
