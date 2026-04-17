import java.util.*;

public class Day3_ofDsaChallenge {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {

        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int x : h1) sum1 += x;
        for (int x : h2) sum2 += x;
        for (int x : h3) sum3 += x;

        int i = 0, j = 0, k = 0;

        while (true) {

            if (i == h1.size() || j == h2.size() || k == h3.size())
                return 0;

            if (sum1 == sum2 && sum2 == sum3)
                return sum1;

            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= h1.get(i);
                i++;
            } 
            else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= h2.get(j);
                j++;
            } 
            else {
                sum3 -= h3.get(k);
                k++;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        List<Integer> h1 = new ArrayList<>();
        List<Integer> h2 = new ArrayList<>();
        List<Integer> h3 = new ArrayList<>();

        for (int i = 0; i < n1; i++) h1.add(sc.nextInt());
        for (int i = 0; i < n2; i++) h2.add(sc.nextInt());
        for (int i = 0; i < n3; i++) h3.add(sc.nextInt());

        System.out.println(equalStacks(h1, h2, h3));
        sc.close();
    }
}