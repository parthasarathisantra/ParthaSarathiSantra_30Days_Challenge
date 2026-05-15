void decode(String s, Node root) {

    StringBuilder result = new StringBuilder();
    Node current = root;

    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '0') {
            current = current.left;
        }
        else {
            current = current.right;
        }
        if (current.left == null && current.right == null) {

            result.append(current.data);
            current = root;
        }
    }

    System.out.println(result.toString());
}