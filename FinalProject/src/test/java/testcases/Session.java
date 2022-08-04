package testcases;

import org.testng.annotations.Test;

import testbase.BaseTest;

public class Session extends BaseTest
{
  @Test
  public void doLogin() 
  {
	  System.out.println("doLogin");
  }
  
  @Test
  public void doLogout() 
  {
	  System.out.println("doLogout");
  }
}
