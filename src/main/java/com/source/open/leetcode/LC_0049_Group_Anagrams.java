package com.source.open.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_0049_Group_Anagrams {

	/*
	 * Runtime Details 6ms 	  	Beats 89.34% of users with Java 
	 * Memory  Details 46.9MB	Beats 72.72% of users with Java
	 */
	public List<List<String>> groupAnagramsOptimized(String[] strs) {

		Map<String, List<String>> map = new HashMap<>();

		for (String s : strs) {

			char[] letters = s.toCharArray();

			Arrays.sort(letters);

			String key = new String(letters);

			List<String> list;

			if (map.containsKey(key))
				list = map.get(key);
			else {
				list = new ArrayList<String>();
				map.put(key, list);
			}
			list.add(s);
		}

		return new ArrayList<>(map.values());
	}

	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> res = new ArrayList<>();

		if (strs.length == 0)
			return res;

		int[][] alphabet = new int[strs.length][26];

		int anagrams = 0;

		for (int i = 0; i < strs.length; i++) {

			int[] c = new int[26];
			String word = strs[i];

			for (int j = 0; j < word.length(); j++)
				c[word.charAt(j) - 'a']++;

			boolean found = false;
			for (int k = 0; k < anagrams; k++) {
				if (Arrays.equals(alphabet[k], c)) {
					res.get(k).add(word);
					found = true;
					break;
				}
			}
			if (!found) {
				List<String> list = new ArrayList<>();
				list.add(word);
				res.add(list);
				alphabet[anagrams] = c;
				anagrams++;
			}
		}

		// System.out.println(res)

		return res;
	}
}
