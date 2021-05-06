import java.util.ArrayList;
import java.util.Arrays;

public class Homework {

	//2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
	public static int[] findAfterFour(int[] values) {

		if (values == null || values.length == 0) {
			throw new RuntimeException("Array cannot be empty");
		}

		int index = -1;
		for (int i = values.length - 1; i >=0; i--) {
			if (values[i] == 4) {
				index = i + 1;
				break;
			}
		}

		if (index == -1) {
			throw new RuntimeException("There was not found 4");
		}

		int[] copied = new int[values.length - index];
		System.arraycopy(values, index, copied, 0, copied.length);
		return copied;
	}

	//3. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).

	public static boolean isContainOneAndFour (int[] array) {
		ArrayList<Integer> required = new ArrayList(Arrays.asList(new Integer[] {1, 4}));
		if (array != null && array.length != 0) {
			for (int i : array) {
				if (required.contains(Integer.valueOf(i))) {
					required.remove(Integer.valueOf(i));
					if (required.isEmpty()) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
