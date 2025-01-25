package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO  extends BasePO{

    @FindBy(id = "email")
    public WebElement inputEmail;
    @FindBy(id = "senha")
    public WebElement inputSenha;
    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;
    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;

    public LoginPO(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    /**
     * Metodo que irá escrever um texto em um campo de texto
     * @param input campo de texto
     * @param texto texto a ser escrito
     */
    public void escrever(WebElement input, String texto){
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }
    /**
     * Metodo que irá obter a mensagem de erro
     * @return
     */
    public String obterMensagem(){
        return this.spanMensagem.getText();
    }
    /**
     * Metodo que irá efetuar o login no sistema
     * @param email email para login
     * @param senha senha para login
     */
    public void executarLogin(String email, String senha){
        escrever(inputEmail, email);
        escrever(inputSenha, senha);

        buttonEntrar.click();
    }
    public String obterTituloPagina(){
        return driver.getTitle();
    }
}
