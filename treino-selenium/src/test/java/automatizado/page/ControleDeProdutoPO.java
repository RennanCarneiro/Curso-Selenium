package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object da página de controle de produtos
 */ 
public class ControleDeProdutoPO extends BasePO{
    //#region WebElements
    @FindBy(id = "btn-adicionar")
    public WebElement buttonAdicionar;

    @FindBy(css = "ul>li>a.nav-link")
    private WebElement linkVoltar;

    @FindBy(css = "div.modal-header>h4")
    public WebElement tituloModal;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id = "btn-sair")
    public WebElement buttonSair;

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;
    //#endregion WebElements
    
    //#region Métodos
    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Método que irá cadastrar um produto
     * @param codigo 
     * @param nome
     * @param valor
     * @param quantidade
     * @param data
     */
    public void cadastrarProduto(String codigo, String nome, Double valor, Integer quantidade, String data){
        escrever(inputCodigo, codigo);
        escrever(inputNome, nome);
        escrever(inputValor, valor.toString());
        escrever(inputQuantidade, quantidade.toString());
        escrever(inputData, data);

        buttonSalvar.click();
    }
    //#endregion Métodos
}
