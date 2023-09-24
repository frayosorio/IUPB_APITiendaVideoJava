package apitiendavideo.apitiendavideo.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.modelos.Alquiler;

public interface IAlquilerServicio {

    public List<Alquiler> listar();

    public Alquiler obtener(Long id);

    public List<Alquiler> buscarTitulo(String nombre);

    public List<Alquiler> buscarTercero(String nombre);

    public Alquiler guardar(Alquiler alquiler);

    public boolean eliminar(Long id);

    public boolean estaVencido(Long id);

}
