package Common;

import org.testng.Assert;


public class Utilities {
	public static void checkTextDisplays( String actualText, String expectedText )
	{
		Assert.assertEquals(actualText, expectedText, "The text should be: " + expectedText);
	}

}
