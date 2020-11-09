
public class Merging {
	
	public static int[] mergeSort(int[] array) {
		if (array.length > 1) {
			int[] array1 = new int[array.length/2];
			int[] array2 = new int[array.length - array1.length];
			
			for (int i=0; i<array1.length;i++) {
				array1[i] = array[i];
			}
			for (int i=0; i<array2.length;i++) {
				array2[i] = array[array1.length+i];
			}
			
			for (int i=0; i<array1.length-1; i++) {
				for (int j=0; j<array1.length-i-1; j++) {
					if (array1[j]> array[j+1]) {
						int temp = array1[j];
						array1[j] = array1[j+1];
						array1[j+1] = temp;
					}
				}
			}
			for (int i : array1) {
			System.out.println(i);}
			for (int i=0; i<array2.length-1; i++) {
				for (int j=0; j<array2.length-i-1; j++) {
					if (array2[j]> array2[j+1]) {
						int temp = array2[j];
						array2[j] = array2[j+1];
						array2[j+1] = temp;
					}
				}
			}
			for (int i : array2) {
			System.out.println(i);}
			for (int k=0; k<array.length; k++) {
			for (int i=0; i< array2.length-1; i++) {
				for (int j=0; j<array1.length-i-1; j++) {
					if (array1[j]>array2[i]) {
						array[i] = array2[i];
					}else {
						array[k] = array1[j];
					}
				}
			}
			}
		}
		return array;
	}


	public static void main(String[] args) {
		int[] t = {5,6,2,3,9,8,5,4,23,25,56,24};
		int[] h = mergeSort(t);
		for (int i: h) {
		System.out.println(i);}
	}

}
