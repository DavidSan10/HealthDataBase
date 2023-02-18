package Presenter;

public class City {
	private String name;
	private String id;
	//private static int idCount = 1;
	
	
	public City(String name) {
		this.name = name;
//		System.out.println("Contador de cuidad"+ idCount);
//		this.id = ""+ idCount++;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


//	public static int getIdCount() {
//		return idCount;
//	}
//
//	
	
	

}
