package automatizado.teste;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.page.GooglePO;

public class GoogleTest extends baseTest{
    

    private static GooglePO googlepage;
    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://www.google.com/");
        googlepage = new GooglePO(driver);
        
    }

    @Test
    public void TCC001_pesquisarNoGoogle(){

        //arrange 
        //WebElement inputPesquisa = driver.findElement(By.name("q"));
        //googlepage.inputPesquisa.sendKeys("Pizza Margherita" + Keys.ENTER);
        googlepage.pesquisar("Pizza Margherita");
        //String resultado = driver.findElement(By.id("result-stats")).getText();
        //assertTrue(resultado, resultado.contains("Aproximadamente"));

    }

    @Test
    public void TC002_pesquisarNoGoogle(){
        //googlepage.inputPesquisa.sendKeys("Selenium" + Keys.ENTER);
        googlepage.pesquisar("Selenium java");
        //String resultadoString = googlepage.divResultadoPesquisa.getText();
       // String resultado = googlepage.obterResultadoPesquisa();
    }
}
