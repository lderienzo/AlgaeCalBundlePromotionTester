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
        emptyCartOptional.ifPresent(WebElement::click);
    }

    public int getNumberOfThreeMonthBundlesInCart() {
        return Integer.parseInt(getQuantityOfCartItemForMonthSupply("3"));
    }

    private String getQuantityOfCartItemForMonthSupply(String monthSupply) {
        Optional<WebElement> monthSupplyOptional = findElementById(monthSupply);
        if (monthSupplyOptional.isPresent())
            return monthSupplyOptional.get().getText();
        else
            return "0";
    }

    public int getNumberOfSixMonthBundlesInCart() {
        return Integer.parseInt(getQuantityOfCartItemForMonthSupply("6"));
    }

    public int getNumberOfTwelveMonthBundlesInCart() {
        return Integer.parseInt(getQuantityOfCartItemForMonthSupply("12"));
    }

    public int getCartTotal() {
        waitForElementToAppear(By.id(TOTAL_TD_ID));
        Optional<WebElement> tdContainingQuantityOptional = findElementById(TOTAL_TD_ID);
        return tdContainingQuantityOptional.map(webElement -> Integer.parseInt(webElement.getText())).orElse(0);
    }
}
