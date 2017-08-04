package org.adactin.test;


import org.adactin.page.HotelSearch;
import org.adactin.page.LoginPage;
import org.adactin.utility.Base;
import org.adactin.utility.JunitReport;
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
public class LoginPageTest extends JunitReport{
	static WebDriver driver;
	LoginPage login;
	HotelSearch next;
	static Base base;
	
	@BeforeClass
	public static void launchBrowser() {
	base=new Base();
		driver=base.getDriver();

	}

	@Test
	public void averifyLogin() {
		login = new LoginPage(driver);
		base.getScreenShot("loginpage");
		base.setText(login.getTxtUserName(),base. readValueFromExcelSheet().get(1).get("Username"));
		base.setText(login.getTxtUserPassword(),base. readValueFromExcelSheet().get(1).get("Password"));
		login.getTxtUserPassword().sendKeys(Keys.ENTER);
		base.getScreenShot("username");
		base.elementToBeVisible(driver, 20, login.getBtnLoginButton());
		base.clickBtn(login.getBtnLoginButton());
		System.out.println("Success");

	}
	@Test
	public void bsearchHotel1() {
		next = new HotelSearch(driver);
		Assert.assertTrue(base.elementFound(driver, 10, next.getTxtLogout()));
		base.dropDownSelect(next.getDrpLocation(), "Sydney");
		base.dropDownSelect(next.getDrpHotel(), "Hotel Hervey");
		base.dropDownSelect(next.getDrpRoomType(), "Deluxe");
		base.dropDownSelect(next.getDrpRoom(), "3");
		base.setText(next.getTxtCheckinDate(), base.readValueFromExcelSheet().get(1).get("check in date"));
		base.setText(next.getTxtCheckOutDate(),base. readValueFromExcelSheet().get(1).get("check out date"));
		base.dropDownSelect(next.getDrpAdult(), "2");
		base.dropDownSelect(next.getDrpChild(), "2");
		base.getScreenShot("Hotelsearch");
		base.clickBtn(next.getBtnSearch());

	}
	

	@AfterClass
	public static void closeBrowser() {
		driver.quit();

	}

}
