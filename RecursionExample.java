public class RecursionExample {

    public static void main(String[] args) {
        tampilkanAngka(1);
    }

    static void tampilkanAngka(int a) {
        System.out.println(a);
        if (a < 5) {
            tampilkanAngka(a+1);
        }
    }

    static void tampilkan() {
        for(int i=1; i<6; i++) {
            System.out.println(i);
        }
    }
}
