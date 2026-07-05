public class InventoryMain {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product p1 = new Product(101, "Laptop", 50, 75000.00);
        Product p2 = new Product(102, "Mouse", 200, 500.00);
        Product p3 = new Product(103, "Keyboard", 150, 1200.00);

        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        System.out.println();
        inventory.displayAllProducts();

        System.out.println();
        inventory.updateProduct(102, "Wireless Mouse", 180, 750.00);

        System.out.println();
        inventory.deleteProduct(103);

        System.out.println();
        inventory.displayAllProducts();

        System.out.println();
        inventory.addProduct(new Product(101, "Duplicate Laptop", 10, 50000.00));
    }
}
