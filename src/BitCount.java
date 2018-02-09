
public class BitCount {

	public static void main(String[] argv) throws Exception {
		int no = 3;
		int count;
		for (count = 0; no > 0; ++count) {
			no =  no & (no - 1);
		}
		System.out.println(count);
	}
}