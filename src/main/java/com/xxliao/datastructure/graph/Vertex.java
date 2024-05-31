package com.xxliao.datastructure.graph;

/**
 * @author xxliao
 * @description: 图 - 定点类
 * @date 2024/5/29 16:56
 */
public class Vertex {

    // 顶点名称
    protected String name;

    // 该顶点出发的边
    protected Edge edge;

    public Vertex(String name, Edge edge) {
        this.name = name;
        this.edge = edge;
    }
}
