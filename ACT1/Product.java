public class Product 
{
    private int price, stockQuantity;
    private String name;
    int productID;

    Product(int productID, String name, int price, int stockQuantity)
    {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.productID = productID;
    }

    Product(String name, int price, int stockQuantity)
    {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
    
    Product()
    {
        
    }

    void setName(String name)
    {
        this.name = name;
    }

    void setPrice(int price)
    {
        this.price = price;
    }

    void setStockQuantity(int stockQuantity)
    {
        this.stockQuantity = stockQuantity;
    }

    void setProductID(int productID)
    {
        this.productID = productID;
    }

    int getPrice()
    {
        return price;
    }

    String getName()
    {
        return name;
    }

    int getProductID()
    {
        return productID;
    }

    int getStockQuantity()
    {
        return stockQuantity;
    }

     void displayProduct()
    {
        System.out.printf("\t\t   %s \t  %d\t      %d\n", name, price, stockQuantity);
    }

    void displayCart()
    {
        System.out.printf("\t\t%d\t%s\t  %.0f\t\n", stockQuantity, name, Order.calculateTotalAmount(price, stockQuantity));
    }
    
    void displayOrder()
    {
        System.out.printf("\t%d\t%s\t  %.0f\n", stockQuantity, name, Order.calculateTotalAmount(price, stockQuantity));
    }

    static void updatePrice()
    {
        System.out.print("Enter the product id of the product that you want to change the price: ");
        int productID = OnlineRetailSystem.scan.nextInt();
        
        System.out.printf("\nNew price for %s: ", Order.products.get(productID).getName());
        int price = OnlineRetailSystem.scan.nextInt();
        Order.products.get(productID).setPrice(price);
        
    }

    static void updateStock()
    {
        System.out.print("\nEnter the product id: ");
        int productID = OnlineRetailSystem.scan.nextInt();

        System.out.printf("\nNew stock quantity for %s: ", Order.products.get(productID).getName());
        int stockQuantity = OnlineRetailSystem.scan.nextInt();

        Order.products.get(productID).setStockQuantity(stockQuantity);
    }

}
