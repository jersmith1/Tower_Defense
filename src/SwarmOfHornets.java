
public class SwarmOfHornets {
	
	//fields
	private Hornet[] swarm;
	private int swarmSize;
	
	//constructor
	public SwarmOfHornets() {
		this.swarm = new Hornet[0];
	}
	
	//get and set methods
	public int sizeOfSwarm() {
		return this.swarmSize;
	}
	
	public Hornet[] getHornets() {
		return this.swarm;
	}
	
	public Hornet getFirstHornet() {
		if(this.swarmSize == 0) {
			return null;
		} else {
			return this.swarm[0];
		}
	}
		
	public void addHornet(Hornet h) {
		this.swarm = this.getHornets();
		if (this.swarm == null) {
			this.swarm = new Hornet[0];
		}
		Hornet[] newArray = new Hornet[this.sizeOfSwarm() + 1];
		for (int i = 0; i < this.sizeOfSwarm(); i++) {
			newArray[i] = swarm[i];
		}
		newArray[newArray.length - 1] = h;
		this.swarm = newArray;
		this.swarmSize += 1;
	}
	
	public boolean removeHornet(Hornet h) {
		boolean result = false;
		this.swarm = this.getHornets();
		if (this.swarm == null) {
			result = false;
		}
		if (this.swarm.length != 0) {
			Hornet[] a = new Hornet[this.swarm.length - 1];
			for (int i = 0; i < this.sizeOfSwarm(); i++) {
				for (int x = 0; x < this.swarm.length; x++) {
					if (swarm[i] != h) {
						a[x] = this.swarm[x];
						this.swarm = a;
						this.swarmSize = this.swarmSize -1;
						result = true;
					}
				}
			}
		}
		return result;
	}

}
