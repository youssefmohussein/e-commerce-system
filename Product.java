public class Product {
    String name;
    double price;
    int quantity;
    boolean isExpirable;
    boolean isShippable;
    boolean isExpired;
public Product(String name, double price, int quantity,
boolean isExpirable, boolean isShippable, boolean isExpired)
{
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.isExpirable = isExpirable;
    this.isShippable = isShippable;
    this.isExpired = isExpired;
} 
public String getName(){
     return name; 
    }
}