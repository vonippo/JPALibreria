/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Cliente;
import java.util.List;
import javax.persistence.EntityManager;

public class ClienteDAO extends DAO<Cliente> {

    @Override
    public void persistirEntidad(Cliente cliente) {
        super.persistirEntidad(cliente);
    }

    @Override
    public void actualizarEntidad(Cliente cliente) {
        super.actualizarEntidad(cliente);
    }

    @Override
    public void borrarEntidad(Cliente cliente) {
        super.borrarEntidad(cliente);
    }

    public Cliente buscarCliente(Integer id) {
        conectarBase();
        Cliente cliente = EntityManager.find(Cliente.class, id);
        desconectarBase();
        return cliente;
    }

    public List<Cliente> buscarClienteNombre(String nombre) {
        conectarBase();
        List<Cliente> clientes = EntityManager.createQuery("SELECT c FROM Cliente c where c.nombre = :nombre c.alta = TRUE").setParameter("nombre", nombre).getResultList();
        desconectarBase();
        return clientes;
    }

    public List<Cliente> buscarClienteDocumento(long dni) {
        conectarBase();
        List<Cliente> clientes = EntityManager.createQuery("SELECT c FROM Cliente c where c.documento = :documento AND c.alta = TRUE").setParameter("documento", dni).getResultList();
        desconectarBase();
        return clientes;
    }

    public Cliente buscarClienteId(Long id) {
        conectarBase();
        Cliente cliente = EntityManager.find(Cliente.class, id);
        desconectarBase();
        return cliente;
    }
}