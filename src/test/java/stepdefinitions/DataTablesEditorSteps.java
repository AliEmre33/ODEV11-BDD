package stepdefinitions;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
//import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class DataTablesEditorSteps {
    // WebDriver driver = new ChromeDriver();
     private WebDriver driver;
    private WebDriverWait wait;
    private final String firstName = "Ali";
    private final String lastName = "Emre";
    private final String position = "Test Engineer";
    private final String office = "Mersin";
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("DataTables Editor demo sayfasina gidilir")
    public void datatablesEditorDemoSayfasinaGidilir() {
        driver.get("https://editor.datatables.net/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("Yeni bir kayit olusturulur")
    public void yeniBirKayitOlusturulur() {

        driver.findElement(By.cssSelector("button.dt-button.buttons-create")).click();

        driver.findElement(By.id("DTE_Field_first_name")).sendKeys(firstName);
        driver.findElement(By.id("DTE_Field_last_name")).sendKeys(lastName);
        driver.findElement(By.id("DTE_Field_position")).sendKeys(position);
        driver.findElement(By.id("DTE_Field_office")).sendKeys(office);
        driver.findElement(By.id("DTE_Field_extn")).sendKeys("1234");
        driver.findElement(By.id("DTE_Field_start_date")).sendKeys("2025-01-01");
        driver.findElement(By.id("DTE_Field_salary")).sendKeys("22000");


        driver.findElement(By.cssSelector(".btn")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("Olusturdugum kayit aranilir")
    public void olusturdugumKayitAranilir() {
        driver.findElement(By.cssSelector("input[type='search']"))
                .sendKeys(firstName + " " + lastName);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Then("Kaydin tablo listesinde gorundugu dogrulanir")
    public void kaydinTabloListesindeGorunduguDogrulanir() {
        WebElement tableBody = driver.findElement(By.cssSelector("table#example tbody"));
        String tableText = tableBody.getText();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isPresent = tableText.contains(firstName) && tableText.contains(lastName);
        Assert.assertTrue("Oluşturulan kayıt tabloda bulunamadı!", isPresent);
    }

}
