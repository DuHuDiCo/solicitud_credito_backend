
package com.estudio_credito_preaprobado.estudio_credito.services;

import com.estudio_credito_preaprobado.estudio_credito.models.Cliente;
import com.estudio_credito_preaprobado.estudio_credito.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService{
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente actuaCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    
    public Cliente obtenerClienteById(Long id){
        return clienteRepository.findById(id).orElseThrow(()->new RuntimeException("Cliente no encontrado"));
    }
    
}
