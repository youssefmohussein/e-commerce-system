import java.util.*;

public class ShippingService {
    public static void ship(List<Product> products) {
        if (products.isEmpty()) return;
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Product p : products) {
            System.out.println("1x " + p.name + " " + (p.weight * 1000) + "g");
            totalWeight += p.weight;
        }
        System.out.println("Total package weight: " + totalWeight + "kg");
    }
}
