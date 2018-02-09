
public class PalindromicNumber {

	public static void main(String args[]) {
		int number = 151;
		PalindromicNumber r = new PalindromicNumber();
		boolean status = r.isReverse(number);
		System.out.println(status);
	}

	private boolean isReverse(int number) {
		if (number / 10 == 0) {
			return false;
		}
		int rem = 0;
		while (number > rem) {
			rem = rem * 10 + number % 10;
			number = number / 10;
		}

		if (rem / 10 == number || number == rem) {
			return true;
		}
		return false;
	}
}
