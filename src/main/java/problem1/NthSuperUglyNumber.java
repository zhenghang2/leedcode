package problem1;

import java.util.PriorityQueue;

public class NthSuperUglyNumber {

    public static void main(String[] args) {
        int n = 12;
        int[] primes = {2,7,13,19};
        NthSuperUglyNumber nsun = new NthSuperUglyNumber();
        System.out.println(nsun.nthSuperUglyNumber(12,primes));
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        int[] index = new int[primes.length];
        res[0] = 1;

        for (int i = 1; i < n; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; ++j) {
                if (min > res[index[j]] * primes[j]) {
                    min = res[index[j]] * primes[j];
                }
            }
            res[i] = min;
            for (int j = 0; j < primes.length; ++j) {
                if (min == res[index[j]] * primes[j]) {
                    index[j]++;
                }
            }
        }
        return res[n-1];
    }
}
