package projetoBase2.types;

import io.cucumber.java.ParameterType;
import projetoBase2.object.Produto;

public class CustomParameterTypes {

    @ParameterType(".*")
    public Produto produto (String nome ){
        return new Produto(nome);
    }


}
