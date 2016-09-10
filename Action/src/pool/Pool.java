package pool;
//import pool.*;
import action.*;
import java.util.*;

/**
 * 
 * @author agez, maiz
 *
 */
public class Pool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		
		List<Action> actions = new ArrayList<Action>();
		actions.add(new Swimmer("Camille",baskets,cubicles,6,4,8));
		actions.add(new Swimmer("Lois",baskets,cubicles,2,10,4));
		actions.add(new Swimmer("Maé",baskets,cubicles,10,18,10));
		actions.add(new Swimmer("Ange",baskets,cubicles,3,7,5));
		actions.add(new Swimmer("Louison",baskets,cubicles,18,3,3));
		actions.add(new Swimmer("Charlie",baskets,cubicles,3,6,10));
		actions.add(new Swimmer("Alexis",baskets,cubicles,6,5,7));

		FairScheduler s = new FairScheduler(actions);

		int nbSteps = 0;
		
		while(!s.isFinished()){
			nbSteps++;
			try{
				System.out.println(s.getCurrentAction() + "'s turn");
				System.out.print(s.getCurrentAction());
				s.doStep();
			} catch(ActionFinishedException e){
				System.out.println("Erreur doStep");
			}
	
		}
		System.out.println("Finished in " + nbSteps + " steps");
	}

}
