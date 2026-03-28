package leet.array;

import java.util.ArrayList;

public class MedianArray {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2,3,7};
        findMedianSortedArrays(nums1,nums2);
    }

    private static Double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Double result = null;
        int length = nums1.length+nums2.length;
        int[] mergedArr = new int[5];
        for(int i=0;i<mergedArr.length;i++){
            result+= mergedArr[i];
        }
        return result/mergedArr.length;
    }
}
