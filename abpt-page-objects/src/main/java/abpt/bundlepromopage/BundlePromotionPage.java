package abpt.bundlepromopage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abpt.framework.core.BasePage;

public class BundlePromotionPage extends BasePage {
    private static final String EMPTY_CART_ID = "empty_cart";

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
        WebElement backButton = findElementById("back");
        backButton.click();
    }

    private WebElement findElementById(String id) {
        return driver.findElement(By.id(id));
    }

    public void emptyShoppingCart() {
        waitForElementToAppear(By.id(EMPTY_CART_ID));
        WebElement emptyCart = findElementById(EMPTY_CART_ID);
        emptyCart.click();
    }

    public void pauseForSeconds(int secondsToPause) {
        driver.manage().timeouts().implicitlyWait(secondsToPause, TimeUnit.SECONDS);
    }

    public int getNumberOfThreeMonthBundlesInCart() {
        return Integer.valueOf(getQuantityOfCartItem("3"));
    }

    private String getQuantityOfCartItem(String monthSupply) {
        WebElement tdContainingQuantity = findElementById(monthSupply);
        return tdContainingQuantity.getText();
    }

    public int getNumberOfSixMonthBundlesInCart() {
        return Integer.valueOf(getQuantityOfCartItem("6"));
    }

    public int getNumberOfTwelveMonthBundlesInCart() {
        return Integer.valueOf(getQuantityOfCartItem("12"));
    }

    public int getCartTotal() {
        WebElement tdContainingQuantity = findElementById("total");
        return Integer.parseInt(tdContainingQuantity.getText());
    }

}
