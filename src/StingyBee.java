
public class StingyBee extends HoneyBee {
	
	//fields
	private int attackDamage;
	
	//constructor
	public StingyBee(Tile position, int attackDamage) {
		super(position, 10, 1);
		this.attackDamage = attackDamage;
	}
	
	public boolean takeAction() { 
		boolean result = false;
		Hornet aHornet = this.getPosition().getHornet();
		if (this.getPosition().isOnThePath() || this.getPosition().isHive()) {
			if (aHornet != null) {
				Insect myInsect = (Insect) aHornet;
				myInsect.takeDamage(this.attackDamage);
				result = true;
			} else {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof StingyBee) {
			StingyBee testSB = (StingyBee) obj;
			if (super.equals(testSB) && this.attackDamage == testSB.attackDamage) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
