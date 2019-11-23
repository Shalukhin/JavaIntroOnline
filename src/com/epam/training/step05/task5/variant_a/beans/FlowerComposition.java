package step05.task5.variant_a.beans;

import java.util.Arrays;

import step05.task5.variant_a.beans.flowers.Flower;

public class FlowerComposition {
	
	private Flower[] flowers = new Flower[0];
	private Cover cover = null;

	public FlowerComposition() {
		super();
	}

	public FlowerComposition(Flower[] flowers) {
		super();
		this.flowers = flowers;
	}

	public Flower[] getFlowers() {
		return flowers;
	}

	public void setFlowers(Flower[] flowers) {
		this.flowers = flowers;
	}
	
	public void setFlowers(Flower flower, int index) {
		if (index >= flowers.length) {
			flowers = Arrays.copyOf(flowers, flowers.length + 1);
			flowers[flowers.length - 1] = flower;
			return;
		}
		flowers[index] = flower;
	}

	public Cover getCover() {
		return cover;
	}

	public void setCover(Cover cover) {
		this.cover = cover;
	}

	@Override
	public String toString() {
		return "FlowerComposition [flowers=" + Arrays.toString(flowers) + ", cover=" + cover + "]";
	}
		

}
