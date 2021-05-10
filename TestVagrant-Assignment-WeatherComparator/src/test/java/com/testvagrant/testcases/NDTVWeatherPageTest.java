package com.testvagrant.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import com.testvagrant.drivermanager.DriverFactory;
import com.testvagrant.model.WeatherModel;
import com.testvagrant.pages.BasePage;
import com.testvagrant.utils.PropertyReader;

public class NDTVWeatherPageTest {

	private BasePage basepage;
	private PropertyReader property = new PropertyReader();
	static HashMap<String, WeatherModel> weatherUiObj = new HashMap<String, WeatherModel>();

	@BeforeMethod
	public void createDriver() {
		basepage = new BasePage(DriverFactory.getBrowser(System.getProperty("browser")).getDriver());
		property.readPropertiesFile("src/test/resources/config.properties");
	}

	@DataProvider(name = "Cities")
	public Object[] cityNamesProvider() {
		return new Object[] { "Ahmedabad", "Mumbai", "Chennai" };
	}
	
	
	@Test(dataProvider = "Cities")
	public void checkWeatherElementsAreDisplayedForSelectedCity(String city) {
		Boolean result = basepage.goToNDTVHomePage(property.getProperty("url")).goToWeatherPage().unSelectAllCities()
				.selectACityInCheckBox(city).clickOnACityInMap(city).checkWeatherElementsAreDisplayed();

		assertTrue(result);
	}

	@Test(dataProvider = "Cities")
	public void validateWeatherDetailsDisplayedForSelectedCity(String city) {
		WeatherModel weatherObj = basepage.goToNDTVHomePage(property.getProperty("url")).goToWeatherPage().unSelectAllCities()
				.selectACityInCheckBox(city).clickOnACityInMap(city).getTempDetailsAsWeatherObject();
		
		weatherUiObj.put(city, weatherObj);

		assertThat(weatherObj).isNotNull().matches(element -> element.getHumidity().floatValue() >= 0
				&& element.getTempInDegrees().floatValue() >= 0 && element.getTempInFahrenheit().floatValue() >= 0);
	} 
	
	@Test
	public static HashMap<String, WeatherModel> uiObjects() {
		return weatherUiObj;
	}
	
	@AfterMethod
	public void driverQuit() {
		basepage.tearDown();
	}
}
