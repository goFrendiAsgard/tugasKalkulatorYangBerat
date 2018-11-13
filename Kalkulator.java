import java.util.Stack;
// how to use stack: http://www.tutorialspoint.com/java/java_stack_class.htm

class Node {
    String data; // number, +, -, *, /
    Node left;
    Node right;
}

public class Kalkulator {
    static Node root;
    static Stack<String> st;
    static Stack<String> tmp;

    public static void main(String[] args) {
        st = new Stack<String>();
        tmp = new Stack<String>();
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
        toStack(root);
        System.out.println(st); // [*, +, 5, 4, -, 5, 4]
        System.out.println(calculateAll()); // 9.0
    }

    static String calculateAll() {
        while(true) {
            System.out.println("Isi stack");
            System.out.println(st);
            System.out.println(tmp);
            String data = st.pop();
            tmp.push(data);
            if (!isNumber(data)) {
                String operator = tmp.pop();
                String operand1 = tmp.pop();
                String operand2 = tmp.pop();
                String result = calculate(operator, operand1, operand2);
                st.push(result);
                while(!tmp.isEmpty()) {
                    st.push(tmp.pop());
                }
            }
            if(st.isEmpty()) {
                return tmp.pop();
            }
        }
    }

    static String calculate(String operator, String operand1, String operand2) {
        try {
            float n1 = Float.parseFloat(operand1);
            float n2 = Float.parseFloat(operand2);
            float n3 = 0;
            if (operator.equals("+")) {
                n3 = n1 + n2;
            } else if (operator.equals("-")) {
                n3 = n1 - n2;
            } else if (operator.equals("*")) {
                n3 = n1 * n2;
            } else if (operator.equals("/")) {
                n3 = n1 / n2;
            }
            return Float.toString(n3);
        } catch (Exception e) {
            return "0";
        }
    }

    static boolean isNumber(String str) {
        try {
            float x = Float.parseFloat(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static void toStack(Node node) {
        if (isLeaf(node)) {
            st.push(node.data);
        } else {
            st.push(node.data);
            toStack(node.left);
            toStack(node.right);
        }
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
