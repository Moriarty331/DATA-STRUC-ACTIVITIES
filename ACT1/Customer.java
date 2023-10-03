import java.util.ArrayList;

public class Customer extends User
{

    String address;
    int customerID;

    static ArrayList <Product> orderHistory = new ArrayList<>();

    Customer(int customerID, String username, String email, String address)
    {
        super (customerID, username, email);
        this.customerID = customerID;
        this.address = address;
    }

    int placeOrder(Customer customer1)
    {
        Order.displayAllProducts();

        System.out.println("\n1) Add products to your cart");
        System.out.println("2) View orders in your cart");
        System.out.println("3) View Order History");
        System.out.println("4) Back");
        System.out.print("Select an option: ");
        int userChoice = OnlineRetailSystem.scan.nextInt();  

        switch (userChoice)
        {
            case 1:
                Order.addProductToOrder();

            case 2:
                Order.displayAllProducts();
                do
                {
                }while(Order.viewCart(customer1) == 3);
                break;

            case 3:
                Customer.viewOrderHistory();
                break;
        }

        return userChoice;  
    }

    static void viewOrderHistory()
    {
        System.out.println("\n=================ORDER HISTORY======================");

        if (orderHistory.isEmpty())
        {
            System.out.println("\n\tYou did not order any products.");
        }
        else
            Order.displayAllConfirmedOrder();
    }
}
