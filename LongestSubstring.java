class Solution {
    public int lengthOfLongestSubstring(String s)
     { 
       if (s.length() <= 1) {
            return s.length();
        }
        boolean[] vis = new boolean[256];  
        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            while (vis[ch]) {
                vis[s.charAt(left)] = false;
                left++;
            }
            vis[ch] = true;
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
     }
}
