package com.xxliao.datastructure.linerar_list.array;

/**
 * @author xxliao
 * @description: array test client
 * @date 2024/5/28 11:33
 */
public class TestClient {

    public static void main(String[] args) {
        Array array = new Array();
        array.display();

        // 测试尾部添加
//        for (int i = 0; i < 10; i++) {
//          array.insertTail(i);
//        }

        // 测试中间添加
        //array.insertMiddle(1,1000);

        // 测试删除
        array.deleteMiddle(3);

        array.display();
    }


}
