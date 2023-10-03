public class Admin extends User
{
    int adminID;
    String department;

    Admin(int adminID, String username, String email, String department)
    {
        super (adminID, username, email);
        this.adminID = adminID;
        this.department = department;
    }

    void addProduct()
    {
        System.out.print("\nEnter product's name: ");
        OnlineRetailSystem.scan.nextLine();
        String name = OnlineRetailSystem.scan.nextLine();

        System.out.print("Enter product's price: ");
        int price = OnlineRetailSystem.scan.nextInt();

        System.out.print("Enter the product's stock quantity: ");
        int stockQuantity = OnlineRetailSystem.scan.nextInt();

        Order.products.add(new Product(name, price, stockQuantity));

    }

    void removeProduct()
    {

        System.out.println("\n=================REMOVE PRODUCT======================");    

        Order.displayAllProducts();
        System.out.print("\nEnter the product id that you want to remove: ");
        int productID = OnlineRetailSystem.scan.nextInt();

        if (productID > Order.products.size())
            System.out.println("Please enter a valid number. ");

        else
            Order.products.remove(productID);       

    }

    static int manageInventory()
    { 
        System.out.println("\n================MANAGE INVENTORY=====================");
        Order.displayAllProducts();
        
        System.out.println("\n1) Update Price \n2) Update Stock \n3) Back to admin option");
        System.out.print("Select an option: ");
        int userChoice = OnlineRetailSystem.scan.nextInt();

        switch (userChoice)
        {
            case 1:
                Product.updatePrice();
                break;
            
            case 2:
                Product.updateStock();
                break;
        }

        return userChoice;
    }

}