package com.xxliao.datastructure.linerar_list.hash_table.linked_address;

/**
 * @author xxliao
 * @description: 链地址实现哈希表 测试客户端
 * @date 2024/5/28 19:12
 */

public class TestClient {

    public static void main(String[] args) {
        CustomHashMap hashMap=new CustomHashMap();
        hashMap.put("m3","m3m3");
        hashMap.put("c1","c1c1");
        hashMap.put("c1","cc11");
        System.out.println(hashMap.get("c1"));
    }
}
