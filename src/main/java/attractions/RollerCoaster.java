package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecurity, ITicketed {

    private double price;

    public RollerCoaster(String name, int rating) {
        super(name, rating);
        this.price = 8.45;
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        return visitor.getAge() > 12 && visitor.getHeight() > 145;
    }

    @Override
    public double defaultPrice() {
        return this.price;
    }

    @Override
    public double priceFor(Visitor visitor) {
        if (visitor.getHeight() > 200) {
            return defaultPrice() * 2;
        }
        return defaultPrice();
    }
}

