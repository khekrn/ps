package array;

import java.util.*;

/**
* 
* Given an arbitrary ransom note string and another string containing letters from all the magazines,
* write a function that will return true if the ransome note can be constructed from the magazines.
* Otherwise, it will return false
*
* Note: Each letter in the magazine string can only be used once in your ransome nore. You may assume 
* that both strings contain only lowercase letters.
*
* Examples:
* canConstruct("a", "b") -> false
* canConstruct("aa", "ab") -> false
* canConstruct("aa", "aab") -> true
*/


public class RansomNote {
	
	// UnOptimized Version O(N^2)
	public boolean canConstruct(String ransom, String magazines){
		var charList = new ArrayList<Character>();
		for(Character ch : magazines.toCharArray()){
			charList.add(ch);
		}
		var result = true;
		for(Character ch: ransom.toCharArray()){
			if(charList.contains(ch)){
				charList.remove(ch);
			}else{
				result = false;
				break;
			}
		}
		return result;
	}
	
	// Optimized Version O(N)
	public boolean canConstructV2(String ransom, String magazines){
		var dictMap = new HashMap<Character, Integer>();
		for(Character ch : magazines.toCharArray()){
			dictMap.put(ch, dictMap.getOrDefault(ch, 0)+1);
		}
		
		var result = true;
		for(Character ch : ransom.toCharArray()){
			if(dictMap.containsKey(ch)){
				var count = dictMap.get(ch);
				count -= 1;
				if (count == 0){
					dictMap.remove(ch);
				}
			}else{
				result = false;
				break;
			}
		}
		return result;
	}
	
	
	
	public static void main(String[] args){
		var rn = new RansomNote();
		System.out.println(rn.canConstruct("a", "b"));
		System.out.println(rn.canConstruct("aa", "ab"));
		System.out.println(rn.canConstruct("aa", "aab"));
		
		System.out.println("Running V2\n");
		
		System.out.println(rn.canConstructV2("a", "b"));
		System.out.println(rn.canConstructV2("aa", "ab"));
		System.out.println(rn.canConstructV2("aa", "aab"));
		System.out.println(rn.canConstructV2("abcc", "aabbcc"));
		System.out.println(rn.canConstructV2("abcdeff", "aabcdeff"));
	}
	
}


