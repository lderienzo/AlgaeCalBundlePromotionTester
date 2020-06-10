package abpt.pages;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abpt.framework.core.BasePage;

public class ShoppingCartPage extends BasePage {
    private static final String SHOPPING_CART_PAGE_URL = "http://localhost:8000/shopping_cart";
    private static final String EMPTY_CART_BUTTON_ID = "empty_cart";
    private static final String TOTAL_TD_ID = "total";

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        loadPage(SHOPPING_CART_PAGE_URL);
    }

    public void emptyCart() {
        waitForElementToAppearAndBeClickable(By.id(EMPTY_CART_BUTTON_ID));
        Optional<WebElement> emptyCartOptional = findElementById(EMPTY_CART_BUTTON_ID);
        if (emptyCartOptional.isPresent())
            emptyCartOptional.get().click();
    }

    public int getNumberOfThreeMonthBundlesInCart() {
        return Integer.valueOf(getQuantityOfCartItemForMonthSupply("3"));
    }

    private String getQuantityOfCartItemForMonthSupply(String monthSupply) {
        Optional<WebElement> monthSupplyOptional = findElementById(monthSupply);
        if (monthSupplyOptional.isPresent())
            return monthSupplyOptional.get().getText();
        else
            return "0";
    }

    public int getNumberOfSixMonthBundlesInCart() {
        return Integer.valueOf(getQuantityOfCartItemForMonthSupply("6"));
    }

    public int getNumberOfTwelveMonthBundlesInCart() {
        return Integer.valueOf(getQuantityOfCartItemForMonthSupply("12"));
    }

    public int getCartTotal() {
        waitForElementToAppear(By.id(TOTAL_TD_ID));
        Optional<WebElement> tdContainingQuantityOptional = findElementById(TOTAL_TD_ID);
        if (tdContainingQuantityOptional.isPresent())
            return Integer.parseInt(tdContainingQuantityOptional.get().getText());
        else
            return 0;
    }
}
