package aakuTeaching;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int ar[] = {6, 4, 7, 8, 2, 3};
        Arrays.sort(ar);
        System.out.println("Enter value you need to check");
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        int h = (ar.length - 1);
        int l = 0;
        System.out.println("number is available in the array at" + binary(ar, l, h, find) + " position");
    }

    //Big(0) = logn
    public static int binary(int ar[], int l, int h, int find) {
        if (l < h) {
            for (int i = 0; i < h; i++) {
                int mid = ar.length / 2;
                if (find == ar[i]) {
                    return i;

                } else if (find > ar[mid]) {
                    l = mid + 1;
                    binary(ar, l, h, find);
                } else if (find < ar[mid]) {
                    h = mid;
                    l=0;
                    binary(ar, l, h, find);
                }
            }
        }
        return 0;
    }
}
