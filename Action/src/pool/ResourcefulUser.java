package pool;

/**
 * 
 * @author agez, maiz
 */
public class ResourcefulUser<R extends Resource> {
	
	// ATTRIBUTES
	protected R resource;
	
	// METHODS
	
	/**
	 * @return The resource
	 */
	public R getResource() {
		return resource;
	}
	
	/**
	 * @param resource The new resource
	 */
	public void setResource(R resource) {
		this.resource = resource;
	}
	
	/**
	 * Unset the resource
	 */
	public void resetResource() {
		this.resource = null;
	}
}
