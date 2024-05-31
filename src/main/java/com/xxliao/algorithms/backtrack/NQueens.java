package com.xxliao.algorithms.backtrack;

/**
 * @author xxliao
 * @description: N皇后问题 求解
 * @date 2024/6/1 0:14
 */
public class NQueens {

    public static void main(String[] args) {
        NQueens queens=new NQueens();
        queens.setQueens(0);
        queens.printQueens();
    }

    // 皇后数量
    static int queens_count = 8;
    // 定义数组来存在皇后，索引表示行，值表示皇后存在改行的那一列中
    int[] array = new int[queens_count];

    /**
     * @description  根据行号，设置该行的皇后位置
     * @author  xxliao
     * @date  2024/6/1 0:17
     */
    public void setQueens(int row) {
        if(row == queens_count) {
            // 递归结束条件
            return;
        }
        // 尝试每一列放置，如果没有合适的，就返回上一层
        for(int column = 0; column <queens_count; column++) {
            if(isOk(row,column)) {
                // 符合条件，放置
                array[row] = column;
                // 然后设置下一行
                setQueens(++row);
            }
        }
    }

    /**
     * @description  判断改行该列是否 符合条件
     * @author  xxliao
     * @date  2024/6/1 0:23
     */
    private boolean isOk(int row, int column) {
        // 定义左上角、右上角 列索引标记
        int leftup = column - 1;
        int rightup = column + 1;
        // 然后从当前行逐行向上遍历，看当前row、column是否满足条件
        for(int i = row-1; i >= 0; i--) {
            if(array[i] == column){
                // 如果该位置已经有了皇后了，不满足
                return false;
            }
            if(leftup >=0 && array[i] == leftup) {
                //左上对角线存在queen,第一次执行是当前行，肯定不满足条件，i--，leftup--之后就是当前点的左上角位置
                return false;
            }
            if(rightup < queens_count && array[i] == rightup) {
                //右下对角线存在queen，同上理由
                return false;
            }
            leftup--;
            rightup++;
        }
        return true;
    }

    /**
     * @description  打印N皇后棋盘
     * @author  xxliao
     * @date  2024/6/1 0:34
     */
    private void printQueens() {
        for (int i = 0; i < queens_count; i++) {
            for (int j = 0; j < queens_count; j++) {
                if (array[i] == j) {
                    System.out.print("Q| ");
                }
                else {
                    System.out.print("*| ");
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }
}
