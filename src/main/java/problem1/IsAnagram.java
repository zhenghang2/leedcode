package problem1;

import java.util.Arrays;

public class IsAnagram {

    public static void main(String[] args) {
        IsAnagram ia = new IsAnagram();
        String s = "rat";
        String t = "car";
        System.out.println(ia.isAnagram(s,t));
    }
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        if (s1.length != s2.length) {
            return false;
        }
        for (int i = 0; i < s1.length; ++i) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }
}
