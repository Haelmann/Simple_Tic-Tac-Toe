import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int alpha;
        while (true) {
            alpha = scanner.nextInt();
            if (alpha == 0) break;
            if (alpha % 2 == 0) {
                System.out.println("even");
            }else if (alpha % 2 == 1) {
                System.out.println("odd");
            }
        }
    }
}