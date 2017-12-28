package problems;

public class BitInsertNumberInOther {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("1 : " + representAsBitNumbers(1));
		// System.out.println("2 : " + representAsBitNumbers(2));
		// System.out.println("3 : " + representAsBitNumbers(3));
		//
		// System.out.println("m= " + representAsBitNumbers(19));
		// System.out.println("n= " + representAsBitNumbers(1024));
		// // System.out.println("1= "+representAsBitNumbers(1<<31));
		// System.out.println("o= " + representAsBitNumbers(insert(19, 1024, 6, 2)));
		// // System.out.println("o= " +representAsBitNumbers(1100));
		// System.out.println(representAsBitNumbers(getAllOnesFromJToI(19, 1024, 6,
		// 2)));
		// System.out.println(representAsBitNumbers(convertFromOnesToZeros(getAllOnesFromJToI(19,
		// 1024, 6, 2))));
		// System.out.println("n="+representAsBitNumbers(intelliInsert(19, 1024, 6,
		// 2)));
		// System.out.println("m= " + representAsBitNumbers(19));
		// System.out.println("0.72= "+representAsBitNumbers(0.72));
	}

	static int intelliInsert(int m, int n, int j, int i) {
		// get only ones at the space between j and i
		int onesFromItoJ = getAllOnesFromJToI(m, n, j, i);
		int zerosFromItoJ = convertFromOnesToZeros(onesFromItoJ);
		return n & zerosFromItoJ;
	}

	static int getAllOnesFromJToI(int m, int n, int j, int i) {
		int onesFromItoJ = 0;
		for (int index = j; index >= i; index--) {
			onesFromItoJ |= (1 << index);
		}
		// System.out.println(onesFromItoJ);
		return onesFromItoJ;

	}

	static int convertFromOnesToZeros(int number) {
		return number ^ Integer.MAX_VALUE;
	}

	static int insert(int m, int n, int j, int i) {
		// Getting m left 1 index
		int mIndex = 0;
		for (int h = 31; h > 0; h--) {
			if ((m & (1 << h)) > 0) {
				mIndex = h;
				break;
			}
		}

		for (int index = j; index >= i; index--) {

			int mBitElement = (m & (1 << mIndex));
			n |= (mBitElement << (index - mIndex));
			mIndex--;
		}
		return n;
	}

	static String representAsBitNumbers(int n) {
		StringBuilder bits = new StringBuilder();

		for (int i = 0; i < 32; i++) {
			if ((n & (1 << i)) > 0) {
				bits.append("1 ");
			} else {
				bits.append("0 ");
			}
		}

		return bits.reverse().toString();
	}

	static String represetDoubleAsBit(double n) {
		if (n > 1 || n < 0)
			return "ERROR";
		StringBuilder sb = new StringBuilder();
		sb.append("0.");

		while (n > 0) {
			if (sb.length() >= 32) {
				return "ERROR";
			}
			double r = 2 * n;
			if (r > 1) {
				sb.append(1);
				n = r - 1;
			} else {
				sb.append(0);
				n = r;
			}
		}
		return sb.toString();
	}

}
