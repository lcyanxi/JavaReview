package com.common.test;

/**
 * Created by lcyanxi on 2017/7/27.
 */
public class Test {

    public static void main(String args[]) {
        Ij ij=new Ij();
        int[][] aa = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int i = 0, j = 0;

        int N = 3;
        while (true) {
            right(aa,ij.i,ij.j, N);
            left(aa,ij.i,ij.j, N);
            down(aa,ij.i,ij.j, N);
            up(aa,ij.i,ij.j, N);
        }

    }

    public static void right(int[][] aa, int i, int j, int n) {
        while (j <= n - 1) {
            System.out.println(aa[i][j]);
            j++;
        }
    }

    public static void left(int[][] aa, int i, int j, int n) {
        while (j >= 0) {
            System.out.println(aa[i][j]);
            j--;
        }
    }

    public static void down(int[][] aa, int i, int j, int n) {
        while (i >= n - 1) {
            System.out.println(aa[i][j]);
            i++;
        }
    }

    public static void up(int[][] aa, int i, int j, int n) {
        while (i >= 0) {
            System.out.println(aa[i][j]);
            i--;
        }
    }
}

class Ij {
    int i = 0;
    int j = 0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
