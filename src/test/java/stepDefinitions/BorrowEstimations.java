package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

public class BorrowEstimations {

    WebDriver driver;

    @After
    public void tearDown() {
        System.out.println("Entered Tear down");
        driver.quit();
    }

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {

        //Create Chrome browser instance
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Maximise the browser
        driver.manage().window().maximize();
    }

    @When("I open ANZ calculation page")
    public void i_open_anz_calculation_page() {

        //Enter the URL in browser's address bar
        driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
    }

    @Then("I verify borrowing estimate")
    public void i_verify_borrowing_estimate() throws Exception {

        int borrowEst = 479000; //Actual Borrow Estimate

        try {
            //Selecting application type
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@for='application_type_single']")));
            driver.findElement(By.xpath("//*[@for='application_type_single']")).click();
            System.out.println("Clicked on Application type is Single");

            //Select dependent from dropdown
            new Select(driver.findElement(By.xpath("//select[@title='Number of dependants']"))).selectByIndex(0);
            System.out.println("Selected dependent as 0");

            //Selecting property type to buy
            driver.findElement(By.xpath("//label[@for='borrow_type_home']")).click();
            System.out.println("Selected property to buy as 'Home to live in'");

            //Enter income before tax
            driver.findElement(By.xpath("//input[@aria-labelledby='q2q1']")).sendKeys("80000");
            System.out.println("Entered income $80,000");

            //Enter other incomes
            driver.findElement(By.xpath("//input[@aria-labelledby='q2q2']")).sendKeys("10000");
            System.out.println("Entered other income $10,000");

            //Enter living expenses
            driver.findElement(By.xpath("//input[@aria-labelledby='q3q1']")).sendKeys("500");
            System.out.println("Entered living expenses $500");

            //Enter Home loan
            driver.findElement(By.xpath("//input[@aria-labelledby='q3q2']")).sendKeys("0");
            System.out.println("Entered home loan $0");

            //Enter other loan
            driver.findElement(By.xpath("//input[@aria-labelledby='q3q3']")).sendKeys("100");
            System.out.println("Entered other loans $100");

            //Enter other commitment expenses
            driver.findElement(By.xpath("//input[@aria-labelledby='q3q4']")).sendKeys("0");
            System.out.println("Entered other commitments $0");

            //Enter Credit limit
            driver.findElement(By.xpath("//input[@aria-labelledby='q3q5']")).sendKeys("10000");
            System.out.println("Entered credit limit as $10,000");

            //Click on How much I can borrow button
            driver.findElement(By.xpath("//button[@id='btnBorrowCalculater']")).click();
            System.out.println("Clicked on How much I can Borrow button");
            Thread.sleep(5000);

            //Print the borrow limit calculated
            String borrowCal = driver.findElement(By.xpath("//span[@id='borrowResultTextAmount']")).getText();

            //Remove special characters and coma using Number format
            NumberFormat format = NumberFormat.getCurrencyInstance();
            Number num = format.parse(borrowCal);
            System.out.println("Calculated borrow limit is " + num.toString());
            System.out.println("Actual borrow limit is " + borrowEst);

            //Compare Actual borrow limit with calculated borrow limit
            int i = Integer.parseInt(String.valueOf(num));
            boolean testPassed = false;
            if (borrowEst == i) {
                System.out.println("Borrow Estimation is correct");
            } else {
                throw new AssertionError("Borrow Estimation is incorrect");
            }
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Then("I enter calculation data")
    public void i_enter_calculation_data() throws Exception {
        try {
            //Selecting application type
            driver.findElement(By.xpath("//*[@for='application_type_single']")).click();
            System.out.println("Clicked on Application type is Single");

            //Select dependent from dropdown
            new Select(driver.findElement(By.xpath("//select[@title='Number of dependants']"))).selectByIndex(0);
            System.out.println("Selected dependent as 0");

            //Selecting property type to buy
            driver.findElement(By.xpath("//label[@for='borrow_type_home']")).click();
            System.out.println("Selected property to buy as 'Home to live in'");

            //Enter income before tax
            driver.findElement(By.xpath("//input[@aria-labelledby='q2q1']")).sendKeys("80000");
            System.out.println("Entered income $80,000");

            //Enter other incomes
            driver.findElement(By.xpath("//input[@aria-labelledby='q2q2']")).sendKeys("10000");
            System.out.println("Entered other income $10,000");

            //Enter living expenses
            driver.findElement(By.xpath("//input[@aria-labelledby='q3q1']")).sendKeys("500");
            System.out.println("Entered living expenses $500");

            //Enter home loan
            driver.findElement(By.xpath("//input[@aria-labelledby='q3q2']")).sendKeys("0");
            System.out.println("Entered home loan $0");

            //Enter other loans
            driver.findElement(By.xpath("//input[@aria-labelledby='q3q3']")).sendKeys("100");
            System.out.println("Entered other loans $100");

            //Enter oother commitments
            driver.findElement(By.xpath("//input[@aria-labelledby='q3q4']")).sendKeys("0");
            System.out.println("Entered other commitments $0");

            //Enter credit limits
            driver.findElement(By.xpath("//input[@aria-labelledby='q3q5']")).sendKeys("10000");
            System.out.println("Entered credit limit as $10,000");

            //Click on How much I can borrow button
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='btnBorrowCalculater']")));
            driver.findElement(By.xpath("//button[@id='btnBorrowCalculater']")).click();
            System.out.println("Clicked on How much I can Borrow button");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @And("I clear the form")
    public void i_clear_the_form() throws Exception {

        try {
            //Click on the Start over button
            WebDriverWait wait = new WebDriverWait(driver, 15);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='start-over'])[1]")));
            driver.findElement(By.xpath("(//button[@class='start-over'])[1]")).click();
            System.out.println("Clicked on Start over button");
            Thread.sleep(5000);

            //Verifying if the fields are cleared after clicking start over
            String a = driver.findElement(By.xpath("//input[@aria-labelledby='q2q1']")).getAttribute("value");
            int Income = Integer.parseInt(String.valueOf(a));
            if (Income == 0) {
                System.out.println("Income field is cleared");
            } else {
                throw new AssertionError("Income field is not cleared");
            }

            String b = driver.findElement(By.xpath("//input[@aria-labelledby='q3q1']")).getAttribute("value");
            int OtherIncome = Integer.parseInt(String.valueOf(b));
            if (OtherIncome == 0) {
                System.out.println("Other income field is cleared");
            } else {
                throw new AssertionError("Other income field is not cleared");
            }

            String c = driver.findElement(By.xpath("//input[@aria-labelledby='q3q1']")).getAttribute("value");
            int LivingExpense = Integer.parseInt(String.valueOf(c));
            if (LivingExpense == 0) {
                System.out.println("Living expenses field is cleared");
            } else {
                throw new AssertionError("Living expenses field is not cleared");
            }

            String d = driver.findElement(By.xpath("//input[@aria-labelledby='q3q2']")).getAttribute("value");
            int HomeLoan = Integer.parseInt(String.valueOf(d));
            if (HomeLoan == 0) {
                System.out.println("Current home loan field is cleared");
            } else {
                throw new AssertionError("Current home loan field is not cleared");
            }

            String e = driver.findElement(By.xpath("//input[@aria-labelledby='q3q3']")).getAttribute("value");
            int OtherLoan = Integer.parseInt(String.valueOf(e));
            if (OtherLoan == 0) {
                System.out.println("Other loan field is cleared");
            } else {
                throw new AssertionError("Other loan field is not cleared");
            }

            String f = driver.findElement(By.xpath("//input[@aria-labelledby='q3q4']")).getAttribute("value");
            int Commitment = Integer.parseInt(String.valueOf(f));
            if (Commitment == 0) {
                System.out.println("Other commitment field is cleared");
            } else {
                throw new AssertionError("Other commitment field is not cleared");
            }

            String g = driver.findElement(By.xpath("//input[@aria-labelledby='q3q5']")).getAttribute("value");
            int CreditLimit = Integer.parseInt(String.valueOf(g));
            if (CreditLimit == 0) {
                System.out.println("Credit Limit field is cleared");
            } else {
                throw new AssertionError("Credit Limit field is not cleared");
            }
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Then("I enter living expenses to one dollar")
    public void i_enter_living_expenses_to_one_dollar() throws Exception {

        //Enter living expenses
        driver.findElement(By.xpath("//input[@aria-labelledby='q3q1']")).sendKeys("1");
        System.out.println("Entered living expenses $1");

        //Clicking on how much I can borrow
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='btnBorrowCalculater']")));
        driver.findElement(By.xpath("//button[@id='btnBorrowCalculater']")).click();
        System.out.println("Clicked on How much I can Borrow button");
    }

    @Then("I verify the message")
    public void i_verify_the_message() throws Exception {

        //Verify if the message is displayed properly
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='borrow__error__text']")));
        if (driver.findElement(By.xpath("//span[@class='borrow__error__text']")).isDisplayed()) {
            System.out.println("The message is displayed properly");
        } else {
            throw new AssertionError("The message is not displayed");
        }
    }


    @And("close browser")
    public void close_browser() {

        //Close the browser
        driver.quit();
    }
}
