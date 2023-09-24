package apitiendavideo.apitiendavideo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import apitiendavideo.apitiendavideo.modelos.Ciudad;
import apitiendavideo.apitiendavideo.modelos.Tecnologia;

public interface TecnologiaRepositorio extends JpaRepository<Tecnologia, Long>{
    
    @Query("SELECT t FROM Tecnologia t WHERE t.nombre like '%' || ?1 || '%'")
    List<Ciudad> buscar(String nombre);
}
