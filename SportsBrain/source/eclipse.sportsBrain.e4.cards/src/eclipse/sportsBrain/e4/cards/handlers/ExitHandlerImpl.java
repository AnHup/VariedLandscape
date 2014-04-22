package eclipse.sportsBrain.e4.cards.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;

public class ExitHandlerImpl {
	@Execute
	public void execute(IWorkbench workbench) {
			workbench.close();
	}
}
