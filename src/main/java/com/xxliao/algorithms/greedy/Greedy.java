package com.xxliao.algorithms.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xxliao
 * @description: 贪心算法 - 背包问题
 * @date 2024/5/31 19:05
 */
public class Greedy {


    public static void main(String[] args) {
        Greedy greedy = new Greedy();
        List<Goods> goodslist = new ArrayList<>();
        goodslist.add(new Goods("A", 10, 60));
        goodslist.add(new Goods("C", 30, 120));
        goodslist.add(new Goods("B", 20, 100));
        greedy.take(goodslist,50);
    }

    public void take(List<Goods> goodsList, double bag_capacity) {
        // 按照单价进行排序
        sort(goodsList);
        double sum_weight = 0d;
        for (int i = 0; i < goodsList.size(); i++) {
            sum_weight += goodsList.get(i).getWeight();
            if(sum_weight <= bag_capacity){
                System.out.println(goodsList.get(i).name + "取" + goodsList.get(i).weight + "kg");
            }else {
                System.out.println(goodsList.get(i).name+ "取" +(bag_capacity-(sum_weight - goodsList.get(i).weight)) +"kg");
                return;
            }
        }
    }

    /**
     * @description  根据单价倒序
     * @author  xxliao
     * @date  2024/5/31 19:55
     */
    public void sort(List<Goods> goodsList){
        goodsList = goodsList.stream()
                .sorted(Comparator.comparing(Goods::getPrice).reversed())
                .collect(Collectors.toList());
    }
}
