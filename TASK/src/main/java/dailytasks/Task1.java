package dailytasks;



	import java.io.IOException;
	import java.net.HttpURLConnection;
	import java.net.URL;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Task1 {

		@Test
		public void broken() {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://poojastore.marolix.com/");
			List<WebElement> links1=driver.findElements(By.tagName("a"));
			for(WebElement link1:links1)
			{
				String url=link1.getAttribute("href");
				if(url!=null&&!url.isEmpty())
				{
				try {
					URL link2 = new URL(url);
					HttpURLConnection httpURLsConnection = (HttpURLConnection) link2.openConnection();
		
					httpURLsConnection.connect();
					int RScode=httpURLsConnection.getResponseCode();


					if (RScode >= 400) 
					{
					System.out.println(url + " - " +"broken link");
					System.out.println(httpURLsConnection.getResponseMessage());
					System.out.println("response code:"+RScode);
					}
					
				}
					
					catch (Exception e) {
						//e.printStackTrace();
					System.out.println(url + " - " + "it is a broken link");
						//System.out.println("exception");
					}
				}
				
			}
			
		}
	}
					
			

		




	


