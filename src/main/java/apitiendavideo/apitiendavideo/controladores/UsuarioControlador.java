package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.interfaces.IUsuarioServicio;
import apitiendavideo.apitiendavideo.modelos.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    private IUsuarioServicio servicio;

    public UsuarioControlador(IUsuarioServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Usuario> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Usuario obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Usuario> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @RequestMapping(value = "/validar/{usuario}/{clave}", method = RequestMethod.GET)
    public Usuario validarUsuario(@PathVariable String usuario, @PathVariable String clave) {
        return servicio.validarUsuario(usuario, clave);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Usuario crear(@RequestBody Usuario Usuario) {
        Usuario.setId(0);
        return servicio.guardar(Usuario);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Usuario actualizar(@RequestBody Usuario Usuario) {
        if (servicio.obtener(Usuario.getId()) != null) {
            return servicio.guardar(Usuario);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }

}
