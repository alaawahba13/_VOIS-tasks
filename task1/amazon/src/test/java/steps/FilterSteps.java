package steps;

import base.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.ItemPage;
import pages.TodaysDealsPage;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class FilterSteps extends BaseTests {

    private TodaysDealsPage todaysDealsPage;
    private CartPage cartPage;
    private String ItemTitle;

    @Given("I am on the Today's Deals Page")
    public void iAmOnTheTodaySDealsPage() {
        todaysDealsPage =  homePage.goToTodaysDdeals();
    }

    @When("I select the {string} and discount of {string}")
    public void iSelectTheDepartmentFilterAndDiscountOfDiscountFilter(String departmentFilter,String discountFilter) {
        todaysDealsPage.clickSeeMoreButton();
        List<String> departments = Arrays.asList(departmentFilter.split("\\s*\\+\\s*"));
        // Iterate over each department and apply the filter
        for (String department : departments) {
            // Code to select the department
            System.out.println(department);
            todaysDealsPage.selectDepartment(department);
        }
        todaysDealsPage.selectDeal(discountFilter);
        
    }

    @And("I navigate to the fourth page")
    public void iNavigateToTheFourthPage() {
        todaysDealsPage.scrollToRow("3");
    }

    @And("I select an item and add it to the cart")
    public void iSelectAnItemAndAddItToTheCart() {
       ItemPage itemPage =  todaysDealsPage.selectRandomItem();
        ItemTitle = itemPage.getItemTitle();
        System.out.println(ItemTitle);
        itemPage.clickAddToCartButton();
    }

    @Then("item should be in the cart")
    public void itemShouldBeInTheCart() {
        cartPage = homePage.goToCart();
        String originalTab = driver.getWindowHandle();
        ItemPage itemPage = cartPage.getFirstCartItem();
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(originalTab)) {
                // Switch to the new tab
                driver.switchTo().window(tab);
                break;
            }
        }
        System.out.println("Title of new tab: " + driver.getTitle());
        String lastAddedItem = itemPage.getItemTitle();
        System.out.println("Item Title in Cart: "+ lastAddedItem);
        driver.close();
        driver.switchTo().window(originalTab);
        assertTrue(ItemTitle.contains(lastAddedItem),"Mismatched Titles");
    }

}
