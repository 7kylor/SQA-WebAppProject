
 class Invoice {
    public static double calculateDiscount(double price, int quantity) {
        double totalCost = price * quantity;
        double discount = 0;

        if (quantity > 0) {
            int additionalDiscount = (quantity - 1) / 5
            discount = totalCost * (0.05 + (additionalDiscount * 0.01)); 
        }

        double finalCost = totalCost - discount;
        return finalCost;
    }

    public static void printInvoice(Item[] items) {
        int totalQuantity = 0;
        double totalCost = 0;

        for (Item item : items) {
            int quantity = item.getQuantity();
            double price = item.getPrice();

            totalQuantity += quantity;
            totalCost += calculateDiscount(price, quantity);
        }

        System.out.println("Invoice:");
        System.out.println("Total Quantity: " + totalQuantity);

        if (totalQuantity > 0) {
            System.out.println("Total Cost: " + totalCost);
            System.out.println(totalQuantity > 5 ? "Discount Applied!" : "No Discount Applied.");
            System.out.println(totalQuantity > 5 ? "Thank you for your purchase!" : "No items eligible for discount.");
            System.out.println(totalQuantity > 5 ? "Large invoice!" : "Small invoice.");
        } else {
            System.out.println("No items in the invoice.");
        }
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(2, 10),
                new Item(3, 20),
                new Item(1, 30),
                new Item(5, 15),
                new Item(4, 25),
                new Item(6, 5),
                new Item(0, 0),
                
        };

        printInvoice(items);
    }
}

class Item {
    private int quantity;
    private double price;

    public Item(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
