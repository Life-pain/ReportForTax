import java.util.concurrent.atomic.LongAdder;

public class Shop {
    LongAdder order = new LongAdder();

    public void add(long[] revenue) {
        System.out.println("Добавляем выручки магазина " + Thread.currentThread().getName());
        for (int i = 0; i < revenue.length; i++) {
            order.add(revenue[i]);
        }
        System.out.printf("Выручки магазина %s добавлены\n", Thread.currentThread().getName());
    }

    public Long getOrder() {
        return order.longValue();
    }
}
