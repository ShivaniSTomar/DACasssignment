package core;

public enum Plan {
SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(10000);
	
	private int planCost;
	
	private Plan(int planCost)
	{
		this.planCost= planCost;
	}

	public int getPlanCost() {
		return planCost;
	}
	
}
