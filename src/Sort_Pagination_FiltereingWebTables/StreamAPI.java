package Sort_Pagination_FiltereingWebTables;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StreamAPI {

	public static void main(String[] args) {
		String[] names = { "Albert Einstein", "Issac Newton", "Jabir ibne Hayyan", "Ibne Sina", "J.J Thomson",
				"Georg Simon Ohm" };

		String[] newNames = { "Nikola Tesla", "Thomas Alva Edison", "Louis Pasteur" };

		Integer[] numbers = { 2, 35, 6, 8, 4, 5, 6, 75, 45, 34, 4, 3, 2, 12, 5, 76 };

//		sorted_ForEach(names);
//		startWithLetter(names);
//		namesWithLengthmorethan14char(names);
//		getFirstIndexAfterFilterSortedandConvertToUpperCase(names);
//		concatTwoArrays(names, newNames);
		getUniquevaluesAndSorttedThem(numbers);
	}

	@Test
	public static void sorted_ForEach(String[] names) {

		// convert array into arraylist

		List<String> scientistName = Arrays.asList(names);

		scientistName.stream().sorted().forEach(n -> System.out.println(n));
	}

	@Test
	public static void startWithLetter(String[] names) {
		List<String>  scientistNames = Arrays.asList(names);
		scientistNames.stream().filter(n -> ((String) n).startsWith("J")).forEach(p -> System.out.println(p));
	}

	@Test
	public static void namesWithLengthmorethan14char(String[] names) {
		List<String>  scientistNames = Arrays.asList(names);
		scientistNames.stream().filter(n -> ((String) n).length() > 14).forEach(p -> System.out.println(p));
	}

	@Test
	public static void getFirstIndexAfterFilterSortedandConvertToUpperCase(String[] names) {
		List<String>  scientistNames = Arrays.asList(names);
		scientistNames.stream().filter(n -> ((String) n).endsWith("n")).map(g -> ((String) g).toUpperCase()).sorted()
				.limit(1).forEach(p -> System.out.println(p));
	}

	@Test
	public static void concatTwoArrays(String[] names, String[] newNames) {
		List<String>  scientistNames = Arrays.asList(names);
		List<String>  scientistNewNames = Arrays.asList(newNames);
		List<String> newScientistNames = (List<String>) Stream
				.concat(scientistNames.stream(), scientistNewNames.stream()).collect(Collectors.toList());
		for (int i = 0; i < newScientistNames.size(); i++) {
			System.out.println(newScientistNames.get(i));
		}
	}

	@Test
	public static void getUniquevaluesAndSorttedThem(Integer[] numbers) {
		List<Integer> numberList = Arrays.asList(numbers);
		numberList.stream().distinct().sorted().forEach(n -> System.out.println(n));
	}
}
