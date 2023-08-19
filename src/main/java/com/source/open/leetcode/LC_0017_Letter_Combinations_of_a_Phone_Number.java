package com.source.open.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_0017_Letter_Combinations_of_a_Phone_Number {
	
    List<String> res = null;

    String [] strMap = {"0","1","abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    
	/*
	 * Runtime Details 0ms 		Beats 100%   of users with Java
	 * Memory  Details 40.7MB 	Beats 98.97% of users with Java
	*/
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        dfs(0,digits,new StringBuilder());
        return res;
    }

    void dfs(int length ,String digits,StringBuilder temp){

        if(length == digits.length()){
            res.add(temp.toString());
            return; 
        }

        char ch = digits.charAt(length);
        String str = strMap[ch -'0'];

        for(char c:str.toCharArray()){
            temp.append(c);
            dfs(length+1,digits,temp);
            temp.deleteCharAt(temp.length()-1);
        }

    }
}