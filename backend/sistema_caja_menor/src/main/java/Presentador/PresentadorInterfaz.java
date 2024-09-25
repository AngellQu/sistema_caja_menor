package Presentador;

import DTOs.DTOs;

public interface PresentadorInterfaz {

    Integer insertarEntidad(String tipo);

    Integer consultarEntidad(String tipo);

    void actualizarEntidad(String tipo);
    
    void eliminarEntidad(String tipo);
 
    DTOs crearDTO(String tipo);
}
