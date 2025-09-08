package ObserverPattern;

import DataModels.Order;

public interface OrderObserver {
    public void update(Order order);
}
