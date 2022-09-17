

package com.estudio_credito_preaprobado.estudio_credito.repository;

import com.estudio_credito_preaprobado.estudio_credito.models.ERol;
import com.estudio_credito_preaprobado.estudio_credito.models.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    
    Optional<Rol> findByNombre(ERol nombre);

}
