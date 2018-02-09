import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int getSum(int number) { // 31
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int i = 5;
		while (i < number) {
			map.put(i, 1);
			i += 5;
		}
		i = 6;
		while (i < number) {
			map.put(i, 1);
			i += 6;
		}
		int sum = 0;
		for (Integer key : map.keySet()) {
			System.out.print(key + " ");
			sum += key;
		}
		System.out.println();
		return sum;
	}

	public static void main(String args[]) {
		int N = 326670;
		Solution s = new Solution();
		int sum = s.getSum(N);
		System.out.println(sum);
	}
}
