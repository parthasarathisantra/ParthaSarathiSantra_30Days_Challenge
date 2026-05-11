import java.io.*;
import java.util.*;

class Result {

    public static int cookies(int k, List<Integer> A) {

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int value : A) {
            minHeap.add((long) value);
        }

        int operations = 0;

        while (!minHeap.isEmpty() && minHeap.peek() < k) {
            if (minHeap.size() < 2) {
                return -1;
            }

            long first = minHeap.poll();
            long second = minHeap.poll();

            long newSweetness = first + (2 * second);

            minHeap.add(newSweetness);

            operations++;
        }

        return operations;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().trim().split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().trim().split(" ");

        List<Integer> A = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            A.add(Integer.parseInt(arrTemp[i]));
        }

        int result = Result.cookies(k, A);

        System.out.println(result);

        bufferedReader.close();
    }
}