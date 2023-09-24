package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import apitiendavideo.apitiendavideo.interfaces.IAlquilerServicio;
import apitiendavideo.apitiendavideo.modelos.Alquiler;
import apitiendavideo.apitiendavideo.repositorios.AlquilerRepositorio;

public class AlquilerServicio implements IAlquilerServicio {

    private AlquilerRepositorio repositorio;

    public AlquilerServicio(AlquilerRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Alquiler> listar() {
        return repositorio.findAll();
    }

    @Override
    public Alquiler obtener(Long id) {
        var Alquiler = repositorio.findById(id);
        return Alquiler.isEmpty() ? null : Alquiler.get();
    }


    @Override
    public Alquiler guardar(Alquiler Alquiler) {
        return repositorio.save(Alquiler);
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
    public List<Alquiler> buscarTitulo(String nombre) {
        return null;
    }

    @Override
    public List<Alquiler> buscarTercero(String nombre) {
        return null;
    }

    @Override
    public boolean estaVencido(Long id) {
        return false;
    }

}
