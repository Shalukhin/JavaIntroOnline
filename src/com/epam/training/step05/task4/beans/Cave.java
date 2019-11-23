package step05.task4.beans;

import java.util.Arrays;

public class Cave {
	
	int capasityCave;	
	Treasure[] treasures;
	
	public class Treasure {
		
		String name;
		long price;
		
		public Treasure(String name, long price) {
			super();
			this.name = name;
			this.price = price;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public long getPrice() {
			return price;
		}
		
		public void setPrice(long price) {
			this.price = price;
		}
		
				
		@Override
		public String toString() {
			return "Treasure [name=" + name + ", price=" + price + "]";
		}	
		
	}

		
	public Cave() {
		super();
		this.capasityCave = 1;
		treasures = new Treasure[capasityCave];
	}
	
	public Cave(int capasityCave) {
		super();
		this.capasityCave = capasityCave;
		treasures = new Treasure[capasityCave];
	}

	public int getCapasityCave() {
		return capasityCave;
	}

	public void setCapasityCave(int capasityCave) {
		this.capasityCave = capasityCave;
	}

	public Treasure[] getTreasuries() {
		return treasures;
	}

	public void setTreasuries(Treasure[] treasuries) {
		this.treasures = treasuries;
	}
	
	public void setTreasuries(Treasure treasurie, int index) {
		if (index >= treasures.length) {
			treasures = Arrays.copyOf(treasures, treasures.length + 1);
			treasures[treasures.length - 1] = treasurie;
			return;
		}
		treasures[index] = treasurie;
	}

	@Override
	public String toString() {
		return "Cave [capasityCave=" + capasityCave + ", treasures=" + Arrays.toString(treasures) + "]";
	}
	

}
