package pool;

import action.*;

import java.util.*;

public class Swimmer extends Action {

	// ATTRIBUTE
	protected final String name;
	protected final SequentialScheduler process;
	protected final ResourcefulUser<Basket> basketUser;
	protected final ResourcefulUser<Cubicle> cubicleUser;
	
	
	// CONSTRUCTOR

	public Swimmer(String name, BasketPool basket, CubiclePool cubicle, int timeToUndress, int timeToSwimm, int timeToDress) {
		this.name = name;
		basketUser = new ResourcefulUser<Basket>();
		cubicleUser = new ResourcefulUser<Cubicle>();
		List<Action> actions = createProcess(basket, cubicle, timeToUndress, timeToSwimm, timeToDress);
		process = new SequentialScheduler(actions);
	}
	
	private List<Action> createProcess (BasketPool basket, CubiclePool cubicle, int timeToUndress, int timeToSwimm, int timeToDress) {
		List<Action> actions = new ArrayList<Action>();
		actions.add(new TakeResourceAction<Basket>(basket, basketUser));
		actions.add(new TakeResourceAction<Cubicle>(cubicle, cubicleUser));
		actions.add(new ForeseeableAction(timeToUndress, "Undressing"));
		actions.add(new FreeResourceAction<Cubicle>(cubicle, cubicleUser));
		actions.add(new ForeseeableAction(timeToSwimm, "Swimming"));
		actions.add(new TakeResourceAction<Cubicle>(cubicle, cubicleUser));
		actions.add(new ForeseeableAction(timeToDress, "Dressing"));
		actions.add(new FreeResourceAction<Cubicle>(cubicle, cubicleUser));
		actions.add(new FreeResourceAction<Basket>(basket, basketUser));
		return actions;
	}

	
	// METHODS

	@Override
	protected void reallyDoStep() {
		try {
			process.doStep();
		}
		catch (ActionFinishedException e) {
			System.out.println("Error : Swimmer.reallyDoStep()");
		}
	}

	@Override
	public boolean isReady() {
		return process.isReady();
	}

	@Override
	public boolean isFinished() {
		return process.isFinished();
	}
	
	public String toString() {
		return name;
	}

}
