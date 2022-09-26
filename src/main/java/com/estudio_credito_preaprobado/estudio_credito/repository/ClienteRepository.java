

package com.estudio_credito_preaprobado.estudio_credito.repository;

import com.estudio_credito_preaprobado.estudio_credito.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
