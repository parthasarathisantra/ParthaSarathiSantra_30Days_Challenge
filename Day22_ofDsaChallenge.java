import java.util.*;

public class Solution {

    static class Cell {
        int x, y, moves;

        Cell(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }

    public static int minimumMoves(List<String> grid, int startX, int startY,
                                   int goalX, int goalY) {

        int n = grid.size();

        boolean[][] visited = new boolean[n][n];

        Queue<Cell> queue = new LinkedList<>();

        queue.add(new Cell(startX, startY, 0));
        visited[startX][startY] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            Cell current = queue.poll();
            if (current.x == goalX && current.y == goalY) {
                return current.moves;
            }
            for (int i = 0; i < 4; i++) {

                int newX = current.x;
                int newY = current.y;

                while (true) {

                    newX += dx[i];
                    newY += dy[i];
                    if (newX < 0 || newY < 0 || newX >= n || newY >= n) {
                        break;
                    }
                    if (grid.get(newX).charAt(newY) == 'X') {
                        break;
                    }
                    if (!visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.add(new Cell(newX, newY, current.moves + 1));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<String> grid = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            grid.add(sc.nextLine());
        }

        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int goalX = sc.nextInt();
        int goalY = sc.nextInt();

        int answer = minimumMoves(grid, startX, startY, goalX, goalY);

        System.out.println(answer);

        sc.close();
    }
}