package eoodin.p004;

class FindMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int mid = (total -1) / 2 ;
        boolean even = total - (total/2) * 2 == 0;
        int p1 = 0, p2 = 0;
        int lv = 0; //?
        for (int ip = 0; ip <= mid + 1; ip++) {
            int tv;
            if (p1 == nums1.length) {
                tv = nums2[p2++];
            } else if (p2 == nums2.length) {
                tv = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                tv = nums1[p1++];
            } else {
                tv = nums2[p2++];
            }
            if (ip == mid && !even)
                return tv;
            else if (ip == mid +1 && even)
                return (tv + lv) / 2.0;
            lv = tv;
        }

        return 0;
    }

    public int[] mergeSort(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int p1 = 0, p2 = 0;
        for (int ip = 0; ip < merged.length; ip++){
            if (p1 == nums1.length) {
                merged[ip] = nums2[p2++];
            }
            else if(p2 == nums2.length) {
                merged[ip] = nums1[p1++];
            }
            else if(nums1[p1] < nums2[p2]) {
                merged[ip] = nums1[p1++];
            }
            else
                merged[ip] = nums2[p2++];
        }

        return merged;
    }
}