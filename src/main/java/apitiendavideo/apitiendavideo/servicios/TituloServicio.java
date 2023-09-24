package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.interfaces.ITituloServicio;
import apitiendavideo.apitiendavideo.modelos.Titulo;
import apitiendavideo.apitiendavideo.repositorios.TituloRepositorio;

@Service
public class TituloServicio implements ITituloServicio {

    private TituloRepositorio repositorio;

    @PersistenceContext
    public EntityManager em;

    public TituloServicio(TituloRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Titulo> listar() {
        return repositorio.findAll();
    }

    @Override
    public Titulo obtener(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<Titulo> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Titulo guardar(Titulo empresa) {
        return repositorio.save(empresa);
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

}
