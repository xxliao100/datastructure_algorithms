package com.xxliao.algorithms.greedy;

import java.util.Comparator;

/**
 * @author xxliao
 * @description: 贪心算法 - 商品类
 * @date 2024/5/31 19:02
 */

public class Goods{
    // 商品名称
    String name;
    // 重量
    double weight;
    // 总价
    double totalPrice;
    // 单价
    double price;

    public Goods(String name, double weight, double totalPrice) {
        this.name = name;
        this.weight = weight;
        this.totalPrice = totalPrice;
        // 求出单价
        price = totalPrice / weight;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getTotalPrice() {
        return totalPrice;
    }


    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", totalPrice=" + totalPrice +
                ", price=" + price +
                '}';
    }
}
