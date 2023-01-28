// Program to print all words in a trie (DFS Approach)

package Trie;

public class FindAllWordsInTrie {
    static TrieNode root;

    FindAllWordsInTrie() {
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

    static void printWordsInTrie(TrieNode trieNode, StringBuilder currentWord) {
        if (trieNode == null)
            return;

        if (trieNode.endOfWord > 0) {
            System.out.println(currentWord);
        }

        for (TrieNode curr: trieNode.childList) {
            if (curr != null) {
                printWordsInTrie(curr, currentWord.append(curr.letter));
                currentWord.deleteCharAt(currentWord.length() - 1);
            }
        }

    }

    public static void main(String[] args) {
        new FindAllWordsInTrie();

        createTrie();

        int count = 0;

        for (TrieNode trieNode: root.childList) {
            if (trieNode != null)
                count += 1;
        }

        if (count == 0) {
            System.out.println("There are no words in the trie");
            return;
        }

        System.out.println("List of words in the trie:\n");
        printWordsInTrie(root, new StringBuilder(root.letter));
    }

}
