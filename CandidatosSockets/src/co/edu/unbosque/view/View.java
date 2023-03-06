package co.edu.unbosque.view;

import java.util.Scanner;

public class View {
	private Scanner sc;
	private boolean anterio_n;
	public View() {
		sc =new Scanner(System.in);
		anterio_n = false;
	}
	public double readDouble() {
		double aux = 0.0;
		try {
			aux = sc.nextDouble();
		} catch (Exception e) {
			System.out.println("Por favor ingresar numeros");
			aux = sc.nextDouble();
		}
		return aux;
	}
	public int readint() {
		int aux = 0;
		try {
			aux = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Por favor ingresar numeros");
			aux = sc.nextInt();
		}
		return aux;
	}
	public void burnLine() {
		sc.nextLine();
	}
	public String readStringLine() {
		return sc.nextLine();
	}
	
	public String readString() {
		return sc.next();
	}

	public void printString(String str) {
		
		System.out.println(str);
	}
	
	public void printStringInLine(String str) {
		System.out.print(str);
	}
	

}
