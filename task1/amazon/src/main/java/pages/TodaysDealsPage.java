package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TodaysDealsPage {
    private WebDriver driver;
    private String rowIndex;
    private By seeMoreButton = By.linkText("See more");
    private WebDriverWait wait ;
    private static boolean buttonClicked= false;
    public TodaysDealsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 40);
    }
    public void clickSeeMoreButton() {
        //click seeMore first
        driver.findElement(seeMoreButton).click();
    }
    public void selectDepartment(String department) {
        // wait
        By departmentRadioButton = By.xpath("//div[@data-csa-c-element-id=\"filter-departments-"+department+"\"]//i");
        wait.until(ExpectedConditions.visibilityOfElementLocated(departmentRadioButton));
        //click radio button
        driver.findElement(departmentRadioButton).click();
    }
    public void selectDeal(String deal) {
        By dealRadioButton = By.xpath("//div[@data-csa-c-element-id=\"filter-percentOff-10% off or more\"]//i");
        WebElement dicountLabel = driver.findElement(By.id("percentOff"));
        // Scroll to discount section
        JavascriptExecutor js = (JavascriptExecutor) driver; // allows us to execute any js code
        String script = "arguments[0].scrollIntoView()"; //arguments[0] is a placeholder for tableWebElement
        js.executeScript(script, dicountLabel);
        driver.findElement(dealRadioButton).click();
    }
    public void scrollToRow(String rowIndex){
        this.rowIndex =rowIndex;
        String script = "window.scrollBy(0, 1000);"; // Scroll by 1000 pixels each time
        By selectedRow = By.xpath("//div[@data-index='"+rowIndex+"']");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean isElementVisible = false;
        while (!isElementVisible) {
            try {
                js.executeScript(script);
                WebElement element = driver.findElement(selectedRow);
                if (element.isDisplayed()) {
                    isElementVisible = true;
                }
            } catch (NoSuchElementException e) {
                // Element is not found yet, continue scrolling
            }
        }
    }
    public ItemPage selectRandomItem(){
        By item = By.xpath("(//div[@data-index='"+this.rowIndex+"']//div//div[@class=\"GridItem-module__container_PW2gdkwTj1GQzdwJjejN\"]//a)[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(item));
        driver.findElement(item).click();
        return new ItemPage(driver);
    }
}
