package com.source.open.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_0040_Combination_Sum_II {

	/*
	 * Runtime Details 2ms 		Beats 99.77% of users with Java
	 * Memory  Details 42.5MB 	Beats 56.97% of users with Java
	*/	
    public List<List<Integer>> combinationSum2(int[] c, int target) {        
    	Arrays.sort(c);

    	List<List<Integer>> res = new ArrayList<>();

        recurse(0, target, c, new ArrayList<Integer>(), res);

        return res;        
    }
    
    public void recurse(int start, int target, int[] c, ArrayList<Integer> ans, List<List<Integer>> res) {

        if(target == 0) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }

        for (int i = start; i < c.length; i++) {
            if(i != start && c[i] == c[i - 1]) continue;
            if(c[i] > target) break;

            ans.add(c[i]);
            recurse(i+1, target - c[i], c, ans, res);
            ans.remove(ans.size() - 1);
        }
    }    
    
}
