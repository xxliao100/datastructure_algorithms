package com.xxliao.datastructure.graph;

/**
 * @author xxliao
 * @description: 图 - 边类
 * @date 2024/5/29 16:57
 */
public class Edge {

    // 被指向的顶点
    protected String name;
    // 权重
    protected int weight;
    // 顶点的下一条边
    protected Edge next;

    public Edge(String name, int weight, Edge next) {
        this.name = name;
        this.weight = weight;
        this.next = next;
    }


}
