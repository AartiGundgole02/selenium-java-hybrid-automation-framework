package com.web.automation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IPLAutomation {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.iplt20.com/points-table/men");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		By locaterTable = By.className("ih-td-tab");
		WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(locaterTable));

		By tBodyLocator = By.id("pointsdata");

		WebElement tBody = table.findElement(tBodyLocator);

		By tableRowLocator = By.tagName("tr");
		List<WebElement> tableRowDataList = tBody.findElements(tableRowLocator);
		System.out.println(tableRowDataList.size());

		List<Team> teamList = new ArrayList<Team>();
		
		for (WebElement row : tableRowDataList) {
			By tableDataRowLocator = By.tagName("td");
			List<WebElement> tableDataList = row.findElements(tableDataRowLocator);
//			for (WebElement tableData : tableDataList) {
//				System.out.println(tableData.getText());
//			}
			double nrr = Double.parseDouble(tableDataList.get(7).getText());
			int pts = Integer.parseInt(tableDataList.get(10).getText());
			
			Team team = new Team(tableDataList.get(0).getText(),tableDataList.get(2).getText(),nrr,pts);
			teamList.add(team);
		}

		for(Team data:teamList) {
			System.out.println(data);
		}
	}

}
