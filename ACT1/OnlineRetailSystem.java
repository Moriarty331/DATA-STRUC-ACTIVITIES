import java.util.Scanner;


public class OnlineRetailSystem 
{
    static Scanner scan = new Scanner (System.in);

    static void start()
    {
        int userChoice;

        do
        {
            System.out.println("===========Welcome to Online Retail System===========\n");
            System.out.println("1) Customer \n2) Admin \n3) Exit");
            System.out.print("Select an option: ");
            userChoice = scan.nextInt();
                
            switch (userChoice)
            {
                case 1:
                customerLogin();
                break;

                case 2:
                adminLogin();
                break;

            }

        }while(userChoice != 3); 
    }

    static void customerLogin()
    {
        System.out.println("\n================CUSTOMER LOGIN======================\n");

        System.out.print("Enter your customer ID: ");
        int customerID = scan.nextInt();

        scan.nextLine();

        System.out.print("Enter your username: ");
        String customerUsername = scan.nextLine();

        System.out.print("Enter your email: ");
        String customerEmail = scan.nextLine(); 

        System.out.print("Enter your address: ");
        String address = scan.nextLine(); 
        
        Customer customer1 = new Customer(customerID, customerUsername, customerEmail, address);
        customer1.logIn();
        
        do
        {

        }while(OnlineRetailSystem.customerOption(customer1) != 3);

    }

    static int customerOption(Customer customer1)
    {
        System.out.println("=================CUSTOMER OPTION=====================\n");
        System.out.println("1) Place Order \n2) View Order History \n3) Back to login \n4) Logout");
        System.out.print("Select an option: ");
        int userChoice = scan.nextInt();    

        switch (userChoice)
        {
            case 1:
            do
            {

            }while(customer1.placeOrder(customer1) != 4);
            break;

            case 2:
            Customer.viewOrderHistory();
            break;
            
            case 4:
            customer1.logOut();
            System.exit(0);
        }

        System.out.println();
        return userChoice;
    }


    static void adminLogin()
    {
        System.out.println("\n===================ADMIN LOGIN=======================\n");
                        
        System.out.print("Enter your admin ID: ");
        int adminID = scan.nextInt();
                
        scan.nextLine();
                
        System.out.print("Enter your username: ");
        String adminUsername = scan.nextLine();
                
        System.out.print("Enter your email: ");
        String adminEmail = scan.nextLine(); 
                            
        System.out.print("Enter your department: ");
        String department = scan.nextLine(); 
                
        Admin admin = new Admin(adminID, adminUsername, adminEmail, department);

        admin.logIn();  
        
        do
        {

        }while(adminOptions(admin) != 4);
    }

    static int adminOptions(Admin admin)
    {
        System.out.println("\n==================ADMIN OPTION=======================\n");
        System.out.println("1) Add Product \n2) Remove Product \n3) Manage Inventory \n4) Back to Login \n5) Logout");
        System.out.print("Select an option: ");
        int userChoice = scan.nextInt();    
        
       
        switch (userChoice)
        {
            case 1:
                admin.addProduct();
                break;

            case 2:
                try{
                    admin.removeProduct();
                } catch(Exception e)
                {
                    System.out.println("\nPLease enter a valid number.");
                }
                break;

            case 3:
                do
                {
                    
                }while(Admin.manageInventory() != 3);
                break;
            case 5:
            admin.logOut();
            System.exit(0);

        }
        return userChoice;
    }
    
    public static void main (String[] args)
    {

        Order.products.add(new Product("Banana", 15, 100));
        Order.products.add(new Product("Grapes", 50, 100));
        Order.products.add(new Product("Apple", 15, 100));
        Order.products.add(new Product("Mango", 30, 100));

        OnlineRetailSystem.start();
    }                                 
                    
}



