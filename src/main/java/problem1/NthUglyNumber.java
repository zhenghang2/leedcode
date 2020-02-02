package problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class NthUglyNumber {
    public static void main(String[] args) {
        NthUglyNumber nun = new NthUglyNumber();
        System.out.println(nun.nthUglyNumber(1407));
    }

    public int nthUglyNumber(int n) {
        long[] res = new long[n];
        PriorityQueue<Long> priorityQueue = new PriorityQueue<Long>();
        res[0] = 1;
        for (int i = 1; i < n; ++i) {
            long n1 = res[i-1] * 2;
            if (!priorityQueue.contains(n1)) {
                priorityQueue.add(n1);
            }
            long n2 = res[i-1] * 3;
            if (!priorityQueue.contains(n2)) {
                priorityQueue.add(n2);
            }
            long n3 = res[i-1] * 5;
            if (!priorityQueue.contains(n3)) {
                priorityQueue.add(n3);
            }
            res[i] = priorityQueue.poll();
        }
        return (int)res[n-1];
    }
}
