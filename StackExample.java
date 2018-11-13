import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> daftarNama = new Stack<String>();
        daftarNama.push("Anton");
        daftarNama.push("Budi");
        daftarNama.push("Chiko");
        daftarNama.push("Dadang");
        System.out.println(daftarNama);
        System.out.println(daftarNama.pop());
        System.out.println(daftarNama);
    }
}
