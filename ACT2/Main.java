import java.util.*;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner (System.in);
        int size = 3, userOption, index;

        System.out.println("============MENU============");
        System.out.print("\nCreate array size: ");
        size = scan.nextInt();

        MyArray arr = new MyArray(size);
        
        do
        {
            System.out.println("\n============================");
            System.out.println("\n1) Add Element");
            System.out.println("2) View Elements");
            System.out.println("3) Remove Element");
            System.out.println("4) Search Element");
            System.out.println("5) Sort");
            System.out.println("6) Edit");
            System.out.println("7) Exit");
            System.out.print("Select an option: ");
            userOption = scan.nextInt();

            switch(userOption)
            {
                case 1:                  
                    
                    int num;
                    do
                    {
                        System.out.println("\n============================");
                        System.out.print("\nEnter value (Press 0 to stop): ");
                        num = scan.nextInt();
                        if (num != 0)
                            arr.add(num);

                    }while(num != 0);
                    break;

                case 2:
                    arr.viewElements();
                    break;

                case 3: 
                    arr.viewElements();
                    System.out.println("\n============================");
                    System.out.print("\nEnter the index: ");
                    index = scan.nextInt();

                    while(index > arr.size)
                    {
                        System.out.println("\n============================");
                        System.out.println("\nPlease enter a valid index");
                        arr.viewElements();
                        System.out.print("\nEnter the index: ");
                        index = scan.nextInt();
                    }

                    arr.remove(index);
                    arr.viewElements();
                    break;      
                
                case 4:
                    System.out.println("\n============================");
                    System.out.print("\nEnter the value: ");
                    int value = scan.nextInt();
                    arr.viewElements();
                    arr.search(value);
                    break;
                
                case 5:
                    System.out.println("\n============================");
                    System.out.println("\n   1) Ascending \n   2) Descending");
                    System.out.print("   Select an option: ");
                    int userOption1 = scan.nextInt();

                    System.out.println("\nBefore Sorting: ");
                    arr.viewElements();
                    
                    if (userOption1 == 1 && !arr.isEmpty())
                    {                        
                        arr.sortAscending();
                        System.out.println("\n============================");
                        System.out.println("\nAfter Sorting: ");
                        arr.viewElements();
                    }
                                        
                    else if (userOption1 == 2 && !arr.isEmpty())
                    {
                        arr.sortDescending();
                        System.out.println("\n============================");
                        System.out.println("\nAfter Sorting: ");
                        arr.viewElements();
                    }                                         
                    break;

                case 6:
                    arr.viewElements();
                    if (!arr.isEmpty())
                    {
                        System.out.print("\nEnter the index: ");
                        index = scan.nextInt();
                        arr.editElement(index);
                        arr.viewElements();
                        
                    }               
                    break;

                case 7:
                    System.out.println("\nGoodbye!");
                    break;

            }
        }while(userOption != 7);
    }
}
