public class Tile {

	//fields
	private int foodPresent;
	private boolean hasBeeHive;
	private boolean hasHornetNest;
	private boolean onPath;
	private Tile nextFromHornet;
	private Tile nextFromBee;
	private HoneyBee beeOnTile;
	private SwarmOfHornets hornetsOnTile;
	private int foodCollected;
	
	//constructors
	public Tile() {
		this.foodPresent = 0;
		this.hasBeeHive = false;
		this.hasHornetNest = false;
		this.onPath = false;
		this.nextFromHornet = null;
		this.nextFromBee = null;
		this.beeOnTile = null;
		this.hornetsOnTile = new SwarmOfHornets();
	}
	
	public Tile(int foodPresent, boolean hasBeeHive, boolean hasHornetNest, boolean onPath, Tile nextFromHornet, Tile nextFromBee, HoneyBee beeOnTile, SwarmOfHornets hornetsOnTile) {
		this.foodPresent = foodPresent;
		this.hasBeeHive = hasBeeHive;
		this.hasHornetNest = hasHornetNest;
		this.onPath = onPath;
		this.nextFromHornet = nextFromHornet;
		this.nextFromBee = nextFromBee;
		this.beeOnTile = beeOnTile;
		this.hornetsOnTile = hornetsOnTile;
	}
	
	//get and set methods
	public boolean isHive() {
		return this.hasBeeHive;
	}
	
	public boolean isNest() {
		return this.hasHornetNest;
	}
	
	public void buildHive() {
		this.hasBeeHive = true;
	}
	
	public void buildNest() {
		this.hasHornetNest = true;
	}
	
	public boolean isOnThePath() {
		return this.onPath;
	}
	
	public Tile towardTheHive() {
		return this.nextFromHornet;
	}
	
	public Tile towardTheNest() {
		return this.nextFromBee;
	}
	
	public void createPath(Tile nextFromHornet, Tile nextFromBee) {
		this.nextFromBee = nextFromBee;
		this.nextFromHornet = nextFromHornet;
		this.onPath = true;
	}
	
	public int collectFood() {
		foodCollected = this.foodPresent;
		this.foodPresent = 0;
		return foodCollected;
	}
	
	public void storeFood(int foodAdded) {
		this.foodPresent += foodAdded;
	}
	
	public HoneyBee getBee() {
		return this.beeOnTile;
	}
	
	public Hornet getHornet() {
		return this.hornetsOnTile.getFirstHornet();
	}
	
	public int getNumOfHornets() {
		return this.hornetsOnTile.sizeOfSwarm();
	}
	
	public boolean addInsect(Insect i) {
		boolean result = false;
		if ((!isNest() && getBee() == null) && i instanceof HoneyBee) {
			this.beeOnTile = (HoneyBee) i;
			i.setPosition(this);
			result = true;
		}
		if (i instanceof Hornet && (hasBeeHive == true || onPath == true || hasHornetNest == true)) {
			this.hornetsOnTile.addHornet((Hornet) i);
			i.setPosition(this);
			result = true;
		}
		return result;
	}
	
	public boolean removeInsect(Insect i) {
		if (i instanceof HoneyBee) {
			this.beeOnTile = null;
			i.setPosition(null);
			return true;
		}
		else if (i instanceof Hornet) {
			this.hornetsOnTile = null;
			i.setPosition(null);
			return true;
		} else {
			return false;
		}
	}
}
