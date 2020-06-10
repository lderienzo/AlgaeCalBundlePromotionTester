package abpt.bundlepromopage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abpt.framework.core.BasePage;

public class BundlePromotionPage extends BasePage {

    public BundlePromotionPage(WebDriver driver) {
        super(driver);
    }

    // dd functionality to open bundle promo page, and select and add bundles to the cart
    public void addThreeMonthSupplyBundleToCart() {
        addBundleToCart("3_month");
    }

    private void addBundleToCart(String bundleToAdd) {
        waitForElementToAppear(By.cssSelector("map"));
        WebElement bundleImageMap = driver.findElement(By.cssSelector("map"));
        waitForElementToAppear(By.id(bundleToAdd));
        WebElement area = bundleImageMap.findElement(By.id(bundleToAdd));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", area);
    }

    public void addSixMonthSupplyBundleToCart() {
        addBundleToCart("6_month");
    }

    public void addTwelveMonthSupplyBundleToCart() {
        addBundleToCart("12_month");
    }

    public void goBackToPromotionPageFromShoppingCartPage() {
        WebElement backButton = driver.findElement(By.id("back"));
        backButton.click();
    }

}
