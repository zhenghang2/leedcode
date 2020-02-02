package problem1;

public class IsUgly {
    public static void main(String[] args) {
        IsUgly iu = new IsUgly();
        System.out.println(iu.isUgly(14));
    }

    public boolean isUgly(int num) {
        while (num > 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 3 == 0) {
                num = num / 3;
            } else if (num % 5 == 0) {
                num = num / 5;
            } else {
                break;
            }
        }
        return num == 1;
    }
}
