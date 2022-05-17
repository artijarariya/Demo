package test;

import org.testng.annotations.Test;

import keywordEngine.KeywordEngine;

public class LoginTest {
public KeywordEngine keyWordEngine;
	
	@Test
	public void loginTest()
	{
	keyWordEngine = new KeywordEngine();
	keyWordEngine.startExecution("login");
	}
}


