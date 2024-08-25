package steps;

import base.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.ItemPage;
import pages.SearchResultPage;

import static org.testng.Assert.assertTrue;

public class SearchSteps extends BaseTests  {

    private  SearchResultPage searchResultPage;
    private ItemPage itemPage;
    private String ItemTitle;
    private CartPage cartPage;

    @Given("I am on the Amazon home page")
    public void iAmOnAnyPage() {
        driver.get(amazonURL);
    }
    @When("I am searching for {string}")
    public void iAmTypingItemName(String itemName) {
         searchResultPage = homePage.searchForItem(itemName);
    }
    @And("Choosing the first item")
    public void choosingTheFirstItem() {
        itemPage = searchResultPage.clickFirstItem();
        ItemTitle = itemPage.getItemTitle();
        System.out.println("Item title:"+ItemTitle);
    }

    @And("Adding the item to the cart")
    public void addingTheItemToTheCart() {
        itemPage.clickAddToCartButton();

    }
    @Then("The item should be added successfully in the cart")
    public void theItemShouldBeAddedSuccessfullyInTheCart() {
        cartPage = homePage.goToCart();
        String lastAddedItem = cartPage.getFirstCartItem();
        System.out.println("Item Title in Cart: "+ lastAddedItem);
        assertTrue(ItemTitle.contains(lastAddedItem),"Mismatched Titles");

    }
}
