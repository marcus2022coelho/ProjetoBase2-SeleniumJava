package projetoBase2.utils;

import lombok.Data;
import projetoBase2.Enum.PerfilUsuario;

@Data
public class Usuario {
    private String Usuario;
    private String Senha;

    public Usuario(PerfilUsuario perfil){
        if (perfil.equals(PerfilUsuario.ADMINISTRATOR)){
            setUsuario("administrator");
            setSenha("abc123");
        }
        //utilizando password do administrador
        if (perfil.equals(PerfilUsuario.USERFAILED)){
            setUsuario("administratorr");

        }
        //utilizando user do administrador
        if (perfil.equals(PerfilUsuario.PASSWFAILED)){
            setSenha("abc1234");
        }

    }
}
