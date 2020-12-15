
public class Hornet extends Insect {
	//fields
	private int attackDamage;
	
	//constructor
	public Hornet(Tile position, int hp, int attackDamage) {
		super(position, hp);
		this.attackDamage = attackDamage;
	}
	
	public boolean takeAction() {
		boolean result = false;
		
		if (this.getPosition() == null) {
			result = false;
		}
		
		if (this.getPosition().isHive() && this.getPosition().getBee() == null) {
			result = false;
		}
		
		if (this.getPosition().getBee() != null) {
			this.getPosition().getBee().takeDamage(this.attackDamage);
			result = true;
		}
		
		else if (this.getPosition().isHive() == false) {
			Tile myTile = this.getPosition();
			Insect myInsect = (Insect) this;
			myTile.removeInsect(myInsect);
			this.setPosition(myTile.towardTheHive());
			this.getPosition().addInsect(this);
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Hornet) {
			Hornet testHornet = (Hornet) obj;
			if (super.equals(testHornet) && this.attackDamage == testHornet.attackDamage) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
