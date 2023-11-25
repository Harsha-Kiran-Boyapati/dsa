package dsa.leetcode150.heaps;
import java.util.*;

public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));

        for(int i=0; i< Math.min(nums1.length, k); i++){
            System.out.println("added to pq, idx1 - "+i);
            pq.offer(new int[]{ nums1[i]+nums2[0], i, 0});
        }
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        while(ans.size()<k){
            int[] triplet = pq.poll();
            System.out.println("triplet "+Arrays.toString(triplet));
            int idx1 = triplet[1];
            int idx2 = triplet[2];

            ans.add(List.of(nums1[idx1], nums2[idx2]));
            if(idx2+1 < nums2.length){
                pq.offer(new int[] { nums1[idx1] + nums2[idx2+1], idx1, idx2+1});
            }
        }

        return ans;

    }
}
