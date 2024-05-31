package com.xxliao.datastructure.graph;

import java.util.*;

/**
 * @author xxliao
 * @description: 邻接表实现图
 * @date 2024/5/29 16:00
 */
public class Graph {

    // 存储顶点容器
    private Map<String,Vertex> vertexes;

    public Graph() {
        this.vertexes = new HashMap<String,Vertex>();
    }

    /**
     * @description  添加顶点
     * @author  xxliao
     * @date  2024/5/29 17:02
     */
    public void addVertex(String vertexName) {
        vertexes.put(vertexName,new Vertex(vertexName,null));
    }

    /**
     * @description  添加边
     * @author  xxliao
     * @date  2024/5/29 17:05
     */
    public void addEdge(String beginVertexName,String endVertexName,int weight) {
        // 获取出发顶点
        Vertex beginVertex = vertexes.get(beginVertexName);
        if(beginVertex == null) {
            // 没有开始顶点，创建
            beginVertex = new Vertex(beginVertexName,null);
            vertexes.put(beginVertexName,beginVertex);
        }
        // 创建边对象
        Edge edge = new Edge(endVertexName,weight,null);
        if(beginVertex.edge == null) {
            //当前顶点还没有边，直接设置
            beginVertex.edge = edge;
        }else {
            Edge lastEdge = beginVertex.edge;
            while(lastEdge.next != null) {
                lastEdge = lastEdge.next;
            }
            // 设置到末尾
            lastEdge.next = edge;
        }
    }
    public void print(){ //打印图
        Set<Map.Entry<String, Vertex>> set = vertexes.entrySet();
        Iterator<Map.Entry<String, Vertex>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Vertex> entry = iterator.next();
            Vertex vertex = entry.getValue();
            Edge edge = vertex.edge;
            while(edge != null){
                System.out.println(vertex.name + " 指向 " + edge.name + " 权值为：" + edge.weight);
                        edge = edge.next;
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addEdge("C", "A", 1);
        graph.addEdge("F", "C", 2);
        graph.addEdge("A", "B", 4);
        graph.addEdge("E", "B", 2);
        graph.addEdge("A", "D", 5);
        graph.addEdge("D", "F", 4);
        graph.addEdge("D", "E", 3);
        graph.print();
    }

    /**
     * @description  深度优先遍历,vertexNam: 从那个顶点开始遍历
     * @author  xxliao
     * @date  2024/5/29 17:46
     */
    /*public LinkedList<Vertex> dfsList(String vertexName) {
        LinkedList<Vertex> result = new LinkedList<Vertex>();
        Vertex current = vertexes.get(vertexName);
        if(current == null)
            throw new RuntimeException("图中没有名字为" + vertexName + "的顶点");
        if(current.edge == null){
            // 单独顶点
            throw new RuntimeException("图中存在单独顶点，请检查图结构，修改后再遍历！");
        }
        result.add(current);
        System.out.print(current.name);
        while(true) {
            if(result.size() == vertexes.size()) {
                //遍历完成
                break;
            }
            current = vertexes.get(current.edge);
            if(result.contains(current)) {
                continue;
            }

            if(!result.contains(current)) {
                // 新顶点
                result.add(current);
            }
        }


        return result;
    }*/
}
