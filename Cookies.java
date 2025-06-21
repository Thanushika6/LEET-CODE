import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);  
        Arrays.sort(s);  

        int i = 0; // Pointer for children
        int j = 0; // Pointer for cookies

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++; // Assign cookie to child
            }
            j++; 
        }

        return i; 
    }
}
