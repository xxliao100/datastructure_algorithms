package com.xxliao.datastructure.linerar_list.hash_table.openness_address;

/**
 * @author xxliao
 * @description: 线性探测实现哈希表 测试客户端
 * @date 2024/5/28 18:40
 */

public class TestClient {
    public static void main(String[] args) {
        // 数据源,17个数据,
        Integer [] array = {3,4,5,3,6,8,9,7,1,2,11,12,14,17,15,13,20};
        // 哈希表,初始长度为10
        HashTable hashTable = new HashTable(10);
        // 添加数据
        for(int i=0; i<array.length; i++) {
            hashTable.insert(array[i]);
        }
        // 打印数据
        hashTable.print();
        //删除数据 15,17,20
        hashTable.remove(15);
        hashTable.remove(17);
        hashTable.remove(20);
        // 打印数据
        hashTable.print();
    }
}
