package apitiendavideo.apitiendavideo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import apitiendavideo.apitiendavideo.modelos.Tercero;

public interface TerceroRepositorio extends JpaRepository<Tercero, Long> {

    @Query("SELECT t FROM Tercero t WHERE t.nombre like '%' || ?1 || '%'")
    List<Tercero> buscar(String nombre);

}