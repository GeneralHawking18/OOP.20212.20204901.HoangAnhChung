import java.util.function.BiFunction;  
import java.util.Arrays;

public class DVDUtils {
	public static byte compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (dvd1.getCost() > dvd2.getCost()) {
			return 1;
		} else {
			if (dvd1.getCost() < dvd2.getCost()) {
				return -1;
			} else {
				return 0;
			}
		}
	}
	
	public static byte compareByLength(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (dvd1.getLength() > dvd2.getLength()) {
			return 1;
		} else {
			if (dvd1.getCost() < dvd2.getCost()) {
				return -1;
			} else {
				return 0;
			}
		}
	}
	
	public static byte compareByGeneral(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		byte val1 = compareByCost(dvd1, dvd2);
		byte val2 = compareByTitle(dvd1, dvd2);
		byte val3 = compareByLength(dvd1, dvd2);
		
		
		int compared_val = val1 * 3 * 3 + val2 * 3 + val3 * 1;
		if (compared_val > 0) {
			return 1;
		} else {
			if (compared_val < 0) {
				return -1;
			} else {
				return 0;
			}
		}
	}
	
	public static byte compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		int value = dvd1.getTitle().compareToIgnoreCase(dvd2.getTitle());
		if (value > 0) {
			return 1;
		} else {
			if (value < 0) {
				return -1;
			} else {
				return 0;
			}
		}
	}
	
	public static int partitionASC(DigitalVideoDisc[] arr, int left, int right, BiFunction<DigitalVideoDisc, DigitalVideoDisc, Byte> comparer) {
		int pivot = right;
		int i = left - 1;
		for (int j = left; j < right; j++) {
			byte val = (byte) comparer.apply(arr[j], arr[pivot]);
			// Generalize the comparison byte by a method reference
					
			if (val <= 0) {
				i++;
				swapInArr(arr, i, j);
			}
		}
		swapInArr(arr, i + 1, right);
		return i + 1;
	}
	public static int partitionDESC(DigitalVideoDisc[] arr, int left, int right, BiFunction<DigitalVideoDisc, DigitalVideoDisc, Byte> comparer) {
		int pivot = right;
		int i = left - 1;
		for (int j = left; j < right; j++) {
			byte val = (byte) comparer.apply(arr[j], arr[pivot]);
			// Generalize the comparison byte by a method reference
					
			if (val >= 0) {
				i++;
				swapInArr(arr, i, j);
			}
		}
		swapInArr(arr, i + 1, right);
		return i + 1;
	}
	
	public static void quickSortASC(DigitalVideoDisc[] arr, int left, int right, BiFunction<DigitalVideoDisc, DigitalVideoDisc, Byte> comparer) {
		if (left < right) {
			int mid = partitionASC(arr, left, right, comparer);
			quickSortASC(arr, left, mid - 1, comparer);
			quickSortASC(arr, mid + 1, right, comparer);
		}
	}
	public static void quickSortDESC(DigitalVideoDisc[] arr, int left, int right, BiFunction<DigitalVideoDisc, DigitalVideoDisc, Byte> comparer) {
		if (left < right) {
			int mid = partitionDESC(arr, left, right, comparer);
			quickSortDESC(arr, left, mid - 1, comparer);
			quickSortDESC(arr, mid + 1, right, comparer);
		}
	}
	
	
	public static void swapInArr(DigitalVideoDisc[] arr, int i, int j) {
		// Every argument in array is an attribute of array. Then, we can use swap as usual.
		DigitalVideoDisc temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static DigitalVideoDisc[] sort(DigitalVideoDisc[] dvdList, BiFunction<DigitalVideoDisc, DigitalVideoDisc, Byte> comparer) {
		// Create a method reference that maps (dvd1, dvd2) -> Byte
		DigitalVideoDisc[] temp = Arrays.copyOf(dvdList, dvdList.length);
		quickSort(temp, 0, temp.length - 1, comparer);
		return temp;
	}
	
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvdList) {
		BiFunction<DigitalVideoDisc, DigitalVideoDisc, Byte> comparer = DVDUtils::compareByCost; 
		// Create a method reference that maps (dvd1, dvd2) -> Byte
		return sort(dvdList, comparer);
	}
	
	public static DigitalVideoDisc[] sortByLength(DigitalVideoDisc[] dvdList) {
		BiFunction<DigitalVideoDisc, DigitalVideoDisc, Byte> comparer = DVDUtils::compareByLength; 
		// Create a method reference that maps (dvd1, dvd2) -> Byte
		return sort(dvdList, comparer);
	}
	
	public static DigitalVideoDisc[] sortByGeneral(DigitalVideoDisc[] dvdList) {
		BiFunction<DigitalVideoDisc, DigitalVideoDisc, Byte> comparer = DVDUtils::compareByGeneral; 
		
		// Create a method reference that maps (dvd1, dvd2) -> Byte
		return sort(dvdList, comparer);
	}
	
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvdList, int a) {
		BiFunction<DigitalVideoDisc, DigitalVideoDisc, Byte> comparer = DVDUtils::compareByCost; 
		// Create a method reference that maps compare(dvd1, dvd2) -> Byte
		DigitalVideoDisc[] temp = Arrays.copyOf(dvdList, dvdList.length);
		quickSort(temp, 0, temp.length - 1, comparer);
		return temp;
	}
}
