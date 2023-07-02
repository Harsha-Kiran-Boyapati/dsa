package dsa.leetcode150;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int nums2[], int n){
        int i1=m-1, i2=n-1, j=m+n-1;
        while(i1>=0 || i2 >=0){
            if(i1<0){
                nums1[j]=nums2[i2]; i2--; j--;
            }
            else if(i2 <0){
                nums1[j] = nums1[i1]; i1--; j--;
            }
            else if(nums1[i1] > nums2[i2]){
                nums1[j] = nums1[i1]; i1--; j--;
            }
            else{
                nums1[j] = nums2[i2]; i2--; j--;
            }
        }
    }
}
