package leetcode.editor.cn;

import java.util.Date;

/**
 * @author Erica
 * @date 2021/3/3 23:17
 * @description TODO
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Date());
        fun();
    }

    /**
     * 实现金字塔
     *      1
     *     12 1
     *    123 21
     *   1234 321
     *  12345 4321
     * 123456 54321
     */
    private static void fun() {
        //  一共六层
        // 每层左边的数据都是从1开始到层数停止，中间有一个空格，右边的数据是从层数-1开始到1停止
        for (int i = 1; i <= 6;i++) {
            // 先输出空格，找出第一个数字的位置
            for (int j = 1; j <= 6 - i; j++) {
                System.out.print(" ");
            }
            // 输出左边数据
            for (int j = 1;j <= i;j++) {
                System.out.print(j);
            }
            System.out.print(" ");
            // 输出右边数据
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

}
