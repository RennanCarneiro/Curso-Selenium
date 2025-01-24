package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO{

    @FindBy(name = "q")
    public WebElement inputPesquisa;

    @FindBy(id = "result-stats")
    public WebElement divResultadoPesquisa;
    /**
     * construtor para criação da pagina do google
     * @param driver driver pagina do google
     */
    public GooglePO(WebDriver driver) {
        super(driver);
    }

    /**
     * Metodo que irá efetuar uma pesquisa no google baseado no texto informado
     * @param texto texto a ser pesdquisado
     */
    public void pesquisar(String texto){
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }
    
    /**
     * metodo que retorna o resultado da pesquisa
     * @return
     */
    public String obterResultadoPesquisa(){
        return divResultadoPesquisa.getText();
    }
}
