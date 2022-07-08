package bobur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Strig {

	/*
	 * 1. Brute-Force 2. For-each loop 3. Predicate 4. w Data Structures 5. w
	 * Ternary 6. w Streams
	 *
	 *
	 */

	public static void main(String[] args) {

		String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};

		int k = 4;

		Map<String, Integer> mapped = mapThis(words);

		List<Integer> theList = listThis(mapped, k);

		List<String> topKFrequent = new ArrayList<>();

		for (String key : mapped.keySet()) {

			if (theList.contains(mapped.get(key))) {

				topKFrequent.add(key);

			}

		}

		topKFrequent = sortedList(topKFrequent);

		for (String s : topKFrequent) {

			System.out.print(s + ", ");
		}

	}

	public static List<String> sortedList(List<String> list) {

		String[] tempArray = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {

			tempArray[i] = list.get(i);
		}

		Arrays.sort(tempArray);

		for (int i = 0; i < list.size(); i++) {

			list.set(i, tempArray[i]);
		}
		

		return list;
	}

	public static List<Integer> listThis(Map<?, Integer> map, int k) {

		Collection<Integer> freqValues = map.values();

		List<Integer> modList = new ArrayList();

		modList.addAll(freqValues);

		modList.sort(Comparator.naturalOrder());

		modList = modList.subList(modList.size() - k, modList.size());

		return modList;

	}

	public static Map<String, Integer> mapThis(String[] words) {

		Map<String, Integer> freq = new HashMap<>();

		for (String word : words) {

			if (freq.containsKey(word)) {

				freq.put(word, freq.get(word) + 1);
			} else {

				freq.put(word, 1);
			}

		}

		return freq;

	}

}
