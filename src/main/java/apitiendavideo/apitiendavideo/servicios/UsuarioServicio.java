package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.interfaces.IUsuarioServicio;
import apitiendavideo.apitiendavideo.modelos.Usuario;
import apitiendavideo.apitiendavideo.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio implements IUsuarioServicio {

    private UsuarioRepositorio repositorio;

    public UsuarioServicio(UsuarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Usuario> listar() {
        return repositorio.findAll();
    }

    @Override
    public Usuario obtener(Long id) {
        var Usuario = repositorio.findById(id);
        return Usuario.isEmpty() ? null : Usuario.get();
    }

    @Override
    public List<Usuario> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Usuario guardar(Usuario Usuario) {
        return repositorio.save(Usuario);
    }

    @Override
    public boolean eliminar(Long id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Usuario validarUsuario(String usuario, String clave) {
        return repositorio.validarUsuario(usuario, clave);
    }
}
