package com.xxliao.datastructure.linerar_list.hash_table.linked_address;

/**
 * @author xxliao
 * @description: 链地址实现哈希表
 * @date 2024/5/28 19:08
 */

public class CustomHashMap {
    //数组初始化 2的n次方
    LinkedList[] map=new LinkedList[8];
    //ListNode的个数
    int size;
    /**
     * 设置值
     * @param key
     * @param value
     */
    public void put(String key,String value){
        //该扩容了
        if(size>=map.length*0.75){
            System.out.println("map需要扩容");
            return;
        }
        //计算索引 数组下标
        int index=Math.abs(key.hashCode())%map.length;
        //获得该下标处的ListNode
        LinkedList ln=map[index];
        //该下标处无值
        if(ln==null){
            //创建单链表
            LinkedList lnNew=new LinkedList();
            //创建头结点
            Node head=new Node(key,value,null);
            //挂载头结点
            lnNew.head=head;
            //把单链放到数组里
            map[index]=lnNew;
            size++;
        }
        //该下标有值，hash碰撞
        else {
            //单链表挂结点
            ln.addNode(key,value);
        }
    }
    /**
     * 取值
     * @param key
     * @return
     */
    public String get(String key){
        int index=Math.abs(key.hashCode())%map.length;
        LinkedList ln=map[index];
        if(ln==null) return null;
        return ln.getVal(key);
    }
}
