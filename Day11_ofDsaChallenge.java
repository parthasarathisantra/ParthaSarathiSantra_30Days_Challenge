static void levelOrder(Node root) {
    if (root == null) return;

    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
        Node temp = q.poll();
        System.out.print(temp.data + " ");

        if (temp.left != null) q.add(temp.left);
        if (temp.right != null) q.add(temp.right);
    }
}