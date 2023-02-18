package interview;

public class MedianOfSortedArray {
    public static void main(String[] args) {
        int [] nums1 = {1,3};
        int [] nums2 = {2};

        findTheMedian(nums1,nums2);
    }

    private static void findTheMedian(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int r1 = 0;
        int r2 = 0;
        int a = 0;
        int b = 0;
        int n =l1+l2;

        for(int i=0;i<n/2+1;i++){

            int t1 = a < nums1.length ? nums1[a] : Integer.MAX_VALUE;
            int t2 = b < nums2.length ? nums2[b] : Integer.MAX_VALUE;
            r2=r1;
            r1 = t1 < t2 ? nums1[a++] : nums2[b++];
        }


        if(n%2==0){
            System.out.println((r1+r2)/2.0);
        }else{
            System.out.println(r1);
        }

    }
}
