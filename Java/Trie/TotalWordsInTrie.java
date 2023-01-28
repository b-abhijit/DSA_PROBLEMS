// Program to find total number of words in a trie (BFS Approach)

package Trie;

import java.util.LinkedList;
import java.util.Queue;

public class TotalWordsInTrie {

    static TrieNode root;

    TotalWordsInTrie() {
        root = new TrieNode(' ');
    }

    static void createTrie() {
        String[] words = new String[] {"abhijit", "api", "abc", "abcd", "abcde"};

        for (String word: words) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); ++i) {
                if (curr.childList[word.charAt(i) - 'a'] == null)
                    curr.childList[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));

                curr = curr.childList[word.charAt(i) - 'a'];
                curr.count += 1;
            }
            curr.endOfWord += 1;
        }
    }

    static int countWords() {
        Queue<TrieNode> queue = new LinkedList<>();
        int wordCount = 0;
        TrieNode trieNode = root;

        if (trieNode == null)
            return 0;

        for (TrieNode temp: trieNode.childList) {
            if (temp != null)
                queue.offer(temp);
        }

        while (!queue.isEmpty()) {
            int count = queue.size();

            for (int i = 0; i < count; ++i) {
                trieNode = queue.poll();

                if (trieNode.endOfWord > 0)
                    wordCount += trieNode.endOfWord;

                for (TrieNode temp: trieNode.childList) {
                    if (temp != null)
                        queue.offer(temp);
                }
            }
        }

        return wordCount;
    }

    public static void main(String[] args) {
        new TotalWordsInTrie();

        createTrie();

        System.out.println("Total number of words in trie: " + countWords());
    }
}
