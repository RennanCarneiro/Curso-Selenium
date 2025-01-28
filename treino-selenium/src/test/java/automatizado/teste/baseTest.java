package automatizado.teste;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de herança para todas as classes de teste
 */
public abstract class baseTest {
    // driver navegador pagina atual
    protected static  WebDriver driver;
    //url do sistema
    private static final String URL_BASE = "http://127.0.0.1:5500/sistema/login.html";
    //caminho relativo do driver ao projeto to path
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver.exe";
    
    //metodo para iniciar o drive do nav. antes de todas as classes
    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    //metodo para fechar o drive do nav. depois de todas as classes
    @AfterClass
    public static void finalizar(){
        driver.quit();
    }
}
