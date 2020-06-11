package abpt.tests.pages;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

import abpt.pages.BundlePromotionPage;
import abpt.framework.core.BaseTest;
import abpt.pages.ShoppingCartPage;

public class BundlePromotionPagesTests extends BaseTest {
    private BundlePromotionPage bundlePromotionPage;
    private ShoppingCartPage shoppingCartPage;
    private int expectedQuantity;
    private int expectedTotal;


    @Test
    public void whenNoBundlesAddedToCartThenCartContainsNoItemsAndTotalIs_0() {
        // given/when
        int expectedQuantity = 0;
        int expectedTotal = 0;
        shoppingCartPage = new ShoppingCartPage(getDriver());
        // then
        int quantityOfThreeMonthSupply = shoppingCartPage.getNumberOfThreeMonthBundlesInCart();
        assertEquals(expectedQuantity, quantityOfThreeMonthSupply);
        int quantityOfSixMonthSupply = shoppingCartPage.getNumberOfSixMonthBundlesInCart();
        assertEquals(expectedQuantity, quantityOfSixMonthSupply);
        int quantityOfTwelveMonthSupply = shoppingCartPage.getNumberOfTwelveMonthBundlesInCart();
        assertEquals(expectedQuantity, quantityOfTwelveMonthSupply);
        assertExpectedTotalPresent(expectedTotal);
    }

    private void assertExpectedTotalPresent(int expectedTotal) {
        int actualTotal = shoppingCartPage.getCartTotal();
        assertEquals(expectedTotal, actualTotal);
    }

    @Test
    public void when_3_MonthBundleAddedToCart_thenCartContainsOneItemAndTotalIs_244() {
        // given
        setUpCartPageWithExpectedQuantityAndTotal(1, 244);
        // when
        bundlePromotionPage.addThreeMonthSupplyBundleToCart();
        shoppingCartPage = new ShoppingCartPage(getDriver());
        // then
        int actualQuantityOfThreeMonthSupply = shoppingCartPage.getNumberOfThreeMonthBundlesInCart();
        assertEquals(expectedQuantity, actualQuantityOfThreeMonthSupply);
        assertExpectedTotalPresent(expectedTotal);
        // cleanup
        shoppingCartPage.emptyCart();
    }

    private void setUpCartPageWithExpectedQuantityAndTotal(int quantity, int total) {
        expectedQuantity = quantity;
        expectedTotal = total;
        bundlePromotionPage = new BundlePromotionPage(getDriver());
    }

    @Test
    public void when_6_MonthBundleAddedToCart_thenCartContainsOneItemAndTotalIs_396() {
        // given
        setUpCartPageWithExpectedQuantityAndTotal(1, 396);
        // when
        bundlePromotionPage.addSixMonthSupplyBundleToCart();
        shoppingCartPage = new ShoppingCartPage(getDriver());
        // then
        int quantityOfSixMonthSupply = shoppingCartPage.getNumberOfSixMonthBundlesInCart();
        assertEquals(expectedQuantity, quantityOfSixMonthSupply);
        assertExpectedTotalPresent(expectedTotal);
        // cleanup
        shoppingCartPage.emptyCart();
    }

    @Test
    public void when_12_MonthBundleAddedToCart_thenCartContainsOneItemAndTotalIs_768() {
        // given
        setUpCartPageWithExpectedQuantityAndTotal(1, 768);
        // when
        bundlePromotionPage.addTwelveMonthSupplyBundleToCart();
        shoppingCartPage = new ShoppingCartPage(getDriver());
        // then
        int quantityOfTwelveMonthSupply = shoppingCartPage.getNumberOfTwelveMonthBundlesInCart();
        assertEquals(expectedQuantity, quantityOfTwelveMonthSupply);
        assertExpectedTotalPresent(expectedTotal);
        // cleanup
        shoppingCartPage.emptyCart();
    }

    @Test
    public void whenTwo_3_MonthBundlesAddedToCart_thenCartContainsTwoItemsAndTotalIs_488() {
        // given
        setUpCartPageWithExpectedQuantityAndTotal(2, 488);
        // when
        bundlePromotionPage.addThreeMonthSupplyBundleToCart();
        bundlePromotionPage.goBackToPromotionPageFromShoppingCartPage();
        bundlePromotionPage.addThreeMonthSupplyBundleToCart();
        shoppingCartPage = new ShoppingCartPage(getDriver());
        // then
        int quantityOfThreeMonthSupply = shoppingCartPage.getNumberOfThreeMonthBundlesInCart();
        assertEquals(expectedQuantity, quantityOfThreeMonthSupply);
        assertExpectedTotalPresent(expectedTotal);
        // cleanup
        shoppingCartPage.emptyCart();
    }

    @Test
    public void whenTwo_6_MonthBundlesAddedToCart_thenCartContainsTwoItemsAndTotalIs_792() {
        // given
        setUpCartPageWithExpectedQuantityAndTotal(2, 792);
        // when
        bundlePromotionPage.addSixMonthSupplyBundleToCart();
        bundlePromotionPage.goBackToPromotionPageFromShoppingCartPage();
        bundlePromotionPage.addSixMonthSupplyBundleToCart();
        shoppingCartPage = new ShoppingCartPage(getDriver());
        // then
        int quantityOfSixMonthSupply = shoppingCartPage.getNumberOfSixMonthBundlesInCart();
        assertEquals(expectedQuantity, quantityOfSixMonthSupply);
        assertExpectedTotalPresent(expectedTotal);
        // cleanup
        shoppingCartPage.emptyCart();
    }

