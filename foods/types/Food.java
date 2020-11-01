package foods.types;

public class Food {
	private int foodId;
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	
	@Override
	public String toString() {
		return "foodId:[" + foodId + ", : " + name + "]";
	}
	
}
