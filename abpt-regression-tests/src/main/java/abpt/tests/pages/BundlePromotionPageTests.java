package abpt.tests.pages;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import abpt.pages.BundlePromotionPage;
import abpt.framework.core.BaseTest;

public class BundlePromotionPageTests extends BaseTest {
    private static final String BUNDLE_PROMO_PAGE_URL = "http://localhost:8000/";
    private BundlePromotionPage bundlePromotionPage;


    @BeforeTest
    public void setUp() {
        bundlePromotionPage = new BundlePromotionPage(getDriver());
        bundlePromotionPage.loadPage(BUNDLE_PROMO_PAGE_URL);
    }

    public void clearDb() {
        bundlePromotionPage.emptyShoppingCart();
    }

    @Test
    public void testAddingOfThreeMonthBundle() {
        // given/when
        bundlePromotionPage.addThreeMonthSupplyBundleToCart();
        int quantityOfThreeMonthSupply = bundlePromotionPage.getNumberOfThreeMonthBundlesInCart();
        int orderTotal = bundlePromotionPage.getCartTotal();
        clearDb();
        // then
        assertEquals(quantityOfThreeMonthSupply, 1);
        assertEquals(orderTotal, 244);
    }

    @Test
    public void testAddingOfSixMonthBundle() {
        // given/when
        bundlePromotionPage.addSixMonthSupplyBundleToCart();
        int quantityOfSixMonthSupply = bundlePromotionPage.getNumberOfSixMonthBundlesInCart();
        int orderTotal = bundlePromotionPage.getCartTotal();
        clearDb();
        // then
        assertEquals(quantityOfSixMonthSupply, 1);
        assertEquals(orderTotal, 396);
    }

    @Test
    public void testAddingOfTwelveMonthBundle() {
        // given/when
        bundlePromotionPage.addTwelveMonthSupplyBundleToCart();
        int quantityOfTwelveMonthSupply = bundlePromotionPage.getNumberOfTwelveMonthBundlesInCart();
        int orderTotal = bundlePromotionPage.getCartTotal();
        clearDb();
        // then
        assertEquals(quantityOfTwelveMonthSupply, 1);
        assertEquals(orderTotal, 768);
    }


    @Test
    public void testAddingMultipleThreeMonthBundles() {
        // given/when
        bundlePromotionPage.addThreeMonthSupplyBundleToCart();
        bundlePromotionPage.goBackToPromotionPageFromShoppingCartPage();
        bundlePromotionPage.addThreeMonthSupplyBundleToCart();
        int quantityOfThreeMonthSupply = bundlePromotionPage.getNumberOfThreeMonthBundlesInCart();
        int orderTotal = bundlePromotionPage.getCartTotal();
        clearDb();
        // then
        assertEquals(quantityOfThreeMonthSupply, 2);
        assertEquals(orderTotal, 488);
    }


    @Test
    public void testAddingOneOfEachBundle() {
        // given
        bundlePromotionPage.addThreeMonthSupplyBundleToCart();
        bundlePromotionPage.pauseForSeconds(1);
        bundlePromotionPage.goBackToPromotionPageFromShoppingCartPage();
        bundlePromotionPage.pauseForSeconds(1);
        bundlePromotionPage.addSixMonthSupplyBundleToCart();
        bundlePromotionPage.pauseForSeconds(1);
        bundlePromotionPage.goBackToPromotionPageFromShoppingCartPage();
        bundlePromotionPage.pauseForSeconds(1);
        bundlePromotionPage.addTwelveMonthSupplyBundleToCart();
        bundlePromotionPage.pauseForSeconds(1);
        // when
        int quantityOfThreeMonthSupply = bundlePromotionPage.getNumberOfThreeMonthBundlesInCart();

        // then
        assertEquals(quantityOfThreeMonthSupply, 1);

        bundlePromotionPage.pauseForSeconds(1);
        clearDb();
    }
}
