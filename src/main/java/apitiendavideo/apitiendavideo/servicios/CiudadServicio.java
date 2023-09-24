package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.interfaces.ICiudadServicio;
import apitiendavideo.apitiendavideo.modelos.Ciudad;
import apitiendavideo.apitiendavideo.modelos.Tercero;
import apitiendavideo.apitiendavideo.repositorios.CiudadRepositorio;

@Service
public class CiudadServicio implements ICiudadServicio {


    private CiudadRepositorio repositorio;

    public CiudadServicio(CiudadRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @PersistenceContext
    public EntityManager em;

    @Override
    public List<Ciudad> listar() {
        return repositorio.findAll();
    }

    @Override
    public Ciudad obtener(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<Ciudad> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Ciudad guardar(Ciudad ciudad) {
        return repositorio.save(ciudad);
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
    public List<Tercero> buscarClientes(String nombre) {
        List<Tercero> terceros = em.createStoredProcedureQuery("fBuscarClientes", Tercero.class)
                .registerStoredProcedureParameter("nombreCiudad", String.class, ParameterMode.IN)
                .setParameter("nombreCiudad", nombre)
                .getResultList();

        return terceros;
    }

}
