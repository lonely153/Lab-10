package ObserverPattern;

import DataModels.Order;

public class EmailService implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println("Confirmation email sent to [" + order.customerEmail() + "]");
    }
    
}
