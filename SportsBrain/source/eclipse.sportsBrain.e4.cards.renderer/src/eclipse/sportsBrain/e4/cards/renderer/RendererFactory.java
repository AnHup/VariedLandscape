package eclipse.sportsBrain.e4.cards.renderer;

import org.eclipse.e4.ui.internal.workbench.swt.AbstractPartRenderer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.workbench.renderers.swt.WorkbenchRendererFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RendererFactory extends WorkbenchRendererFactory {
	
	private static Logger logger = LoggerFactory.getLogger(RendererFactory.class);
	@Override
	public AbstractPartRenderer getRenderer(MUIElement uiElement, Object parent) {
		logger.debug("Rendering UI model element: " + uiElement.getClass());
		return super.getRenderer(uiElement, parent);
	}
}
