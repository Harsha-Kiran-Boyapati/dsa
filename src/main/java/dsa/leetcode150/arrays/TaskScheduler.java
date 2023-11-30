package dsa.leetcode150.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c: tasks) freq[c-'A']++;
        System.out.println(Arrays.toString(freq));
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -n);
        //lastPos is used to figure out which character can come in a certain unit of time
        //fill the lastPos with -n such that

        int lastTimeSlot = 0;
        for(int i=0; i<tasks.length;i++){
            int idx = nextCharIdx(freq, lastPos, lastTimeSlot, n);

            lastPos[idx] = Math.max(lastTimeSlot+1, lastPos[idx]+n+1);
            lastTimeSlot = lastPos[idx];
            System.out.println((char)('A'+idx) + " " + lastTimeSlot );
            freq[idx]--;
        }
        return lastTimeSlot;

    }

    private int nextCharIdx(int[] freq, int[] lastPos, int lastTimeSlot, int n){
        //if there are multiple contenders for a timeslot choose the one with most frequency
        List<Integer> indicesWithPositiveCount = new LinkedList<>();
        for(int i=0; i< 26; i++){
            if(freq[i]>0) indicesWithPositiveCount.add(i);
        }

        List<Integer> indicesThatCanGoInNextSlot = indicesWithPositiveCount.stream().filter(i -> lastPos[i]+n+1 <= lastTimeSlot+1).toList();

        if(indicesThatCanGoInNextSlot.size() == 1) return indicesThatCanGoInNextSlot.get(0);

        if(indicesThatCanGoInNextSlot.size() == 0)
            return indicesWithPositiveCount.stream().min(Comparator.comparingInt(i -> lastPos[i])).orElse(indicesWithPositiveCount.get(0));

        if(indicesThatCanGoInNextSlot.size() >1){
            return indicesThatCanGoInNextSlot.stream().max(Comparator.comparingInt(i -> freq[i])).orElse(indicesThatCanGoInNextSlot.get(0));
        }

        return indicesWithPositiveCount.get(0);
    }
}
