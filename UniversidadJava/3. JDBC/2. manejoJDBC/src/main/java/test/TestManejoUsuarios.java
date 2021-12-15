package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;

public class TestManejoUsuarios {
    
    public static void main(String[] args) {
        
        UsuarioDAO usuariosDao = new UsuarioDAO();
        
        Usuario usuario1 = new Usuario("santini@gmail.com","santini123");
        int registro = usuariosDao.insertar(usuario1);
        System.out.println("registro = " + registro);

        Usuario usuarioNuevo = new Usuario(1, "santihs.sanchez@gmail.com", "santihs123");
        usuariosDao.editar(usuarioNuevo);
        
//        usuariosDao.eliminar(3);
        
        List<Usuario> usuarios = usuariosDao.seleccionar();
        
        usuarios.forEach(usuario -> {
            System.out.println("usuariosDao = " + usuario);
        });
        
    }
    
}
