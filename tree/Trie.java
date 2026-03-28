package tree;
/**
 * Trie (Prefix Tree)
 *
 * A tree where each node represents a character. Used for fast prefix lookups.
 *
 * Input: insert("apple"), insert("app")
 * Output: search("app") → true, startsWith("ap") → true, search("ap") → false
 *
 * Approach: Each node holds 26 children (a-z) + isEnd flag
 * Time: O(m) per operation where m = word length Space: O(n*m)
 */
class Trie {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;                          // local pointer — never move root
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (current.children[idx] == null) {
                current.children[idx] = new TrieNode();  // fix: [idx] was missing
            }

            current = current.children[idx];             // fix: move current, not root
        }
        current.isEnd = true;                            // mark end after loop
        System.out.println("inserted: " + word);
    }

    public boolean search(String word) {
        // TODO
        return false;
    }

    public boolean startsWith(String prefix) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"there", "is", "lion", "world"};
        Trie trie = new Trie();
        for (String word : words) trie.insert(word);  // fix: insert takes String, not String[]
        // trie.insert("apple");
        // trie.insert("app");
        // System.out.println(trie.search("app"));      // true
        // System.out.println(trie.search("ap"));       // false
        // System.out.println(trie.startsWith("ap"));   // true
    }
}
