package eclipse.sportsBrain.e4.cards.login;

import org.eclipse.e4.core.contexts.IEclipseContext;
import eclipse.sportsBrain.e4.cards.login.internal.LoginDialog;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.internal.workbench.swt.E4Application;
import org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;

public class Login {
	@PostContextCreate
	public void login(IEclipseContext context) {
		final Shell shell = new Shell(SWT.INHERIT_NONE);
	    
		final LoginDialog dialog = new LoginDialog(shell);
		dialog.create();

		String cssTheme = "eclipse.sportsBrain.e4.cards.themes.login";
		context.set(E4Application.THEME_ID, cssTheme);
		String cssURI = "css/login2.css";
		context.set(E4Workbench.CSS_URI_ARG, cssURI);

		PartRenderingEngine.initializeStyling(shell.getDisplay(), context);

		if (dialog.open() != Window.OK) {
			// we don't have a workbench yet...
			System.exit(0);
		}
	}
}
