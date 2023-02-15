package model;

public enum Cormorbidities {
	CARDIOVASCULAR("Cardiovascular"), MUSCULAR("Muscular"), MENTAL("Mental"), OSSEOUS("Oseo"), NERVOUS("Nervioso"),
	RESPIRATORY("Respiratorio"), DIGESTIVE("Digestivo"), NOT_REGISTER("No registra");

	private String cormorbidities;

	Cormorbidities(String cormorbidities) {
		this.cormorbidities = cormorbidities;
	}

	public String getName() {
		return cormorbidities;
	}
}
