package shopaas.web;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

public class HomePage extends WebPage {

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    @SuppressWarnings({ "unchecked", "serial" })
	public HomePage(final PageParameters parameters) {
        add(new Label("message", "If you see this message wicket is properly configured and running"));
        add(new Link("ProductReport"){
			@Override
			public void onClick() {
				setResponsePage(new ProductReportPage(parameters));
			}
        });
    }
}
