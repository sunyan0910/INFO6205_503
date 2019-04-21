package Component;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GenericAlgorithmTest {

	@Test
	public void mutationTest() {
		GenericAlgorithm ga = new GenericAlgorithm(2,1,1,2);
		Population population = new Population(2);
		Population newPopulation  = ga.mutatePopulation(population);
		assertEquals(true,population.checkEquality(newPopulation));
	}
	
	@Test
	public void crossoverTest() {
		GenericAlgorithm ga = new GenericAlgorithm(2,1,1,2);
		Population population = new Population(2);
		Population newPopulation  = ga.crossoverPopulation(population);
		assertEquals(false,population.checkEquality(newPopulation));
	}
	
	@Test
	public void selectTest() {
		GenericAlgorithm ga = new GenericAlgorithm(2,1,1,2);
		Population population = new Population(2);
		assertEquals(false,population.getIndividule(0).checkEquality(ga.selectParent(population)));
	}
}
