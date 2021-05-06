
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

public class HomeworkTest {

	@ParameterizedTest
	@NullAndEmptySource
	public void shouldReturnRuntimeExceptionWhenArrayIsEmpty (int[] values) {
		Assertions.assertThrows(RuntimeException.class, () -> Homework.findAfterFour(values));
	}

	@ParameterizedTest
	@MethodSource("intValuesWithoutFour")
	public void shouldReturnRuntimeExceptionWhenFourNotFound (int[] values) {
		Assertions.assertThrows(RuntimeException.class, () -> Homework.findAfterFour(values));
	}

	@ParameterizedTest
	@MethodSource("intValues")
	public void shouldReturnValuesAfterLastFour (int[] expected, int[] real) {
		Assertions.assertArrayEquals(expected, Homework.findAfterFour(real));
	}

	private static Stream<Arguments> intValuesWithoutFour() {
		return Stream.of(
				Arguments.arguments(new int[] {1, 2, 8, 16, 32, 64, 128, 256, 512, 1024}),
				Arguments.arguments(new int[] {0, 1, 2, 3}),
				Arguments.arguments(new int[] {1, -4, 5, 14, 44}),
				Arguments.arguments(new int[] {0})
		);
	}

	private static Stream<Arguments> intValues() {
		return Stream.of(
				Arguments.arguments(new int[] {5, 6, 7}, new int[] {1, 2, 3, 4, 5, 6, 7}),
				Arguments.arguments(new int[] {}, new int[] {4}),
				Arguments.arguments(new int[] {}, new int[] {1, 4, 2, 4, 3, 4}),
				Arguments.arguments(new int[] {10, 11, 9}, new int[] {-10, 4, 4, 4, 5, 4, 10, 11, 9})
		);
	}

	// Тест к заданию №2

	@ParameterizedTest
	@MethodSource("oneOrFourParameters")
	public void shouldReturnTrueIfArrayContainOneOrFour(boolean expected, boolean actual) {
		Assertions.assertEquals(expected, actual);
	}

	public static Stream<Arguments> oneOrFourParameters() {
		return Stream.of(
				Arguments.arguments(false, Homework.isContainOneAndFour(new int[] {})),
				Arguments.arguments(false, Homework.isContainOneAndFour(new int[] {0})),
				Arguments.arguments(false, Homework.isContainOneAndFour(new int[] {1})),
				Arguments.arguments(false, Homework.isContainOneAndFour(new int[] {4})),
				Arguments.arguments(true, Homework.isContainOneAndFour(new int[] {1, 120, 4})),
				Arguments.arguments(true, Homework.isContainOneAndFour(new int[] {4, -5, 1})),
				Arguments.arguments(true, Homework.isContainOneAndFour(new int[] {4, 1})),
				Arguments.arguments(false, Homework.isContainOneAndFour(null))
		);
	}
}
