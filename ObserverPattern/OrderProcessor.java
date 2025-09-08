package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

import DataModels.Order;

public class OrderProcessor {
    List<OrderObserver> subscription = new ArrayList<OrderObserver>();
    public void register(OrderObserver observer){
        subscription.add(observer);
    }

    public void unregister(OrderObserver observer){
        subscription.remove(observer);
    }

    public void notifyObservers(Order order){
        for(OrderObserver o : subscription){
            o.update(order);
        }
    }
    public void processOrder(Order order){
        System.out.println("\nProcessing order " + order.orderId() + "....");
        System.out.println("Order processed successfully.");
        notifyObservers(order);
    }
}
