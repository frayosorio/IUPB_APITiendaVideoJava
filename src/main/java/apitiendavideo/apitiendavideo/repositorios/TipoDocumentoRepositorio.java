package apitiendavideo.apitiendavideo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import apitiendavideo.apitiendavideo.modelos.Tercero;
import apitiendavideo.apitiendavideo.modelos.TipoDocumento;

public interface TipoDocumentoRepositorio extends JpaRepository<TipoDocumento, Long>{
    
    @Query("SELECT td FROM TipoDocumento td WHERE td.tipo like '%' || ?1 || '%'")
    List<Tercero> buscar(String tipo);

}
