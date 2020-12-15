
public abstract class HoneyBee extends Insect {

	//fields
	private int foodCost;
	
	//constructor
	public HoneyBee(Tile position, int hp, int foodCost) {
		super(position, hp);
		this.foodCost = foodCost;
	}
	
	//get and set method
	public int getCost() {
		return this.foodCost;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof HoneyBee) {
			HoneyBee testHB = (HoneyBee) obj;
			if (super.equals(testHB) && this.foodCost == testHB.foodCost) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
