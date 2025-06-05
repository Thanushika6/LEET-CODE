class Solution {
    public int lengthOfLongestSubstring(String s)
     {
        if (s.length() <= 1) {
        return s.length();
        }
        int left = 0, right = 0, res = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}
