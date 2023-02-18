package Persistence;

import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import BinaryTree.BinaryTree;
import interfaz.ComparatorAdministrator;
import interfaz.ComparatorCity;
import interfaz.ComparatorCityName;
import interfaz.ComparatorHealthPost;
import interfaz.ComparatorPatient;
import model.Administrator;
import model.City;
import model.Cormorbidities;
import model.DocumentType;
import model.HealthPost;
import model.Patient;

public class Files {

	public Files() {
	}

//	public static void writeFileAdministrator(BinaryTree<Administrator> treeAdministrator) {
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String JsonFile = gson.toJson(treeAdministrator);
//		PrintWriter writer;
//		try {
//			//writer = new PrintWriter("src/Data/dataAdministrator.json");
//			writer = new PrintWriter("Data/dataAdministrator.json");
//			writer.write(JsonFile);
//			writer.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//
//	}
//	

	public static void writeFileAdministrator(BinaryTree<Administrator> treeAdministrator) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String JsonFile = gson.toJson(treeAdministrator);
		PrintWriter writer;
		try {
			// writer = new PrintWriter("src/Data/dataAdministrator.json");
			writer = new PrintWriter("Data2/dataAdministrator.json");
			writer.write(JsonFile);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

//
//	public static void writeFilesHealtPost(ArrayList<HealthPost> listHealthPost) {
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String JsonFile = gson.toJson(listHealthPost);
//		PrintWriter writer;
//		try {
//			//writer = new PrintWriter("src/Data/data.json");
//			writer = new PrintWriter("Data/data.json");
//			writer.write(JsonFile);
//			writer.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	public static void writeFilesHealtPost(BinaryTree<HealthPost> treeHealthPost) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String JsonFile = gson.toJson(treeHealthPost);
		PrintWriter writer;
		try {
			// writer = new PrintWriter("src/Data/data.json");
			writer = new PrintWriter("Data2/data.json");
			writer.write(JsonFile);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

//	public static void writeFilesCity(ArrayList<City> listCity) {
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String JsonFile = gson.toJson(listCity);
//        PrintWriter writer;
//		try {
//			//writer = new PrintWriter("src/Data/dataCity.json");
//			writer = new PrintWriter("Data/dataCity.json");
//		    writer.write(JsonFile);
//	         writer.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//	}

	public static void writeFilesCity(BinaryTree<City> treeCity) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String JsonFile = gson.toJson(treeCity);
		PrintWriter writer;
		try {
			// writer = new PrintWriter("src/Data/dataCity.json");
			writer = new PrintWriter("Data2/dataCity.json");
			writer.write(JsonFile);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

//	/*
//	 * Leer HealthPost 
//	 * 
//	 * */

//	public static ArrayList<HealthPost> readFilesHealthPost() {
//		Gson gson = new Gson();
//		FileReader jsonAll;
//		try {
//			jsonAll = new FileReader("src/Data/dataHealthPost.json");
//			HealthPost[] arrayHeathPost = gson.fromJson(jsonAll, HealthPost[].class);
//			ArrayList<HealthPost> listCity = getListHealthPost(arrayHeathPost);
//			jsonAll.close();
//			return listCity;
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	
//	public static ArrayList<HealthPost> readFilesHealthPostWithPatient() {
//		Gson gson = new Gson();
//		FileReader jsonAll;
//		try {
//			//jsonAll = new FileReader("src/Data/data.json");
//			jsonAll = new FileReader("Data/data.json");
//			HealthPost[] arrayHeathPost = gson.fromJson(jsonAll, HealthPost[].class);
//			ArrayList<HealthPost> listCity = getListHealthPost(arrayHeathPost);
//			jsonAll.close();
//			return listCity;
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	public static BinaryTree<HealthPost> readFilesHealthPostWithPatient() {
		Gson gson = new Gson();
		FileReader jsonAll;
		try {
			// jsonAll = new FileReader("src/Data/data.json");
			jsonAll = new FileReader("Data2/data.json");
			//new TypeToken<BinaryTree<HealthPost>>(){}.getType();
			BinaryTree<HealthPost> BinaryHealthPost = gson.fromJson(jsonAll,new TypeToken<BinaryTree<HealthPost>>(){}.getType());
			if(BinaryHealthPost == null) {
				BinaryHealthPost =  new BinaryTree<HealthPost>();
			}
		//	BinaryHealthPost.intOrder();
//			HealthPost[] array = gson.fromJson(aux,HealthPost[].class);
//			System.out.println(array);
			
			//BinaryTree<HealthPost> listCity = getListHealthPost(arrayHeathPost);
			jsonAll.close();
			return BinaryHealthPost;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

//	public static ArrayList<Administrator> readFilesAdministrator() {
//		Gson gson = new Gson();
//		FileReader jsonAll;
//		try {
//			//jsonAll = new FileReader("src/Data/dataAdministrator.json");
//			jsonAll = new FileReader("Data/dataAdministrator.json");
//			Administrator[] arrayAdministrator = gson.fromJson(jsonAll, Administrator[].class);
//			ArrayList<Administrator> listAdministrator = getListAdministrator(arrayAdministrator);
//			jsonAll.close();
//			return listAdministrator;
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//
//	}

	public static BinaryTree<Administrator> readFilesAdministrator() {
		Gson gson = new Gson();
		FileReader jsonAll;
		try {
			// jsonAll = new FileReader("src/Data/dataAdministrator.json");
			jsonAll = new FileReader("Data2/dataAdministrator.json");
			BinaryTree<Administrator> binaryAdministrator = gson.fromJson(jsonAll,new TypeToken<BinaryTree<Administrator>>(){}.getType());
			//BinaryTree<Administrator> listAdministrator = getListAdministrator(arrayAdministrator);
			jsonAll.close();
			return binaryAdministrator;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

//	public static ArrayList<City> readFilesCity() {
//		Gson gson = new Gson();
//		FileReader jsonAll;
//		try {
//			//jsonAll = new FileReader("src/Data/dataCity.json");
//			jsonAll = new FileReader("Data/dataCity.json");
//			City[] arrayCities = gson.fromJson(jsonAll, City[].class);
//			ArrayList<City> listCity = getListCity(arrayCities);
//			jsonAll.close();
//			return listCity;
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//
//	}

	public static BinaryTree<City> readFilesCity() {
		Gson gson = new Gson();
		FileReader jsonAll;
		try {
			// jsonAll = new FileReader("src/Data/dataCity.json");
			jsonAll = new FileReader("Data2/dataCity.json");
			BinaryTree<City> treeCities = gson.fromJson(jsonAll, new TypeToken<BinaryTree<City>>(){}.getType());
			//BinaryTree<City> listCity = getListCity(arrayCities);
		
			if(treeCities == null) {
				treeCities =  new BinaryTree<City>();
				System.out.println("entra a nulo?");
			}
			System.out.println("entraaaaaaaaaa" +  treeCities.getSize());
			jsonAll.close();
			return treeCities;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new BinaryTree<City>();

	}

//	public static ArrayList<HealthPost> getListHealthPost(HealthPost[] arrayHealthPost) {
//		ArrayList<HealthPost> listHealthPost = new ArrayList<HealthPost>();
//		for (int i = 0; i < arrayHealthPost.length; i++) {
//			listHealthPost.add(arrayHealthPost[i]);
//		}
//		return listHealthPost;
//	}

//	public static BinaryTree<HealthPost> getListHealthPost(HealthPost[] arrayHealthPost) {
//		BinaryTree<HealthPost> listHealthPost = new BinaryTree<HealthPost>();
//		for (int i = 0; i < arrayHealthPost.length; i++) {
//			listHealthPost.insert(arrayHealthPost[i], new ComparatorHealthPost());
//		}
//		return listHealthPost;
//	}

//	public static ArrayList<Administrator> getListAdministrator(Administrator[] arrayAdministrator) {
//		ArrayList<Administrator> listAdministrator = new ArrayList<Administrator>();
//		for (int i = 0; i < arrayAdministrator.length; i++) {
//			listAdministrator.add(arrayAdministrator[i]);
//		}
//		return listAdministrator;
//	}
//	
//	

//	public static BinaryTree<Administrator> getListAdministrator(Administrator[] arrayAdministrator) {
//		BinaryTree<Administrator> listAdministrator = new BinaryTree<Administrator>();
//		for (int i = 0; i < arrayAdministrator.length; i++) {
//			listAdministrator.insert(arrayAdministrator[i], new ComparatorAdministrator());
//		}
//		return listAdministrator;
//	}
	
	
//	public static ArrayList<City> getListCity(City[] arrayCity) {
//		ArrayList<City> listCity = new ArrayList<City>();
//		for (int i = 0; i < arrayCity.length; i++) {
//			listCity.add(arrayCity[i]);
//		}
//		return listCity;
//	}

//	public static BinaryTree<City> getListCity(City[] arrayCity) {
//		BinaryTree<City> listCity = new BinaryTree<City>();
//		for (int i = 0; i < arrayCity.length; i++) {
//			listCity.insert(arrayCity[i],new ComparatorCity());
//		}
//		return listCity;
//	}

	public static void goToURL(String URL) {
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			if (desktop.isSupported(Desktop.Action.BROWSE)) {
				try {
					URI uri = new URI(URL);
					desktop.browse(uri);
				} catch (URISyntaxException | IOException ex) {
				}
			}
		}
	}

	public static void main(String[] args) {

		//arraylist<administrator> listadministrator = new arraylist<administrator>();
		BinaryTree<Administrator> treeAdministrator = new BinaryTree<Administrator>();
		Administrator administrator = new Administrator(DocumentType.CITIZENSHIP_CARD,"1001176070","david","galvis",LocalDate.now(),"davidalejandro0903@gmail.com","david0903");
		treeAdministrator.insert(administrator, new ComparatorAdministrator());	
		Files.writeFileAdministrator(treeAdministrator);
		City city = new City("1","tunja");
		BinaryTree<City> treeCity = new BinaryTree<City>();
		treeCity.insert(city, new ComparatorCityName());
//		listadministrator.add(new administrator(documentype.citizenship_card,"1001176070","david","galvis",localdate.now(),"davidalejandro0903@gmail.com","david0903"));
	
//		ArrayList<City> listcity = new ArrayList<City>();
//		listcity.add(city);
		Files.writeFilesCity(treeCity);
		BinaryTree<Patient> tree = new BinaryTree<Patient>();	
		tree.insert(new Patient(DocumentType.CITIZENSHIP_CARD,"52203664","Patricia","Galvis",LocalDate.now(),Cormorbidities.NOT_REGISTER,LocalDate.now(),false,true),new ComparatorPatient());
		BinaryTree<HealthPost> treeHealthpost = new BinaryTree<HealthPost>();
////		arraylist<patient> listpatient = new arraylist<patient>();
		HealthPost health = new HealthPost("1","hospital de tunja",tree,city);
		treeHealthpost.insert(health,new ComparatorHealthPost());	
		Files.writeFilesHealtPost(treeHealthpost);

	}

}
