package model;

public class City {
	private String name;
	private String id;

	public City(String id, String name) {
		this.name = name;
		this.id = id;
	}

	public City(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return name + " " + id;
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

	public void setId(String id) {
		this.id = id;
	}

	public Object[] toObjectVectorCity() {
		return new Object[] { getId(), getName().toUpperCase() };
	}

}