    @Test
    public void whenTwo_12_MonthBundlesAddedToCart_thenCartContainsTwoItemsAndTotalIs_1536() {
        // given
        setUpCartPageWithExpectedQuantityAndTotal(2, 1536);
        // when
        bundlePromotionPage.addTwelveMonthSupplyBundleToCart();
        bundlePromotionPage.goBackToPromotionPageFromShoppingCartPage();
        bundlePromotionPage.addTwelveMonthSupplyBundleToCart();
        shoppingCartPage = new ShoppingCartPage(getDriver());
        // then
        int quantityOfTwelveMonthSupply = shoppingCartPage.getNumberOfTwelveMonthBundlesInCart();
        assertEquals(expectedQuantity, quantityOfTwelveMonthSupply);
        assertExpectedTotalPresent(expectedTotal);
        // cleanup
        shoppingCartPage.emptyCart();
    }

    @Test
    public void when_3_MonthAnd_6_MonthBundleAddedToCart_thenCartContainsTwoItemsAndTotalIs_640() {
        // given
        setUpCartPageWithExpectedQuantityAndTotal(2, 640);
        // when
        bundlePromotionPage.addThreeMonthSupplyBundleToCart();
        bundlePromotionPage.goBackToPromotionPageFromShoppingCartPage();
        bundlePromotionPage.addSixMonthSupplyBundleToCart();
        shoppingCartPage = new ShoppingCartPage(getDriver());
        // then
        int quantityOfThreeMonthSupply = shoppingCartPage.getNumberOfThreeMonthBundlesInCart();
        int quantityOfSixMonthSupply = shoppingCartPage.getNumberOfSixMonthBundlesInCart();
        int actualQuantity = quantityOfThreeMonthSupply + quantityOfSixMonthSupply;
        assertEquals(expectedQuantity, actualQuantity);
        assertExpectedTotalPresent(expectedTotal);
        // cleanup
        shoppingCartPage.emptyCart();
    }

    @Test
    public void when_3_MonthAnd_12_MonthBundleAddedToCart_thenCartContainsTwoItemsAndTotalIs_1012() {
        // given
        setUpCartPageWithExpectedQuantityAndTotal(2, 1012);
        // when
        bundlePromotionPage.addThreeMonthSupplyBundleToCart();
        bundlePromotionPage.goBackToPromotionPageFromShoppingCartPage();
        bundlePromotionPage.addTwelveMonthSupplyBundleToCart();
        shoppingCartPage = new ShoppingCartPage(getDriver());
        // then
        int quantityOfThreeMonthSupply = shoppingCartPage.getNumberOfThreeMonthBundlesInCart();
        int quantityOfTwelveMonthSupply = shoppingCartPage.getNumberOfTwelveMonthBundlesInCart();
        int actualQuantity = quantityOfThreeMonthSupply + quantityOfTwelveMonthSupply;
        assertEquals(expectedQuantity, actualQuantity);
        assertExpectedTotalPresent(expectedTotal);
        // cleanup
        shoppingCartPage.emptyCart();
    }

    @Test
    public void when_6_MonthAnd_12_MonthBundleAddedToCart_thenCartContainsTwoItemsAndTotalIs_1164() {
        // given
        setUpCartPageWithExpectedQuantityAndTotal(2, 1164);
        // when
        bundlePromotionPage.addSixMonthSupplyBundleToCart();
        bundlePromotionPage.goBackToPromotionPageFromShoppingCartPage();
        bundlePromotionPage.addTwelveMonthSupplyBundleToCart();
        shoppingCartPage = new ShoppingCartPage(getDriver());
        // then
        int quantityOfSixMonthSupply = shoppingCartPage.getNumberOfSixMonthBundlesInCart();
        int quantityOfTwelveMonthSupply = shoppingCartPage.getNumberOfTwelveMonthBundlesInCart();
        int actualQuantity = quantityOfSixMonthSupply + quantityOfTwelveMonthSupply;
        assertEquals(expectedQuantity, actualQuantity);
        assertExpectedTotalPresent(expectedTotal);
        // cleanup
        shoppingCartPage.emptyCart();
    }

    @Test
    public void whenOneOfEachBundleTypeAreAddedToCart_thenCartContainsThreeItemsAndTotalIs_1408() {
        // given
        setUpCartPageWithExpectedQuantityAndTotal(3, 1408);
        // when
        bundlePromotionPage.addThreeMonthSupplyBundleToCart();
        bundlePromotionPage.goBackToPromotionPageFromShoppingCartPage();
        bundlePromotionPage.addSixMonthSupplyBundleToCart();
        bundlePromotionPage.goBackToPromotionPageFromShoppingCartPage();
        bundlePromotionPage.addTwelveMonthSupplyBundleToCart();
        shoppingCartPage = new ShoppingCartPage(getDriver());
        // then
        int quantityOfThreeMonthSupply = shoppingCartPage.getNumberOfThreeMonthBundlesInCart();
        int quantityOfSixMonthSupply = shoppingCartPage.getNumberOfSixMonthBundlesInCart();
        int quantityOfTwelveMonthSupply = shoppingCartPage.getNumberOfTwelveMonthBundlesInCart();
        int actualQuantity = quantityOfThreeMonthSupply + quantityOfSixMonthSupply + quantityOfTwelveMonthSupply;
        assertEquals(expectedQuantity, actualQuantity);
        assertExpectedTotalPresent(expectedTotal);
        // cleanup
        shoppingCartPage.emptyCart();
    }
}
