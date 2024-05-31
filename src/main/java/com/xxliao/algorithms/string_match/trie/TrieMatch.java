package com.xxliao.algorithms.string_match.trie;

/**
 * @author xxliao
 * @description: Trie树算法，用于从单词集合中找某个单词
 * @date 2024/5/31 18:15
 */
public class TrieMatch {

    public static void main(String[] args) {
        TrieMatch trie=new TrieMatch();
        trie.insert("hello".toCharArray());
        trie.insert("her".toCharArray());
        trie.insert("hi".toCharArray());
        trie.insert("how".toCharArray());
        trie.insert("see".toCharArray());
        trie.insert("so".toCharArray());
        System.out.println(trie.find("how".toCharArray()));
    }

    // 定义根节点字符
    private TrieNode root = new TrieNode('/');


    /**
     * @description  往Trie树中添加字符串
     * @author  xxliao
     * @date  2024/5/31 18:21
     */
    public void insert(char[] text) {
        // 定义当前节点
        TrieNode current = root;
        for(int i = 0; i < text.length; i++) {
            //求出字符的索引
            int index = text[i] -97;
            if(current.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                current.children[index] = newNode;
            }
            current = current.children[index];
        }
        current.is_leaf_char = true;
    }

    /**
     * @description  在Trie树中查找字符串
     * @author  xxliao
     * @date  2024/5/31 18:25
     */
    public boolean find(char[] pattern) {
        TrieNode current = root;
        for (int i = 0; i < pattern.length; i++) {
            int index = pattern[i] - 97;
            if (current.children[index] == null) {
                return false; // 不存在pattern
            }
            current = current.children[index];
        }
        if (current.is_leaf_char == false)
            return false; // 不能完全匹配，只是前缀

        return true; // 找到pattern
    }
}
