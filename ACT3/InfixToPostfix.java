import java.util.*;
public class InfixToPostfix
{
    public static void main(String[] args) 
    {
		Scanner scan = new Scanner(System.in);
		String expression, result;
		ArrayList<String> postfix = new ArrayList<>();
		System.out.print("Enter expression: ");
		expression = scan.nextLine();

		postfix = toPostFix(expression);		
		System.out.print("Postfix: " + postfix);
		System.out.println();
		result = evaluate(postfix);
		
		System.out.println("Result: " + result);
    }

    static ArrayList<String> toPostFix(String expression)
    {
        expression = expression.replaceAll(" ", "");
		Stack <Character> stack = new Stack<>();
		ArrayList<String> postfix = new ArrayList<>();
		String temp = "";

        for (int i = 0; i < expression.length(); ++i)
		{
		    //System.out.println(expression);
		    if (Character.isDigit(expression.charAt(i)))//if the current char is a number
		    {
				temp = "";
		        while(i < expression.length() && Character.isDigit(expression.charAt(i))) 
		        {
		            //System.out.println(i);
					temp += String.valueOf(expression.charAt(i));
                    ++i;
                }
                i--;
				postfix.add(temp);
		    }
		        
		    else //if the current char is an operator
		    {
				//System.out.println("Current: " + expression.charAt(i));

		        if (stack.empty())
		            stack.push(expression.charAt(i));
					  
		        else
		        {
		            switch (expression.charAt(i))
		            {
		                case '(':
		                    stack.push(expression.charAt(i));
		                    break;

		                case ')':
		                    while (!stack.peek().equals('('))
		                    {
		                        if (stack.peek() != '(')
									postfix.add(String.valueOf(stack.pop()));
		                    }
							stack.pop();
		                    break;
		                    
		                case '+':
		                case '-':
		                if (stack.peek().equals('+') || stack.peek().equals('-') || stack.peek().equals('*') || stack.peek().equals('/'))
		                {
		                    while (!stack.empty())
								postfix.add(String.valueOf(stack.pop()));

		                    stack.push(expression.charAt(i));
		                }
		                else
		                    stack.push(expression.charAt(i));
		                break;
		                
		                case '*':
		                case '/':
		                    if (stack.peek().equals('+') || stack.peek().equals('-') || stack.peek().equals('('))
		                    {		                        
    		                    stack.push(expression.charAt(i));
		                    }
		                    
		                    else if (stack.peek().equals('*') || stack.peek().equals('/'))
		                    {
		                        while (!stack.empty())
		                            postfix.add(String.valueOf(stack.pop()));

		                        stack.push(expression.charAt(i));
		                    }
		                break;
		                    
		            }
		        }
		    }
			/*
			System.out.println("Stack: " + stack);
			System.out.println("Postfix: " + postfix);	
			System.out.println();*/ 
		}//end of loop

		while (!stack.isEmpty())
			postfix.add(String.valueOf(stack.pop()));

        return postfix;
    }

	static String evaluate (ArrayList<String> postfix)
	{
		Stack <String> stack = new Stack<>();
		int count = 0;

		/*
		while (count != postfix.size())
		{
			if (isNumeric(postfix.get(count)))
			{
				count++;
			}
			
			else
			{
				String operator = postfix.get(count);
				String num2 = postfix.get(count - 1);
				String num1 = postfix.get(count - 2);
				String result = calculate(num1, num2, operator);
				postfix.set(0, result);
				System.out.println(postfix);
				//System.out.println(stack);
				//System.out.println(stack);
				count++;
			}
		} */


		for (String item : postfix)
		{
			if (isNumeric(item))
				stack.push(item);
			
			else 
			{
				stack.push(item);
				System.out.println(stack);
				String operator = stack.pop();
				String num2 = stack.pop();
				String num1 = stack.pop();
				String result = calculate(num1, num2, operator);
				//System.out.println(stack);
				stack.push(result);
				//System.out.println(stack);
			}
		}

		System.out.println(stack);
		return stack.pop();
	}

	static String calculate (String firstNum, String secondNum, String operator)
	{
		double num1 = Double.parseDouble(firstNum);
		double num2 = Double.parseDouble(secondNum);

		switch (operator)
		{
			case "+":
				return Double.toString(num1 + num2);

			case "-":
				return Double.toString(num1 - num2);

			case "/":
				return Double.toString(num1 / num2);

			case "*":
				return Double.toString(num1 * num2);	
		}

		return "";
	}

	public static boolean isNumeric(String strNum) 
    {
        if (strNum == null) 
        {
            return false;
        }
        try 
        {
            double d = Double.parseDouble(strNum);
        } 
            catch (NumberFormatException nfe) 
        {
            return false;
        }
        return true;
    }

	/*
	static String toPrefix(String expression)
    {
		expression = expression.replaceAll(" ", "");
		String reverse = toReverse(expression);
		expression = reverse;

		Stack <Character> stack = new Stack<>();
        String prefix = "";
		
        for (int i = 0; i < expression.length(); ++i)
		{
		    //System.out.println(expression);
		    if (Character.isDigit(expression.charAt(i)))//if the current char is a number
		    {
				//String temp = "";
		        while(i < expression.length() && Character.isDigit(expression.charAt(i))) 
		        {
		            //System.out.println(i);
					//temp += expression.charAt(i);
                    prefix += expression.charAt(i);
                    ++i;
                }
				//System.out.println("Current: " + temp);
                i--;
		    }
		        
		    else //if the current char is an operator
		    {
				//System.out.println("Current: " + expression.charAt(i));

		        if (stack.empty())
		            stack.push(expression.charAt(i));
		            
		        else
		        {
		            switch (expression.charAt(i))
		            {
		                case '(':
		                    stack.push(expression.charAt(i));
		                    break;

		                case ')':
		                    while (!stack.peek().equals('('))
		                    {
		                        if (stack.peek() != '(')
									prefix += stack.pop();
		                    }

							stack.pop();
		                    break;
		                    
		                case '+':
		                case '-':
		                if (stack.peek().equals('*') || stack.peek().equals('/'))
		                {
							prefix += stack.pop();
		                    stack.push(expression.charAt(i));
		                }
						else
							stack.push(expression.charAt(i));
		                break;
		                
		                case '*':
		                case '/':
		                    stack.push(expression.charAt(i));
		                break;
		                    
		            }
		        }
		    }
			/*
			System.out.println("Stack: " + stack);
			System.out.println("Prefix: " + prefix);	
			System.out.println();
		}//end of loop


		while (!stack.isEmpty())
			prefix += stack.pop();

        return toReverse(prefix);
    }


	static String toReverse(String str)
	{
		String finalStr = "";

		for (int a = str.length() - 1; a >= 0; --a)
		{
			char current = str.charAt(a);
			if(current == '(')
				finalStr += ')';
			else if (current == ')')
				finalStr += '(';
			else
				finalStr += current;
		}

		return finalStr;
	}*/
}