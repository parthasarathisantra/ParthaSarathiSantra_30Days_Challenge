import java.util.*;

public class Solution {

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        int sum = 0;
        int i = 0; 
        int j = 0; 
        int maxCount = 0;

        while (i < a.size() && sum + a.get(i) <= maxSum) {
            sum += a.get(i);
            i++;
        }

        maxCount = i;

        while (j < b.size()) {
            sum += b.get(j);
            j++;

            while (sum > maxSum && i > 0) {
                i--;
                sum -= a.get(i);
            }
            if (sum > maxSum) break;

            maxCount = Math.max(maxCount, i + j);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int g = sc.nextInt(); 

        while (g-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int maxSum = sc.nextInt();

            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(sc.nextInt());
            }

            List<Integer> b = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                b.add(sc.nextInt());
            }

            System.out.println(twoStacks(maxSum, a, b));
        }

        sc.close();
    }
}