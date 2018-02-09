
public class AverageOfRunningStream {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		AverageOfRunningStream a = new AverageOfRunningStream();
		a.calculateRunningStream(arr, arr.length);
	}

	private void calculateRunningStream(int[] arr, int length) {
		double average = 0.0d;
		int sum = 0;
		for(int i = 0 ; i<length; i++) {
			sum += arr[i];
			average = (double)sum/(i+1);
			System.out.print(average + " ");
		}
		
	}
}
