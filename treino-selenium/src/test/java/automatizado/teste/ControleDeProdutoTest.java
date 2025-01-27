package automatizado.teste;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends baseTest {
    
    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleProdutoPage;

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
        loginPage.executarLogin("admin@admin.com", "admin@123");
        controleProdutoPage = new ControleDeProdutoPO(driver);

        assertEquals(controleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }

    @Test
    public void TC001_AbrirModalParaCadastroEmClicar(){
        controleProdutoPage.buttonAdicionar.click();
        //TODO REMMOVER ESSE CLIQUE ASSIM QUE O SISTEMA FOR CORRIGIDO
        controleProdutoPage.buttonAdicionar.click();
        String titulo = controleProdutoPage.tituloModal.getText();

        assertEquals("Produto", titulo );
        controleProdutoPage.buttonSair.click();
        controleProdutoPage.buttonSair.click();
    }

    
    @Test
    public void TC002_naoCadastrarUmProdutoSemPreencherTodosOsCampos(){
        controleProdutoPage.buttonAdicionar.click();
        
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);
        String mensagem = "Todos os campos são obrigatórios para o cadastro!";
        produtoBuilder
        .adicionarData(" ")
        .Builder();
        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        produtoBuilder
        .adicionarNome(" ")
        .Builder();
        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        produtoBuilder
        .adicionarValor(null)
        .Builder();
        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        produtoBuilder
        .adicionarCodigo(" ")
        .Builder();
        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        produtoBuilder
        .adicionarQuantitade(null)
        .Builder();
        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        controleProdutoPage.buttonSair.click();
        
    }
     

    @Test
    public void TC003_CadastrarUmProdutoPreenchendoTodosOsCampos(){
        controleProdutoPage.buttonAdicionar.click();
        
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);
        produtoBuilder.Builder();
        
        String mensagem = controleProdutoPage.spanMensagem.getText();

        assertEquals("", mensagem);
    }



}
