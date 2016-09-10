package pool;

public class CubiclePool extends ResourcePool<Cubicle> {

	// CONSTRUCTOR
	
	public CubiclePool(int nbResource) {
		super(nbResource);
	}
	
	@Override
	public Cubicle createResource() {
		return new Cubicle();
	}
	
	public String toString() {
		return "cubicle";
	}
	

}
