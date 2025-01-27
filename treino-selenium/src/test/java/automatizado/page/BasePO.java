package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String obterTituloPagina(){
        return driver.getTitle();
    }

    public void escrever(WebElement input, String texto){
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }
}
