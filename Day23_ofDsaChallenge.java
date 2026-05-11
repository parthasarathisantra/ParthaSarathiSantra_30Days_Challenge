import java.io.*;
import java.util.*;

public class Solution {

    static int downToZero(int n) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(n);
        visited[n] = true;

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int current = queue.poll();

                if (current == 0) {
                    return moves;
                }
                if (!visited[current - 1]) {
                    visited[current - 1] = true;
                    queue.add(current - 1);
                }
                for (int j = 2; j * j <= current; j++) {

                    if (current % j == 0) {

                        int next = Math.max(j, current / j);

                        if (!visited[next]) {
                            visited[next] = true;
                            queue.add(next);
                        }
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(br.readLine());

        while (q-- > 0) {

            int n = Integer.parseInt(br.readLine());

            System.out.println(downToZero(n));
        }
    }
}