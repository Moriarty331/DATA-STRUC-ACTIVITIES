import java.util.*;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner (System.in);
        int size, userOption = 0, index;
        boolean isValid = true;
        System.out.println("============MENU============");
        System.out.print("\nCreate array size: ");
        size = scan.nextInt();

        MyArray arr = new MyArray(size);
        
        do
        {
            try
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
            }
            catch (Exception e){
                System.out.println("\nInvalid input. Please enter a number");
                scan.next();
                continue;
            }

            switch(userOption)
            {
                case 1:                  
                    
                    int num = 1;
                    do
                    {
                        try
                        {
                            System.out.println("\n============================");
                            System.out.print("\nEnter value (Press 0 to stop): ");
                            num = scan.nextInt();
                            if (num != 0)
                            arr.add(num);
                        }
                        catch (Exception e)
                        {
                            System.out.println("\nInvalid input. Please enter a number");
                            scan.next();
                            continue;
                        }

                    }while(num != 0);
                    break;

                case 2:
                    arr.viewElements();
                    break;

                case 3:
                    isValid = true;
                    while (isValid)
                    {
                        try
                        {
                            System.out.println("\n============================");
                            arr.viewElements();                
                            if (arr.isEmpty())
                                break;
                            System.out.print("\nEnter the index: ");
                            index = scan.nextInt();
                            arr.remove(index);
                            isValid = false;
                        }
                        catch(InputMismatchException e)//if the user enters a letter
                        {
                            System.out.println("\nPlease enter a number only.");
                            scan.next();
                        }

                        catch(Exception e)
                        {
                            System.out.println("\nPlease enter the correct index.");
                        }
                    }
                    break;      
                
                case 4:
                    isValid = true;
                    while (isValid)
                    {
                        try
                        {
                            System.out.println("\n============================");
                            System.out.print("\nEnter the value: ");
                            int value = scan.nextInt(); 
                            arr.search(value);
                            isValid = false;
                        }
                        catch(InputMismatchException e)//if the user enters a letter
                        {
                            System.out.println("\nPlease enter a number only.");
                            scan.next();
                        }

                        catch(Exception e)//if the user inputs the wrong index
                        {
                            System.out.println("\nPlease enter a valid number");                       
                        }

                        
                    }
                    break;
                
                case 5:
                    isValid = true;
                    do
                    {
                        try
                        {
                            System.out.println("\n============================");
                            System.out.println("\n   1) Ascending \n   2) Descending");
                            System.out.print("   Select an option: ");
                            int userOption1 = scan.nextInt();

                            
                            
                            if (userOption1 == 1 && !arr.isEmpty())
                            {     
                                System.out.println("\nBefore Sorting: ");
                                arr.viewElements();                   
                                arr.sortAscending();
                                System.out.println("\n============================");
                                System.out.println("\nAfter Sorting: ");
                                arr.viewElements();
                            }
                                                
                            else if (userOption1 == 2 && !arr.isEmpty())
                            {
                                System.out.println("\nBefore Sorting: ");
                                arr.viewElements();
                                arr.sortDescending();
                                System.out.println("\n============================");
                                System.out.println("\nAfter Sorting: ");
                                arr.viewElements();
                            }

                            else
                                {
                                    System.out.println("\n============================");
                                    System.out.println("\nPlease enter (1-2)");                               
                                    continue;
                                }
                            isValid = false;   
                        }
                        catch(Exception e)
                        {
                            System.out.println("\n============================");
                            System.out.println("\nPlease enter a valid number");
                            scan.next();   
                        }            
                    }while(isValid);         
                    break;

                case 6:
                    isValid = true;
                    do
                    {
                        try
                        {
                            System.out.println("\n============================");
                            arr.viewElements();
                            if (!arr.isEmpty())
                            {
                                
                                System.out.print("\nEnter the index: ");
                                index = scan.nextInt();
                                arr.editElement(index);
                                arr.viewElements();
                                
                            }               
                            isValid = false;
                        }
                        catch(InputMismatchException e)
                        {
                            System.out.println("\n============================");
                            System.out.println("\nPlease enter a number only.");
                            
                            scan.next();
                        }

                        catch(Exception e)
                        {
                            System.out.println("\n============================");
                            System.out.println("\nPlease enter the correct index.");
                        }
                    }while(isValid);
                    break;

                case 7:
                    System.out.println("\nGoodbye!");
                    break;

            }
        }while(userOption != 7);
    }
}
