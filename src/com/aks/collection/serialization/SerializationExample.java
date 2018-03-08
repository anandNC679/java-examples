package com.aks.collection.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable{
	int empId;
	String name;
	Employee(int empId,String name){
		this.empId=empId;
		this.name=name;
	}
}

class Demo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	transient int a;
	static int  b;
	int age;
	String name;
	public Demo(int a,int b, int age, String name) {
		
		this.a = a;
		this.b = b;
		this.age = age;
		this.name = name;
	}
}
public class SerializationExample {

	public static void main(String[] args) {
		Employee employee =new Employee(101, "raju");
		String empFile = "/home/anand/Desktop/empFile.ser";
		
		try {
			FileOutputStream file = new FileOutputStream(empFile);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(employee);
			out.close();
			file.close();
			System.out.println("Object is serialized");
		}
		catch(IOException io) {
			io.printStackTrace();
			System.out.println("object not serialized");
		}
		
		try {
			FileInputStream fileInputStream = new FileInputStream(empFile);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			Employee employee2 =  (Employee)inputStream.readObject();
			System.out.println(employee2.empId+" "+employee2.name);
		}catch(IOException io) {
			io.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Demo demo = new Demo(10, 1000, 23, "DemoName");
		String path = "/home/anand/Desktop/empFile1.ser";
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(demo);
			System.out.println("Demo is serialized");
			//Demo.b=2000;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		demo=null;
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			Demo demo2 = (Demo)inputStream.readObject();
			System.out.println(demo2.a+" "+demo2.age+" "+demo2.name+" "+demo2.b);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
