package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",   // Feature dosyalarımızın yolu
        glue = {"stepdefinitions"},                           // Step definition paketinin yolu
        plugin = {
                "pretty",                           // Konsol çıktısını daha okunur hale getirir
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        }
)
public class DataTablesEditorRunner {
    // Boş bırakabilirsiniz, Cucumber otomatik olarak bu Runner'ı kullanacak
}
//runner
