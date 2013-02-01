/*package registerOffice;      //zlicza ilosc zamowien i klientow

public final class Context {

	private int quantityOfCars;
	private int quantityOfPeople;
	
	private Context() {
	}

	private static Context instance;

	public static Context getInstance() {
		
		if (instance == null)
			synchronized (Context.class) {
				if (instance == null)
					instance = new Context();
			}
		return instance;
	}
	
	public void reduceFilms()
	{
		this.quantityOfCars--;
	}
	
	public void reducePeople()
	{
		this.quantityOfPeople--;
	}
	public void raiseNumberOfCars()
	{
		this.quantityOfCars++;
	}

	public void raisenumberOfPeople()
	{
		this.quantityOfPeople++;
	}
	
	public int getQuantityOfPeople()
	{
		return this.quantityOfPeople;
	}
	public int getQuantity()
	{
		return this.quantityOfCars;
	}
}
*/