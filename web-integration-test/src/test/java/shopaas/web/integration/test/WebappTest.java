package shopaas.web.integration.test;

import static org.junit.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebappTest {
	
	@Ignore
	@Test
	public void testCallIndexPage() throws Exception {
		URL url = new URL("http://localhost:8080/");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.connect();
		assertEquals(200, connection.getResponseCode());
	}
	
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new HtmlUnitDriver();
	}

	@Test
	public void testHomepage() {
		driver.get("http://localhost:8080/");
		assertEquals("Wicket Quickstart Archetype Homepage", driver.getTitle());
	}
	
}
