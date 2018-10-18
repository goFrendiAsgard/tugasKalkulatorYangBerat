class Node {
    String data; // number, +, -, *, /
    Node left;
    Node right;
}

public class Kalkulator {
    static Node root;
    public static void main(String[] args) {
        root = new Node();
        root.data = "*";
        root.left = new Node();
        root.left.data = "+";
        root.left.left = new Node();
        root.left.left.data = "5";
        root.left.right = new Node();
        root.left.right.data = "4";
        root.right = new Node();
        root.right.data = "-";
        root.right.left = new Node();
        root.right.left.data = "5";
        root.right.right = new Node();
        root.right.right.data = "4";
        System.out.println(root.left.data); // +
        System.out.println(root.left.left.data); // 5
        System.out.println(parsePrefix(root)); // * + 5 4 - 5 4
        System.out.println(parsePostfix(root));  // 5 4 + 5 4 - *
        System.out.println(parseInfix(root));  // 5 + 4 * 5 - 4
    }

    static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    static String parsePrefix(Node node) {
        if (isLeaf(node)) {
            return node.data;
        }
        return node.data + " " + parsePrefix(node.left) + " " + parsePrefix(node.right);
    }

    static String parsePostfix(Node node) {
        if (isLeaf(node)) {
            return node.data;
        }
        return parsePostfix(node.left) + " " + parsePostfix(node.right) + " " + node.data;
    }

    static String parseInfix(Node node) {
        if (isLeaf(node)) {
            return node.data;
        }
        return parseInfix(node.left) + " " + node.data + " " + parseInfix(node.right);
    }
}
