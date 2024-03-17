import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int[] coins = new int[6];
            for (int i = 0; i < 6; i++) {
                coins[i] = scanner.nextInt();
            }

            // 读取付款金额
            double amount = scanner.nextDouble();

            // 结束条件
            if (coins[0] == 0 && coins[1] == 0 && coins[2] == 0 && coins[3] == 0 && coins[4] == 0 && coins[5] == 0) {
                break;
            }

            int[] values = {2, 1, 0, 3, 5, 4}; // 对应硬币面值的索引，按面值从大到小排序
            int[] change = {100, 50, 20, 10, 5, 1}; // 对应硬币面值的金额
            int[] usedCoins = new int[6]; // 存储每种面值的硬币使用个数

            double remaining = amount;
            boolean possible = true;

            for (int i : values) {
                while (remaining >= change[i] && coins[i] > 0) {
                    remaining -= change[i];
                    coins[i]--;
                    usedCoins[i]++;
                }
            }

            if (remaining > 0.001) { // 处理浮点数比较误差
                System.out.println("impossible");
            } else {
                int totalCoins = 0;
                for (int usedCoin : usedCoins) {
                    totalCoins += usedCoin;
                }
                System.out.println(totalCoins);
            }
        }

        scanner.close();
    }
}
