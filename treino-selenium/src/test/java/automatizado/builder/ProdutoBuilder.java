package automatizado.builder;

import automatizado.page.ControleDeProdutoPO;

public class ProdutoBuilder {
    private String codigo = "D0001";
    private String nome = "Produto X";
    private Integer quantidade = 1;
    private Double valor = 10.0;
    private String data = "01/04/2003";
    
    private ControleDeProdutoPO controleDeProdutoPO;
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }
    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }
    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }
    public ProdutoBuilder adicionarQuantitade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }
    public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return this;
    }
    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

    public void Builder(){
        controleDeProdutoPO.escrever( controleDeProdutoPO.inputCodigo, codigo);
        controleDeProdutoPO.escrever( controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever( controleDeProdutoPO.inputValor, (valor != null) ? valor.toString() : " ");
        controleDeProdutoPO.escrever( controleDeProdutoPO.inputQuantidade, (quantidade != null) ? quantidade.toString() : " ");
        controleDeProdutoPO.escrever( controleDeProdutoPO.inputData, data);

        controleDeProdutoPO.buttonSalvar.click();
    }
}
