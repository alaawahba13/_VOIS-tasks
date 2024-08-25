package steps;

import base.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.PaymentPage;
import pages.ReviewBookingPage;
import pages.TripDetailsPage;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class BookingTripSteps extends BaseTests {

    private static TripDetailsPage tripDetailsPage;
    private static ReviewBookingPage reviewBookingPage;
    private static PaymentPage paymentPage;

    // Select city and date
    @Given("I am on the KSRTC homepage")
    public void i_am_on_the_ksrtc_homepage() {
        driver.get(KSRTC_URL);
    }

    @When("I select Popular route {string}")
    public void i_select_the_first_popular_route(String route) {
        homePage.clickBookNow(route);
    }

    @And("I choose the {string}")
    public void i_choose_the_arrival_date(String arrivalDate) {
        List<String> date = Arrays.asList(arrivalDate.split("\\s*/\\s*"));
        tripDetailsPage = homePage.selectDate(date.get(0),date.get(1));
    }

    @Then("the available buses should be displayed")
    public void the_available_buses_should_be_displayed() {
        WebElement searchResults = tripDetailsPage.getResultContainer();
        assertTrue(searchResults.isDisplayed(), "Available buses should be displayed.");
    }

    // Select Seat
    @Given("I am on trip details page")
    public void iAmOnTripDetailsPage() {
    }

    @When("I select the seat {string}")
    public void i_select_the_seat(String seatNumber) {
        tripDetailsPage.selectSeat(seatNumber);
    }

    @And("I choose the {string} and {string}")
    public void i_choose_the_boarding_point_and_dropping_point(String boardingPoint, String droppingPoint) {
        tripDetailsPage.selectBoardingPoint(boardingPoint);
        tripDetailsPage.selectDropPoint(droppingPoint);
    }

    @Then("provide passenger details button should be displayed")
    public void provide_passenger_details_button_should_be_displayed() {
        // verify that the button is displayed
        boolean isDisplayed = tripDetailsPage.isPassengerDetailsBtnDisplayed();
        assertTrue(isDisplayed, "Provide passenger details button should be displayed");
    }

    // Fill info
    @Given("I have chosen boarding and dropping points")
    public void iHaveChosenBoardingAndDroppingPoints() {
        tripDetailsPage.clickPassengerDetailsBtn();
    }

    @When("I fill in the customer details with {string}, {string}, and  {string}")
    public void i_fill_in_the_customer_details(String countryCode, String phoneNumber, String email) {
        tripDetailsPage.fillCustomerDetails(countryCode, phoneNumber, email);
        Email = email;
        MobileNo = phoneNumber;
    }

    @And("I fill in the passenger details with {string},{string}, {string},{string},  {string},  {string}, and  {string}")
    public void i_fill_in_the_passenger_details(String name, String age, String gender, String concession, String idCard, String idCardNumber, String country) {
        tripDetailsPage.fillPassengerDetails(name, age, gender, concession, idCard, idCardNumber, country);

    }

    @Then("I should be taken to the review booking page")
    public void i_should_be_taken_to_the_review_booking_page() {
        reviewBookingPage = tripDetailsPage.clickCheckout();
        // assertions
        String reviewEmail = reviewBookingPage.getEmail();
        String reviewMobileNo = reviewBookingPage.getMobileNo();
        assertTrue(Email.contains(reviewEmail), "Incorrect email");
        assertTrue(MobileNo.contains(reviewMobileNo), "Incorrect mobileNo");
    }

    // Make Payment
    @Given("I'm on the review booking page")
    public void im_on_the_review_booking_page() {

    }

    @When("I click on Proceed to Pay")
    public void i_click_on_proceed_to_pay() {
        paymentPage = reviewBookingPage.clickProceedToPay();
    }

    @And("I choose payment method")
    public void iChoosePaymentMethodPaymentMethod() {
        paymentPage.choosePaymentMethod();
    }

    @Then("the payment page should be displayed")
    public void the_payment_page_should_be_displayed() {
        boolean isDisplayed = paymentPage.isQRDisplayed();
        assertTrue(isDisplayed, "QR Code should be displayed.");
    }


}