static void topView(Node root) {
    if (root == null) return;

    class Pair {
        Node node;
        int hd;

        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }

    TreeMap<Integer, Integer> map = new TreeMap<>();
    Queue<Pair> queue = new LinkedList<>();

    queue.add(new Pair(root, 0));

    while (!queue.isEmpty()) {
        Pair current = queue.poll();
        Node node = current.node;
        int hd = current.hd;

        if (!map.containsKey(hd)) {
            map.put(hd, node.data);
        }

        if (node.left != null) {
            queue.add(new Pair(node.left, hd - 1));
        }

        if (node.right != null) {
            queue.add(new Pair(node.right, hd + 1));
        }
    }

    for (int val : map.values()) {
        System.out.print(val + " ");
    }
}