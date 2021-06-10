import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeleniumTest {

    WebDriver driver;

    @BeforeAll
    void setupTest() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver90.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Aguarda até 5 segundos o carregamento dos elementos da página antes de gerar um erro.

        driver.manage().window().maximize();
        //Maximiza a janela do navegador.
    }

    @Test
    @DisplayName("Brazil Independence Doodle 2020")
    void doodleSearch() {
        driver.get("https://www.google.com/doodles?hl=en");
        //Página onde serão realizados os testes.

        driver.findElement(By.id("searchinput")).sendKeys("7 setembro", Keys.ENTER);
        //Realiza uma busca por "7 setembro" na caixa de pesquisa.

        driver.navigate().refresh();
        //Atualiza a página para que o elemento correto seja selecionado.

        assertEquals("Brazil Independence Day 2020", driver.findElement(By.xpath("//div[@class='info']/div[@class='title']/a")).getAttribute("title"));
        //Compara o valor esperado "Brazil Independence Day 2020" com o obtido do elemento buscado por XPath.
    }

    @AfterAll
    void endTest() {
        driver.quit(); //Fecha o navegador após os testes.
    }
}