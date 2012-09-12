package test.diagram;

import java.awt.Image;

import javax.vecmath.Point2d;

import org.junit.Test;

import awt.BasicAWTPainter;

import test.BasePaintingTest;
import diagram.DiagramTransformer;
import diagram.element.CircleElement;
import diagram.element.ElementList;
import diagram.element.IDiagramElement;

public class DiagramTransformerTest extends BasePaintingTest {
	
	@Test
	public void testCirclePairScale() {
		Image img = getBlankTestImage();
		IDiagramElement root = new ElementList();
		root.add(new CircleElement(new Point2d(10, 10), 4));
		root.add(new CircleElement(new Point2d(20, 10), 4));
		DiagramTransformer.scaleToFit(root, getCanvas());
		BasicAWTPainter painter = new BasicAWTPainter(img.getGraphics(), false);
		painter.paint(root, getCanvas());
		writeImage(img, "circleScale");
	}

}
