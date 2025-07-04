import java.util.*;

public class Cart {
    static class CartItem {
        Product product;
        int quantity;

        public CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }
    }

    List<CartItem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        if (product.quantity < quantity) {
            System.out.println("Not enough stock for " + product.name);
            return;
        }
        items.add(new CartItem(product, quantity));
        product.quantity -= quantity;
    }

    public void checkout(Customer customer) {
        if (items.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        for (CartItem item : items) {
            if (item.product.isExpired) {
                System.out.println("Cannot checkout. Product expired " + item.product.name);
                return;
            }
        }

        double subtotal = 0;
        double shipping = 0;
        List<Product> toShip = new ArrayList<>();

        for (CartItem item : items) {
            subtotal += item.product.price * item.quantity;
            if (item.product.isShippable) {
                toShip.add(item.product);
                shipping += 10; // Flat 10 per shippable item
            }
        }

        double total = subtotal + shipping;
        if (!customer.canPay(total)) {
            System.out.println("Customer cannot afford the total amount!");
            return;
        }

        customer.remainigBalance(total);

        ShippingService.ship(toShip);

        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.println(item.quantity + "x " + item.product.name + " " + (item.product.price * item.quantity));
        }
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shipping);
        System.out.println("Amount " + total);
        System.out.println("Customer balance after payment: " + customer.balance);
    }
}
