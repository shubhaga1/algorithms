package com.shubham.recursion;
  
public class ReverseNum {
    static int sum =0;
    public static void main(String[] args) {
        int num = 1234;
      if (num < 0) {
          num = -num; // Convert negative number to positive
      }
        System.out.println(sum);
    }

    static void revNum(int n) {
        if (n ==0) {
            return;
        }
        sum = sum*10+ n%10;
        revNum(n/10);
    }
}
