import java.util.List;

import DataModels.*;
import DecoratorPattern.*;
import FactoryMethodPattern.*;
import ObserverPattern.*;
import StrategyPattern.*;


public class Test {
    public static void main(String[] args) {
        //set up
        Product apple = new Product("P001", "apple", 30000);
        Product Rat = new Product("P002", "Rat", 800);
        Order first = new Order("O001", List.of(apple,Rat), "ku@uk");

        OrderCalculator calculator = new OrderCalculator();
        ShipmentFactory shipmentFactory = new ShipmentFactory();
        OrderProcessor orderProcessor = new OrderProcessor();

        InventoryService inventory = new InventoryService();
        EmailService emiler = new EmailService();
        orderProcessor.register(inventory);
        orderProcessor.register(emiler);

        System.out.println("---- Strategies TESTING -----");
        double originalPrice = first.getTotalPrice();
        System.out.println("The Original Price : " + originalPrice);

        DiscountStrategy tenpercent = new PercentageDiscount(10);
        double priceafterdiscound = calculator.calculateFinalPrice(first, tenpercent);
        System.out.println("Price with 10% discount : " + priceafterdiscound);

        DiscountStrategy fiveHunoff = new FixedDiscount(500);
        double priceafterdiscound1 = calculator.calculateFinalPrice(first, fiveHunoff);
        System.out.println("Price with 500 discount : " + priceafterdiscound1);

        System.out.println("---- Factory and Decorator Pattern TESTING -----");
        Shipment standard = shipmentFactory.createShipment("STANDARD");
        System.out.println("Base Shipmen: " + standard.getInfo() + ", Cost: " + standard.getCost());

        Shipment gift = new GiftWrapDecorator(standard);
        System.out.println("Decorator: " + gift.getInfo() + ", Cost: " + gift.getCost());

        Shipment insur = new InsuranceDecorator(gift, first);
        System.out.println("InsuranceDecorator: " + insur.getInfo() + "Cost: " + insur.getCost());

        System.out.println("In summery");
        double finalprice = priceafterdiscound;
        double total = priceafterdiscound + insur.getCost();
        System.out.println("Last price after all discount: " + finalprice);
        System.out.println("Last shipment price: " + insur.getCost());
        System.out.println("Total Price: " + total);
    }
}
