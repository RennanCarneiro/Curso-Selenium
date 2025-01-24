package automatizado.teste;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GoogleTest extends baseTest{

    @Test
    public void pesquisarNoGoogle(){

        //arrange 
        WebElement inputPesquisa = driver.findElement(By.name("q"));
        inputPesquisa.sendKeys("Pizza Margherita" + Keys.ENTER);

        //String resultado = driver.findElement(By.id("result-stats")).getText();
        //assertTrue(resultado, resultado.contains("Aproximadamente"));

    }
}
