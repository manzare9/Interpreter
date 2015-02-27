package edu.seecs.interprator;

//Libraries Importing
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author Manzar Ali
 *
 */


//Main class starts here 
public class Interprator 
{

	
	static ArrayList<Input> input = new ArrayList<Input>();

	public static void InputFile(String fileName) throws IOException
	{
		Input obj = new Input(fileName, 0);
	
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String delimeter = " ";
		String line;
		String operator = null;
		
		int l = 0;
		int m = 0;
		int n = 0;
		
		boolean x;
		boolean y;
		boolean z;
		boolean a;
		boolean b;
		
		while((line = br.readLine()) != null)
		{
			x = y = z = a = b = false;
			System.out.println(line);
			
			// Tokenizing and handling of string file
			
			StringTokenizer token1 = new StringTokenizer(line,delimeter);

			
			String token2 = token1.nextToken();
			
			if(token2.equals ("LET"))
			{

				if(line.startsWith("LET"))
				{
				while(token1.hasMoreElements())
				{
					System.out.println("Token is: "+ token1.nextElement());
					String token = (String) token1.nextElement();
					
					String name;
					int value;


					System.out.println("4");
					name = token1.nextToken();

					System.out.println(token);
					System.out.println("4");
					
					if(token1.nextToken().equals("="))
					{
				        System.out.println("4");
						value = Integer.parseInt(token1.nextToken());
						
						input.add(new Input(name,value));
						System.out.println(obj.name);
						System.out.print(obj.value);
					}

					}
					System.out.println(token2);

				}

			}



			else if(token2.equals("Print"))
			{
				boolean flag = false;
				token2 = token1.nextToken();
				for(int i = 0;i<input.size();i++)
				{
					if(token2.equals(input.get(i).name))
					{
						System.out.print(input.get(i).value+ "\n");
						flag = true;
						break;

					}

				}


				if(flag == false){

					System.out.println(token2+ " No variable or string is found");

				}

			}


			else{
				if(!(isInteger(token2))){

					while(token1.hasMoreElements()){
						if(b  == false){
							b = true;

						}
						else{
							token2 = token1.nextToken();
						}
						if(token2.equals("+") || token2.equals("-") || token2.equals("*") || token2.equals("/")){

							operator = token2;

						}
						else{
							
							for( int i = 0;i<input.size();i++){
								if(token2.equals(input.get(i).name)){
								
									x = true;
									if(y == false){
										
										n = i;
										y = true;
							
									}
									else if(z == false){
										l = input.get(i).value;
										z = true;
										
									}
									else if(a == false)
									{
										m = input.get(i).value;
										a = true;
						
									} 

									if(y == true && z == true && a == true){

										
										l = calculate(operator,l,m,n);
										
										a = false;

									}
									break;

								}
							

							}
							if(z == false){

								System.out.println(token2 + " No variable or string is found ");

							}

						}
					}
					
					input.get(n).value = l;

				}
				
				else{
					
					System.out.println("The input "+ token2 +" is not correct");

				}
				


			}
		}
	}

	
	

	public static boolean isInteger(String str) 
	{
		try 
		{
			Integer.parseInt(str);
			return true;
		}
		catch (NumberFormatException nfe) 
		{
			return false;
		}
	}
	
	
	//Arithmetic evaluations and precedence.
	
	public static int calculate(String operator, int i, int j, int k)
	{
		int result = 0;
		switch(operator)
		{
		case "+":
			result = i + j;
			break;
			
		case "-":
			result = i - j;
			break;
			
		case "*":
			result = i * j;
			break;
			
		case "/":
			result = i / j;
			break;
		}

		return result;

	}

	
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
	
		String file = "sample.txt";
		InputFile(file);
	}

}
