
public class TankyBee extends HoneyBee {
	
	//fields
	private int attackDamage;
	private int armour;
	
	//constructor
	public TankyBee(Tile position, int attackDamage, int armour) {
		super(position, 30, 3);
		
		this.attackDamage = attackDamage;
		this.armour = armour;
	}
	
	public boolean takeAction() {
		boolean result = false;
		if (this.getPosition() == null) {
			result = false;
		}
		else if (this.getPosition().getHornet() != null) {
			this.getPosition().getHornet().takeDamage(this.attackDamage);
			result = true;
		}
		return result;
	}
	
	public void takeDamage(int damageDone) {
		double multiplier = (100/(100 + this.armour));
		//double realDamage = (damageDone * multiplier);
		int damage = (int) Math.floor(damageDone*multiplier);
		//if (this.getPosition().isHive()) {
			//damage = (int) Math.floor(damage*0.9);
		//} this block should be taken care of in the superclass
		super.takeDamage(damage);
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof TankyBee) {
			TankyBee testTB = (TankyBee) obj;
			if (super.equals(testTB) && this.attackDamage == testTB.attackDamage && this.armour == testTB.armour) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
