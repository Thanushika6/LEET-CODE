import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);  
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1; 

        while (!queue.isEmpty()) {
            int size = queue.size();  

            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                char[] chars = currentWord.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String nextWord = new String(chars);

                        if (nextWord.equals(endWord)) return level + 1;

                        if (wordSet.contains(nextWord)) {
                            queue.offer(nextWord);
                            wordSet.remove(nextWord); 
                        }
                    }

                    chars[j] = originalChar; 
                }
            }

            level++; 
        }

        return 0; 
    }
}
