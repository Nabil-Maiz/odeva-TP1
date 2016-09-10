package action.test;
import java.util.*;
import action.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class SequentialSchedulerTest {
	
	@Test
	public void testStateOfScheduler() {
		List<Action> list = new ArrayList<Action>();
		list.add(new ForeseeableAction(2));
		list.add(new ForeseeableAction(1));
		
		
		
		SequentialScheduler schedul = new SequentialScheduler(list);
		assertTrue(schedul.isReady());
		assertFalse(schedul.isInProgress());
		assertFalse(schedul.isFinished());
		try {
			for (int i = 0; i < 2; i++) {
				schedul.doStep();
				assertFalse(schedul.isReady());
				assertTrue(schedul.isInProgress());
				assertFalse(schedul.isFinished());
			}
			schedul.doStep();
		}
		catch(ActionFinishedException e) {
			fail ("Action finished");
		}
		assertFalse(schedul.isReady());
		assertFalse(schedul.isInProgress());
		assertTrue(schedul.isFinished());
	}


}
