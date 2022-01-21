package SortingAlgo;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] left = {1, 2, 3, 6, 7, 15};
        int[] right = {6, 9, 12, 14};
        System.out.println(Arrays.toString(merge(left, right)));

        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(mrgSort(arr)));
    }


    static int[] mrgSort(int[] arr){
        if (arr.length == 1){
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mrgSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mrgSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right){
        int[] ans = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length){
            if (left[i] < right[j]){
                ans[k] = left[i];
                i++;
            }else{
                ans[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length){
            ans[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length){
            ans[k] = right[j];
            j++;
            k++;
        }

        return ans;
    }
}
