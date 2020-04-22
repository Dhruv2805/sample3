package assignment_18_april;

/* to check whether the given number is a palindrome or not*/

import java.util.Scanner;

public class Palindrome 
{
	public static void main(String[] args) 
	{
		
	
	int sum=0;
	int r;
	int temp=0;
	
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the value of a number ");
		int numb=sc.nextInt();
		
		numb=temp;
		while(numb>0)
		{
			r=numb%10;
			sum=(sum*10)+r;
			numb=numb/10;
		}
		
		if(sum==temp)
		{
			System.out.println("it is a palindrome number");
		}
		else
		{
			System.out.println(" it is not a palindrome number");
		}
	}
}
