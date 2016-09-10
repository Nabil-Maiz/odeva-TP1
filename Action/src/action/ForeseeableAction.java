package action;

/**
 * 
 * @author agez, maiz
 *
 */
public class ForeseeableAction extends Action {
	
	// ATTRIBUTES
	private final int totalTime;
	private int remainTime;
	private String description;
	
	// CONSTRUCTOR
	public ForeseeableAction(int time) {
		this.totalTime = time;
		this.remainTime = time;
	}
	
	public ForeseeableAction(int time, String description) {
		this.totalTime = time;
		this.remainTime = time;
		this.description = description;
	}

	@Override
	protected void reallyDoStep() {
		this.remainTime--;
		System.out.println(" " + description + " (" + (totalTime - remainTime) + "/" + totalTime + ")");
	}

	@Override
	/**
	 * @see Action#isReady()
	 */
	public boolean isReady() {
		return (this.totalTime == this.remainTime);
	}

	@Override
	/**
	 * @see Action#isFinished()
	 */
	public boolean isFinished() {
		return (this.remainTime == 0); 
	}
	
	/**
	 * @return The remaining time of the action
	 */
	public int getRemainTime() {
		return this.remainTime;
	}
	
	/**
	 * @return The total number of step of the action
	 */
	public int getTotalTime() {
		return this.totalTime;
	}
}
