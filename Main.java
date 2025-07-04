public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Youssef", 1000);

        Product cheese = new Product("Cheese", 100, 10, true, true, false);
        Product biscuits = new Product("Biscuits", 150, 5, true, true, false);
        Product tv = new Product("TV", 300, 3, false, true, false);

        Cart cart = new Cart();
        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 1);
        cart.addProduct(scratchCard, 1);

        cart.checkout(customer);
    }
}
