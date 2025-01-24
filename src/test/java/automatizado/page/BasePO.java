package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

    /*
     * classe base para criação das pagesObj
     * todas as pages devem ser herdadas dessa classe
     */
public abstract class BasePO {
    /*driver base que será usado pelas pages */
    protected WebDriver driver;

    /**
     * Construtor base para criação da frabrica de elementos (PageFactory)
     * @param driver driver da pagina atual
     */
    protected BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
