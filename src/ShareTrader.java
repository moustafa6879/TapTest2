import java.util.Scanner;

public class ShareTrader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int c1 = scanner.nextInt();
        int c2 = scanner.nextInt();

        if (validateInput(n, c1, c2)) {
            ShareBuy buyTransaction = new ShareBuy(c1);
            ShareSell sellTransaction = new ShareSell(c2);

            for (int i = 0; i < n; i++) {
                int price = scanner.nextInt();
                processTransaction(buyTransaction, sellTransaction, price, i, n);
            }

            int finalBalance = buyTransaction.getBalance() + sellTransaction.getBalance();
            System.out.println(finalBalance);
        } else {
            System.out.println("Invalid input.");
        }
    }

    private static boolean validateInput(int n, int c1, int c2) {
        return n >= 1 && n <= 100 && c1 >= 1 && c1 < c2 && c2 <= 1000;
    }

    private static boolean validatePrice(int price) {
        return price >= 1 && price <= 1000;
    }

    private static void processTransaction(ShareBuy buyTransaction, ShareSell sellTransaction, int price, int currentIndex, int n) {
        if (validatePrice(price)) {
            if (currentIndex == n - 1) {
                sellTransaction.setLast(true);
                sellTransaction.process(price);
            } else {
                buyTransaction.process(price);
                sellTransaction.process(price);
            }
        } else {
            System.out.println("Invalid input.");
            System.exit(1);
        }
    }

}