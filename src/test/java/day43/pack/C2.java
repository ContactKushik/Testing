package day43.pack;

import org.testng.annotations.*;

public class C2 {
    @BeforeSuite
    void bs()
    {
        System.out.println("This is BeforeSuite method..");
    }

    @AfterSuite
    void as()
    {
        System.out.println("This is AfterSuite method..");
    }


	@Test
	void xyz()
	{
		System.out.println(" this is xyz from C2..");
	}
	

	@AfterTest
	void at()
	{
		System.out.println("this is AfterTest method....");
	}

    @BeforeTest
    void bt()
    {
        System.out.println("this is BeforeTest method....");
    }
}
