package co.edu.unbosque.model.persistance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;

public class FileHandler {
	private static File file;
	private static Scanner reader;
	private static PrintWriter writer;
	private static Properties prop;

	//leer serializados
	private static FileInputStream fis;
	private static ObjectInputStream ois;

	//escribir ser
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;

	public static Object readSerializable(String filename) {
		try {
			fis = new FileInputStream("src/co/edu/unbosque/model/persistance/"+filename);
		} catch (FileNotFoundException e) {
			System.out.println("Error reading (SERIALIZABLE)- read ");

		}
		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			System.out.println("Error reading (SERIALIZABLE)- read "+e.getMessage());
		}
		Object aux = null;
		try {//lee
			aux =  ois.readObject();
		} catch (ClassNotFoundException e) {//no HACE PARTE DEL pr  verifique integridad 
			System.out.println("Error on Integrity (serializable read )"+e.getMessage());
		} catch (IOException e) {
			System.out.println("Error on Permisos (serializable read )"+e.getMessage());

		}
		return aux;
	}
	public static void writeSerializable(Object o, String filename) {
		try {//buscar
			fos = new FileOutputStream("src/co/edu/unbosque/model/persistance/" + filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not found serializable ");
			System.out.println(e.getMessage());
		}
		try {//coge e archivo y selecciona para escribir 
			oos = new ObjectOutputStream(fos);
			//Escribe el objeto 
			oos.writeObject(o);

		} catch (IOException e) {
			System.out.println("ERROR on writing serializable "); //el error se localiza en que hay error en el archivo puede que este corrupto o tenga clave
			System.out.println(e.getMessage());
		}
		try {
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("No se pudo cerrar (serializable)");
			System.out.println(e.getMessage());

		}
	}
	public static String loadFile(String filename) {
		file = new File("src/co/edu/unbosque/model/persistance/" + filename);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Can't create new file");
				System.out.println(e.getMessage());
			}
		}
		String content = "";
		try {
			reader = new Scanner(file);
			while(reader.hasNext()) {
				content += reader.nextLine()+"\n";
			}
		} catch (FileNotFoundException e) {
			System.out.println("File doesn't exist"+e.getMessage());
		}
		return content;

	}


	public static void writeFile(String filename, String content) {
		file = new File("src/co/edu/unbosque/model/persistance/" + filename);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("can't create new file");
				System.out.println(e.getMessage());
			}
		}
		try {
			writer = new PrintWriter(file);
			writer.print(content);
		} catch (FileNotFoundException e) {
			System.out.println("file doesn't exists");
			e.printStackTrace();
		}
		writer.close();
	}

	public static Properties loadProperties() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("src/co/edu/unbosque/model/persistance/propiedades.properties")));
		}
		catch (IOException e) {
			System.out.println("ERROR LOADING PROGRAM ");
		}
		return prop;
	}


}


