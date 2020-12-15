
public abstract class Insect {
	//fields
	private Tile position;
	private int hp;
	
	//constructor
	public Insect(Tile position, int hp) {
		this.position = position;
		this.hp = hp;
		
		if (this.position.addInsect(this)==false && this instanceof HoneyBee) {
			throw new IllegalArgumentException("There is already a bee on this tile.");
		}
	}
	
	//getters and setters
	public final Tile getPosition() {
		return this.position;
	}
	
	public final int getHealth() {
		return this.hp;
	}
	
	public void setPosition(Tile position) {
		this.position = position;
	}
	
	public void takeDamage(int damageDone) {
		if ((this instanceof HoneyBee || this instanceof BusyBee || this instanceof TankyBee || this instanceof StingyBee) && this.position.isHive()) {
			double newDamage = damageDone*0.9;
			int realDamage = (int) Math.floor(newDamage);
			this.hp -= (realDamage);
		} else {
			this.hp -= damageDone;
		}
		if (this.hp <= 0) {
			this.position.removeInsect(this);
		}
	}
	
	public abstract boolean takeAction();
	
	public boolean equals(Object obj) {
		if (obj instanceof Insect) {
			Insect testInsect = (Insect) obj;
			if (this.position == testInsect.position && this.hp == testInsect.hp) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}