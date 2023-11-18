package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase{

    String productName="Apple MacBook Pro 13-inch";
    ProductDetailsPage detailsObject;
    SearchPage searchObject ;


    @Test
    public void UserCanSearchForProduct(){
        searchObject = new SearchPage(driver);
        searchObject.productSearch(productName);
        searchObject.openProductDetailsPage();
        detailsObject=new ProductDetailsPage(driver);
        Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));

    }



}
