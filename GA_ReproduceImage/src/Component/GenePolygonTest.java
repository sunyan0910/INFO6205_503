package Component;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GenePolygonTest {

	@Test
	public void testEquality() {
		GenePolygon gene = new GenePolygon();
		assertEquals(true,gene.checkEquality(gene));
		GenePolygon newOne = new GenePolygon();
		assertEquals(false,gene.checkEquality(newOne));
	}

}
