import java.util.*;

public class Solution {

    public static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);

        int maxDistance = c[0];

        for (int i = 1; i < c.length; i++) {
            int gap = c[i] - c[i - 1];
            int midDistance = gap / 2;
            maxDistance = Math.max(maxDistance, midDistance);
        }

        int lastDistance = (n - 1) - c[c.length - 1];
        maxDistance = Math.max(maxDistance, lastDistance);

        return maxDistance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int m = sc.nextInt(); 

        int[] c = new int[m];
        for (int i = 0; i < m; i++) {
            c[i] = sc.nextInt();
        }

        int result = flatlandSpaceStations(n, c);
        System.out.println(result);
        sc.close();
    }
}