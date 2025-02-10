import java.util.*;

public class Task7 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }
            
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
       Task7 finder = new Task7();
        System.out.println(finder.findAnagrams("cbaebabacd", "abc")); // Output: [0, 6]
        System.out.println(finder.findAnagrams("abab", "ab")); // Output: [0, 1, 2]
    }
}
