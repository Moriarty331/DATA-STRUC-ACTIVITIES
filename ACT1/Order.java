import java.util.*;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class


public class Order
{
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
    String formattedDate = myDateObj.format(myFormatObj);  

    int customerID;
    int totalAmount;
    String orderDate;
    static int cartTotalAmount = 0;

    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Product> carts = new ArrayList<>();
    static ArrayList<Order> confirmedOrders = new ArrayList<>();

    Order(int customerID, int totalamount)
    {
        this.totalAmount = cartTotalAmount;
        this.customerID = customerID;
        this.orderDate = formattedDate;
    }

    void setCustomerID(int customerID)
    {
        this.customerID = customerID;
    }

    void displayConfirmedOrders()
    {
        System.out.println("Customer ID: " + customerID);
        System.out.println("Date: " + orderDate);
        System.out.println("Total amount: " + totalAmount);
    }

    static void displayAllConfirmedOrder()
    {
        int index = 0;

        for (Order order: confirmedOrders)
        {
            System.out.println("\nOrder ID: " + index);
            order.displayConfirmedOrders();
            index++;
        }
    }

    static void confirmOrder(Customer customer1)
    {
        System.out.println("\n======================MY OrDER========================\n"); 

        if (!Order.carts.isEmpty())
            System.out.println("\t      You have successfully ordered:\n");
        
        for (Product cart : carts)
        {

            int cartProductID = cart.getProductID();
            Order.products.get(cartProductID).setStockQuantity(Order.products.get(cartProductID).getStockQuantity() - cart.getStockQuantity());
            cart.displayCart();

        }

        if (!Order.carts.isEmpty())
        {
            System.out.println("\t\t______________________");
            System.out.println("\n\t\tTotal : " + cartTotalAmount);
        }

        if (!carts.isEmpty())
            confirmedOrders.add(new Order(customer1.customerID, cartTotalAmount));

        Order.carts.clear();               
    }

    static void displayAllProducts()
    {
        System.out.println("\n Product ID\t Product Name\t Price\t Stock Quantity\n");

        int index = 0;
        for (Product product : products)
        {
            System.out.printf("    [%d]", index);
            product.displayProduct();
            index++;
        }

    }

    static double calculateTotalAmount(int price, int quantity)
    {
        return price * quantity;
    }

    
    static void addProductToOrder()
    {
        System.out.print("\nEnter product id: ");
        int productID = OnlineRetailSystem.scan.nextInt();

        System.out.print("How many products do you want to buy? ");
        int stockQuantity = OnlineRetailSystem.scan.nextInt();

        Product product = Order.products.get(productID);

        Order.carts.add(new Product(productID, product.getName(), product.getPrice(), stockQuantity));

    }
    
    static int viewCart(Customer customer1)
    {
        int userChoice;
        
        System.out.println("\n======================MY CART========================\n");   

        if (Order.carts.isEmpty())
        {
            System.out.println("    You did not put any products in your cart.");
        }

        else
        {
            for (Product cart : carts)
            {            
                cart.displayCart(); 
                cartTotalAmount += calculateTotalAmount(cart.getPrice(), cart.getStockQuantity());
            }

            
        }

        if (!Order.carts.isEmpty())
        {
            System.out.println("\t\t______________________");
            System.out.println("\n\t\tTotal : " + cartTotalAmount);
        }

        System.out.println("\n1) Confirm Order \n2) Delete products in your cart \n3) Buy more \n4) Back");

        System.out.print("Select an option: ");
        userChoice = OnlineRetailSystem.scan.nextInt();

        switch (userChoice)
        {
            case 1:
            if (!carts.isEmpty())
            {
                for (Product cart: carts)
                {
                    Customer.orderHistory.add(new Product(cart.getName(), cart.getPrice(), cart.getStockQuantity()));;  
                }
            }   
            confirmOrder(customer1);
            break;

            case 2:
            Order.carts.clear();
            break;

            case 3:
            displayAllProducts();
            addProductToOrder();
            break;
        }

        return userChoice;

    }

    
  
}
