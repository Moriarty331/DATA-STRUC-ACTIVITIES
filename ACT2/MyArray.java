import java.util.*;

public class MyArray 
{
    Scanner scan = new Scanner (System.in);

    private int[] arr;
    int size, index, count, value;

    MyArray(int size)
    {
        this.size = size;
        arr = new int[size];
        index = -1;
        count = 0;
        value = 0;
    }

    boolean isFull()
    {
        return count == size;
    }

    boolean isEmpty()
    {
        return count == 0;
    }

    public void add(int value)
    {
        if (isFull())
        {
            System.out.println("\n    The array is full.");
            return; // this will return nothing and just stops the method
        }

        arr[++index] = value;
        count++;

        viewElements();
    }   

    public void viewElements()
    {  
        if (isEmpty())
        {
            System.out.println("\n    The array is empty.");
            return;
        } 
        
        for (int i = 0; i < arr.length; ++i)
        {
            System.out.printf("\n      MyArray[%d] = %d", i, arr[i]);
        }
        System.out.println();
        
    }

    public void remove(int _index)
    {
        
        if (isEmpty())
        {
            System.out.println("The array is empty.");
            return;
        }
        
        arr[_index] = 0;
        count--;

        viewElements();
    }

    public void search(int value)
    {
        if (isEmpty())
        {
            System.out.println("\nThe array is empty.");
            return;
        }

        viewElements();
        boolean element = false;

        for (int i = 0; i < arr.length; ++i)
        {
            if (arr[i] == value)
                element = true;
        }

        if (element == false)
        {
            System.out.printf("\nThe number %d is not in the array.\n", value);
            return;
        }
        
        for (int i = 0; i < arr.length; ++i)
        {
            if (arr[i] == value)
                System.out.printf("\nThe number %d is located at index %d", value, i);
        }

        System.out.println();   
    }

    public void sortAscending()
    {
        if (isEmpty())
        {
            System.out.println("\nThe array is empty.");
            return;
        }

        for (int a = 0; a < size; ++a)
        {
            for (int b = a + 1; b < size; ++b)
            {
                if (arr[a] > arr[b])
                {
                    int temp = arr[a];
                    arr[a] = arr[b];
                    arr[b] = temp;
                }
            }
        }
    }

    public void sortDescending()
    {
        if (isEmpty())
        {
            System.out.println("\nThe array is empty.");
            return;
        }

        for (int a = 0; a < size; ++a)
        {
            for (int b = a + 1; b < size; ++b)
            {
                if (arr[b] > arr[a])
                {
                    int temp = arr[a];
                    arr[a] = arr[b];
                    arr[b] = temp;
                }
            }
        }
        


    }

    public void editElement(int index)
    {
        if (isEmpty())
        {
            System.out.println("\nThe array is empty.");
            return;
        }

        int _value;
        
        do
        {
            System.out.printf("\n      MyArray [%d] = %d\n", index, arr[index]);
            System.out.print("\nEnter the new value: ");
            _value = scan.nextInt();
    
            if (_value == arr[index])
            {
                System.out.println("\nNew value should not be the same from before.");
            }
    
            else
            {
                arr[index] = _value;
                return;
            }       

        }while(_value == arr[index]);
    }
    
}
