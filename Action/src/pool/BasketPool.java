package pool;

/**
 * 
 * @author agez, maiz
 */
public class BasketPool extends ResourcePool<Basket> {

	// CONSTRUCTOR
	/**
	 * @see ResourcePool#ResourcePool(int nbResource)
	 */
	public BasketPool(int nbResource) {
		super(nbResource);
	}
	
	@Override
	/**
	 * @return A new Basket
	 */
	public Basket createResource() {
		return new Basket();
	}
	
	public String toString() {
		return "basket";
	}
}
