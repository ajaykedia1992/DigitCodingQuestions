
import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		int arr[] = { 10, 2, -2, -20, 10 };
		int n = arr.length;
		int sum = -22;

		subArraySum(arr, n, sum);

	}

	// Function to print subarray with sum as given sum
	static void subArraySum(int arr[], int n, int sum) {
		// create an empty map

		Map<Integer, Integer> map = new HashMap<>();
		// Maintains sum of elements so far
		int curr_sum = 0;

		for (int i = 0; i < n; i++) {
			curr_sum = curr_sum + arr[i];
			if (curr_sum == sum) {
				System.out.println("Sum found between indexes 0 to" + i);
				return;
			}
			if (map.containsKey(curr_sum - sum)) {
				System.out.println("Sum found between indexes " + (map.get(curr_sum - sum) + 1) + " to " + i);
				return;
			}
			map.put(curr_sum, i);

		}
		System.out.println("No subarray with given sum exists");

	}

}