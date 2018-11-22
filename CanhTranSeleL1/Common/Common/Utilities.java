package Common;

import org.testng.Assert;
import static org.apache.commons.lang3.RandomStringUtils.*;


public class Utilities {
	public static void checkTextDisplays( String actualText, String expectedText )
	{
		Assert.assertEquals(actualText, expectedText, "The text should be: " + expectedText);
	}

	public static String randomEmail() 
	{
        return "canh.tran+" + randomAlphabetic(5).toLowerCase() + "@logigear.com";
    }
}
