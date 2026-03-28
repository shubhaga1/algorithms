package aakuTeaching;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int ar[] ={6,4,7,8,2,3};
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();

        for(int i=0;i<ar.length;i++){
            if(find==ar[i]){
                System.out.println("number is available in the array at"+ i +" position");
            }
        }
    }
}
