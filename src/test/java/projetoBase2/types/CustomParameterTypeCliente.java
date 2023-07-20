package projetoBase2.types;

import io.cucumber.java.ParameterType;
import projetoBase2.object.Cliente;

public class CustomParameterTypeCliente {
    @ParameterType(".*")
    public Cliente cliente (String username, String password){
        return new Cliente(username, password);
    }
}
