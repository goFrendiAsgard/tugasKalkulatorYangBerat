class Node {
    float dataAngka;
    char dataOperasi; // +, -, *, /
    Node left;
    Node right;
}

public class Kalkulator {
    static Node root;
    public static void main(String[] args) {
        root = new Node();
        root.dataOperasi = '*';
        root.left = new Node();
        root.left.dataOperasi = '+';
        root.left.left = new Node();
        root.left.left.dataAngka = 5;
        root.left.right = new Node();
        root.left.right.dataAngka = 4;
        root.right = new Node();
        root.right.dataOperasi = '-';
        root.right.left = new Node();
        root.right.left.dataAngka = 5;
        root.right.right = new Node();
        root.right.right.dataAngka = 4;
        System.out.println(printNodeData(root.left)); // +
        System.out.println(printNodeData(root.left.left)); // 5
        System.out.println(parsePrefix(root)); // * + 5 4 - 5 4
        System.out.println(parseSufix(root));  // 5 4 + 5 4 - *
        System.out.println(parseInfix(root));  // 5 + 4 * 5 - 4
    }

    static String printNodeData(Node node) {
        if (node.dataOperasi == '+' || node.dataOperasi == '-' || node.dataOperasi == '*' || node.dataOperasi == '/') {
            return "" + node.dataOperasi;
        }
        return Float.toString(node.dataAngka);
    }

    static String parsePrefix(Node node) {
        return "";
        // gimana hayo?
    }

    static String parseSufix(Node node) {
        return "";
        // gimana hayo?
    }

    static String parseInfix(Node node) {
        return "";
        // gimana hayo?
    }
}