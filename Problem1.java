package JavaProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Arithmetic {
	public double num1;
	public double num2;
	public double num3;

	public Arithmetic() {

	}

	public abstract void calculate();

	public void read(double a, double b) {
		this.num1 = a;
		this.num2 = b;
	}

	public void display() {
		System.out.println("Result : " + num3);
	}
}

class Addition extends Arithmetic {
	Addition(double num1, double num2){
		this.num1=num1;
		this.num2=num2;
	}
	@Override
	public void calculate() {
		System.out.println("Result : "+(num1+num2));
	}
}

class Subtraction extends Arithmetic {

	Subtraction(double num1, double num2){
		this.num1=num1;
		this.num2=num2;
	}
	
	@Override
	public void calculate() {
		System.out.println("Result : "+(num1-num2));
	}
}

class Multiplication extends Arithmetic {

	Multiplication(double num1, double num2){
		this.num1=num1;
		this.num2=num2;
	}
	
	@Override
	public void calculate() {
		System.out.println("Result : "+(num1*num2));
	}
}

class Division extends Arithmetic {

	Division(double num1, double num2){
		this.num1=num1;
		this.num2=num2;
	}
	
	@Override
	public void calculate() {
		System.out.println("Result : "+(num1/num2));
	}
}

public class Problem1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Arithmetic ar[]= new Arithmetic[4];
		
		int choice;
		double n1,n2;
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 1st number : ");
		n1=Double.parseDouble(br.readLine());
		System.out.println("Enter 2nd number : ");
		n2=Double.parseDouble(br.readLine());
		System.out.println("Enter Choice[1. Addition 2.Subtraction 3.Multiplication 4.Division : ");
		choice=Integer.parseInt(br.readLine());
		choice=choice-1;
		
		ar[0]=new Addition(n1, n2);
		ar[1]=new Subtraction(n1, n2);
		ar[2]=new Multiplication(n1, n2);
		ar[3]=new Division(n1, n2);
		ar[choice].calculate();
		
	}

}
