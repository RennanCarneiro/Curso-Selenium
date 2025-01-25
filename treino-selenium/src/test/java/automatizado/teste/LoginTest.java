package automatizado.teste;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends baseTest{
    
    private static LoginPO loginPage;


    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TCC001_naoLoginComSenhaVaziaEmailVazio(){
        loginPage.executarLogin("", "");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }
    @Test
    public void TCC002_naoLoginComSenhaVaziaEmailIncorreto(){
        loginPage.executarLogin("email", "");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }
    @Test
    public void TCC003_naoLoginComSenhaIncorretaEmailVazio(){
        loginPage.executarLogin("", "teste");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }
    @Test
    public void TCC004_naoLoginComSenhaIncorretaEmailIncorreto(){
        loginPage.executarLogin("teste", "teste");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "E-mail ou senha inválidos");
    }
    @Test
    public void TCC005_naoLoginComSenhaIncorreta(){
        loginPage.executarLogin("admin@admin.com", "teste");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "E-mail ou senha inválidos");
    }
    @Test
    public void TCC006_naoLoginComEmailIncorreto(){
        loginPage.executarLogin("Addmin@admin.com", "admin@123");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "E-mail ou senha inválidos");
    }
    @Test
    public void TCC007_loginComSenhaEmailCorretos(){
        loginPage.executarLogin("admin@admin.com", "admin@123");
        assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");
    }

}
