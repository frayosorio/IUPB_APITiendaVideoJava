package apitiendavideo.apitiendavideo.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.modelos.Usuario;

public interface IUsuarioServicio {

    public List<Usuario> listar();

    public Usuario obtener(Long id);

    public Usuario validarUsuario(String usuario, String clave);

    public List<Usuario> buscar(String nombre);

    public Usuario guardar(Usuario Usuario);

    public boolean eliminar(Long id);
}
