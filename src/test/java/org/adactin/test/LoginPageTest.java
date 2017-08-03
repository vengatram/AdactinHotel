package org.adactin.test;


import org.adactin.page.HotelSearch;
import org.adactin.page.LoginPage;
import org.adactin.utility.Base;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginPageTest extends Base{
	static WebDriver driver;
	LoginPage login;
	HotelSearch next;
	@BeforeClass
	public static void launchBrowser() {
		driver=getDriver();

	}

	@Test
	public void averifyLogin() {
		login = new LoginPage(driver);
		getScreenShot("loginpage");
		setText(login.getTxtUserName(), readValueFromExcelSheet().get(1).get("Username"));
		setText(login.getTxtUserPassword(), readValueFromExcelSheet().get(1).get("Password"));
		login.getTxtUserPassword().sendKeys(Keys.ENTER);
		getScreenShot("username");
		elementToBeVisible(driver, 20, login.getBtnLoginButton());
		clickBtn(login.getBtnLoginButton());
		System.out.println("Success");

	}
	@Test
	public void bsearchHotel1() {
		next = new HotelSearch(driver);
		Assert.assertTrue(elementFound(driver, 10, next.getTxtLogout()));
		dropDownSelect(next.getDrpLocation(), "Sydney");
		dropDownSelect(next.getDrpHotel(), "Hotel Hervey");
		dropDownSelect(next.getDrpRoomType(), "Deluxe");
		dropDownSelect(next.getDrpRoom(), "3");
		setText(next.getTxtCheckinDate(), readValueFromExcelSheet().get(1).get("check in date"));
		setText(next.getTxtCheckOutDate(), readValueFromExcelSheet().get(1).get("check out date"));
		dropDownSelect(next.getDrpAdult(), "2");
		dropDownSelect(next.getDrpChild(), "2");
		getScreenShot("Hotelsearch");
		clickBtn(next.getBtnSearch());

	}
	

	@AfterClass
	public static void closeBrowser() {
		driver.quit();

	}

}
