package DecoratorPattern;

import FactoryMethodPattern.Shipment;

public abstract class ShipmentDecorator implements Shipment {
    protected Shipment wrappedShipment;
    public ShipmentDecorator(Shipment shipment) { 
        this.wrappedShipment= shipment;
    }
    public String getInfo() { 
        return wrappedShipment.getInfo();
    }
    public double getCost() { 
        return wrappedShipment.getCost();
    }
}
