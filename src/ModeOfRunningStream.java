import java.util.HashMap;
import java.util.Map;

public class ModeOfRunningStream {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 2, 3, 1, 4, 5, 3, 5, 4, 2, 9 };
		ModeOfRunningStream m = new ModeOfRunningStream();
		m.calculateModeOfRunningStream(arr, arr.length);
	}

	private void calculateModeOfRunningStream(int[] arr, int length) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}

			int count = map.get(arr[0]);
			int mode = arr[0];
			for (Integer key : map.keySet()) {

				if (map.get(key) > count) {
					mode = key;
				}
			}
			System.out.print(mode + " ");
		}

	}
}
