package diagram;

import diagram.element.ElementList;
import diagram.element.IDiagramElement;

public class DiagramPrinter {

	public static void print(IDiagramElement element) {
		if (element instanceof ElementList) {
			ElementList list = (ElementList) element;
			System.out.println("[");
			for (IDiagramElement child : list) {
				print(child);
			}
			System.out.println("]");
		} else {
			String name = element.getClass().getName();
			System.out.println(name + " @ " + element.getCenter());
		}
	}
}
