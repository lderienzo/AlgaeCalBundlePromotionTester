package abpt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import abpt.framework.core.BasePage;

public class BundlePromotionPage extends BasePage {
    private static final String BUNDLE_PROMO_PAGE_URL = "http://localhost:8000/";
    private static final String VIEW_CART_BUTTON_ID = "view_cart";

    public BundlePromotionPage(WebDriver driver) {
        super(driver);
        loadPage(BUNDLE_PROMO_PAGE_URL);
    }

    public void addThreeMonthSupplyBundleToCart() {
        addBundleToCart("3_month");
    }

    private void addBundleToCart(String bundleToAdd) {
        waitForElementToAppearAndBeClickable(By.tagName("map"));
        WebElement bundleImageMap = driver.findElement(By.tagName("map"));
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
        driver.navigate().back();
    }
}
