package com.shubham.recursion;
  
public class DigitProduct {
    public static void main(String[] args) {
        int num = 1234;
        System.out.println(product(num));
    }

    static int product(int num) {
        if (num == 0) {
            return 0;
        
        return product(n/10)+ n%10;
    }
}
