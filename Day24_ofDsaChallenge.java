import java.io.*;
import java.util.*;

class Result {
       public static long largestRectangle(List<Integer> h) {

        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int n = h.size();

        for (int i = 0; i <= n; i++) {

            int currentHeight = (i == n) ? 0 : h.get(i);

            while (!stack.isEmpty() && currentHeight < h.get(stack.peek())) {

                int height = h.get(stack.pop());

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                long area = (long) height * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] hTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hTemp[i]);
            h.add(hItem);
        }

        long result = Result.largestRectangle(h);

        System.out.println(result);

        bufferedReader.close();
    }
}