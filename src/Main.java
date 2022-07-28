import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        long[] revenueShop1 = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
        long[] revenueShop2 = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
        long[] revenueShop3 = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};

        Shop shop = new Shop();
        List<Thread> threadList = new ArrayList<>(Arrays.asList(
                new Thread(null, () -> shop.add(revenueShop1), "1"),
                new Thread(null, () -> shop.add(revenueShop2), "2"),
                new Thread(null, () -> shop.add(revenueShop3), "3")
        ));
        try {
            for (Thread thread : threadList) thread.start();
            for (Thread thread : threadList) thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Общий результат = " + shop.getOrder());
    }

}
