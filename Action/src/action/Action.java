package action;


/**
 * @author agez, maiz
 */
public abstract class Action {
	
	
	// METHODS
	/**
	 * Realize a step of the action
	 * @throws ActionFinishedException
	 */
	public void doStep() throws ActionFinishedException {
		if (this.isFinished()) throw new ActionFinishedException();
		reallyDoStep();
	}
	
	/**
	 * Realize a step of the Action 
	 */
	protected abstract void reallyDoStep() ;
	
	/**
	 * @return true if the Action is ready
	 */
	public abstract boolean isReady();
	
	/**
	 * @return true if the Action is in progress
	 */
	public boolean isInProgress() {
		return (!isFinished() && !isReady());
	}
	
	/**
	 * @return true only if the action is finished
	 */
	public abstract boolean isFinished();
}