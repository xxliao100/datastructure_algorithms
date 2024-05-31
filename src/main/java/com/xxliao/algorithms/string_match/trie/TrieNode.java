package com.xxliao.algorithms.string_match.trie;

/**
 * @author xxliao
 * @description: Trie树的节点类
 * @date 2024/5/31 18:16
 */

public class TrieNode {

    // 当前 字符
    protected char data;

    // 子节点，因为匹配的是26个小写字母，所以为26，其它情况根据实际需求改
    public TrieNode[] children = new TrieNode[26];

    // 是否是 叶子字符 默认false
    public boolean is_leaf_char = false;

    public TrieNode(char data) {
        this.data = data;
    }
}
