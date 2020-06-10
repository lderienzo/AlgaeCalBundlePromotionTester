package abpt.tests.bundlepromopage;

import org.testng.annotations.Test;

import abpt.bundlepromopage.BundlePromotionPage;
import abpt.framework.core.BaseTest;

public class BundlePromotionPageTests extends BaseTest {
    private static final String BUNDLE_PROMO_PAGE_URL = "http://localhost:8000/";

    @Test
    public void loadBundlePromoPageTest() {
        BundlePromotionPage bundlePromotionPage = new BundlePromotionPage(getDriver());
        bundlePromotionPage.loadPage(BUNDLE_PROMO_PAGE_URL);

        bundlePromotionPage.addThreeMonthSupplyBundleToCart();
        bundlePromotionPage.goBackToPromotionPageFromShoppingCartPage();

        bundlePromotionPage.addSixMonthSupplyBundleToCart();
        bundlePromotionPage.goBackToPromotionPageFromShoppingCartPage();

        bundlePromotionPage.addTwelveMonthSupplyBundleToCart();
    }
}
