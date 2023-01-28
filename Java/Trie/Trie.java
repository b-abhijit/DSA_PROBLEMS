// Program to illustrate basic trie operations

package Trie;

class TrieNode {
    char letter;
    TrieNode[] childList;
    int count;
    int endOfWord;

    TrieNode(char ch) {
        letter = ch;
        childList = new TrieNode[26];
        count = 0;
        endOfWord = 0;
    }
}

public class Trie {
    static TrieNode root;

    Trie() {
        root = new TrieNode(' ');
    }

    // Function to insert a new word
    static void insertWord(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); ++i) {
            if (curr.childList[word.charAt(i) - 'a'] == null) {
                curr.childList[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
            }
            curr = curr.childList[word.charAt(i) - 'a'];
            curr.count += 1;
        }

        curr.endOfWord += 1;
    }

    // Function to search a word
    static boolean searchWord(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); ++i) {
            if (curr.childList[word.charAt(i) - 'a'] == null)
                return false;
            curr = curr.childList[word.charAt(i) - 'a'];
        }

        if (curr.endOfWord > 0)
            return true;

        return false;
    }

    // Function to check if a prefix exists
    static boolean startsWithPrefix(String prefix) {
        TrieNode curr = root;

        for (int i = 0; i < prefix.length(); ++i) {
            if (curr.childList[prefix.charAt(i) - 'a'] == null)
                return false;

            curr = curr.childList[prefix.charAt(i) - 'a'];
        }

        return true;
    }

    // Function to check how many words start with a given prefix
    static int startsWithPrefixCount(String prefix) {
        TrieNode curr = root;

        for (int i = 0; i < prefix.length(); ++i) {
            if (curr.childList[prefix.charAt(i) - 'a'] == null)
                return 0;

            curr = curr.childList[prefix.charAt(i) - 'a'];
        }

        return curr.count;
    }

    // Function to delete a word
    static void deleteWord(String word) {

        if (!searchWord(word)) {
            System.out.println(word + " is not found.");
            return;
        }

        TrieNode curr = root;

        for (int i = 0; i < word.length(); ++i) {
            curr = curr.childList[word.charAt(i) - 'a'];
            curr.count -= 1;
        }

        curr.endOfWord -= 1;
    }

    public static void main(String[] args) {
        new Trie();

        String word1 = "abhijit";
        String word2 = "abdc";
        String word3 = "api";
        String word4 = "abcde";
        String word5 = "abc";

        // Insert words into trie
        insertWord(word1);
        insertWord(word2);
        insertWord(word3);
        insertWord(word4);
        insertWord(word5);

        // Search words in trie
        System.out.println("Search word " + "abhijit: " + searchWord("abhijit"));
        System.out.println("Search word " + "adge: " + searchWord("adge"));
        System.out.println("Search word " + "api: " + searchWord("api"));
        System.out.println("Search word " + "ab: " + searchWord("ab"));
        System.out.println("Search word " + "abc: " + searchWord("abc"));
        System.out.println();

        // Check if prefix exists
        System.out.println("Search prefix " + "ab: " + startsWithPrefix("ab"));
        System.out.println("Search prefix " + "ad: " + startsWithPrefix("ad"));
        System.out.println("Search prefix " + "ap: " + startsWithPrefix("ap"));
        System.out.println("Search prefix " + "ac: " + startsWithPrefix("ac"));
        System.out.println("Search prefix " + "abc: " + startsWithPrefix("abc"));
        System.out.println();

        // Count occurrence of a prefix
        System.out.println("Occurrence of prefix " + "ab: " + startsWithPrefixCount("ab"));
        System.out.println("Occurrence of prefix " + "ad: " + startsWithPrefixCount("ad"));
        System.out.println("Occurrence of prefix " + "ap: " + startsWithPrefixCount("ap"));
        System.out.println("Occurrence of prefix " + "ac: " + startsWithPrefixCount("ac"));
        System.out.println("Occurrence of prefix " + "abc: " + startsWithPrefixCount("abc"));
        System.out.println();

        // Delete word from a trie
        System.out.println("Delete word: abc");
        deleteWord("abc");

        System.out.println("Search word " + "abc: " + searchWord("abc"));
        System.out.println("Search prefix " + "abc: " + startsWithPrefix("abc"));
        System.out.println("Occurrence of prefix " + "abc: " + startsWithPrefixCount("abc"));
        System.out.println();

        System.out.println("Insert word: ab");
        insertWord("ab");
        System.out.println("Search word " + "ab: " + searchWord("ab"));
        System.out.println("Search prefix " + "ab: " + startsWithPrefix("ab"));
        System.out.println("Occurrence of prefix " + "ab: " + startsWithPrefixCount("ab"));
    }
}
