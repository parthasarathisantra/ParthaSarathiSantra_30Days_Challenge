import java.io.*;
import java.util.*;

class Result {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] arr = new long[n + 2];

        for (List<Integer> query : queries) {

            int a = query.get(0);
            int b = query.get(1);
            int k = query.get(2);

            arr[a] += k;
            arr[b + 1] -= k;
        }
        long max = 0;
        long sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
        }

        return max;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().trim().split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            String[] rowTempItems = bufferedReader.readLine().trim().split(" ");

            List<Integer> rowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                rowItems.add(Integer.parseInt(rowTempItems[j]));
            }

            queries.add(rowItems);
        }

        long result = Result.arrayManipulation(n, queries);

        System.out.println(result);

        bufferedReader.close();
    }
}