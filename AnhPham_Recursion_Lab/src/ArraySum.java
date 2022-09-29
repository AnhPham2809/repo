
public class ArraySum {
	public int sumOfArray (Integer[] a, int index) {
		if(index == 0) {
			return a[index];
		}
		return a[index] + sumOfArray(a, --index);
	}
}
