package search;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.ItemDetailsPage;
import pages.SearchResultPage;

import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTests {
    private WebDriver driver;
    @Test
    public void searchTest(){
       SearchResultPage searchResultPage = homePage.searchForItem("car accessories");
       String searchResultPageItemTitle = searchResultPage.getFirstItemTitle();
        System.out.println(searchResultPageItemTitle);
       ItemDetailsPage itemDetailsPage = searchResultPage.clickFirstItem();
       String detailsPageItemTitle = itemDetailsPage.getItemName();
        System.out.println(detailsPageItemTitle);
        assertTrue(detailsPageItemTitle.contains(searchResultPageItemTitle),"Mismatched Titles");
    }

}
